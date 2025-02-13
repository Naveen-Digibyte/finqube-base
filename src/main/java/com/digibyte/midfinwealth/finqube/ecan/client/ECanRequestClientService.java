package com.digibyte.midfinwealth.finqube.ecan.client;

import com.digibyte.midfinwealth.finqube.constants.ErrorConstants;
import com.digibyte.midfinwealth.finqube.ecan.enums.*;
import com.digibyte.midfinwealth.finqube.ecan.payload.*;
import com.digibyte.midfinwealth.finqube.exceptions.ECanException;
import com.digibyte.midfinwealth.finqube.model.ECanBankDetails;
import com.digibyte.midfinwealth.finqube.model.ECanNomineeDetail;
import com.digibyte.midfinwealth.finqube.model.ECanRequestModel;
import com.digibyte.midfinwealth.finqube.model.ECanResponseModel;
import com.digibyte.midfinwealth.finqube.repo.BankDetailsRepo;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sid, Naveen
 *
 * History:
 * -08-01-2025 <Sid> ECanRequestClientService
 *      - InitialVersion
 * -12-02-2025 <NaveenDhanasekaran>
 *      - Alter sendCanIndFillEezzRequest method
 */

@Service
@RequiredArgsConstructor
public class ECanRequestClientService {

    private final RestTemplate restTemplate;
    private final BankDetailsRepo bankDetailsRepo;

    @Value("${eCAN.api.url}")
    private String apiUrl;

    @Value("${finqube.entityId}")
    private String entityId;
    @Value("${finqube.uniqueId}")
    private String uniqueId;
    @Value("${finqube.requestType}")
    private String requestType;
    @Value("${finqube.loginUserId}")
    private String loginUserId;
    @Value("${finqube.version}")
    private String version;
    @Value("${finqube.password}")
    private String password;
    @Value("${finqube.entityEmail}")
    private String entityEmail;

    public ECanResponseModel createECanForIndividual(ECanRequestModel eCanRequestModel) {
        CanIndFillEezzReq canIndFillEezzReq = new CanIndFillEezzReq();

        ReqHeader reqHeader = createReqHeader();
        ReqBody reqBody = createReqBody(eCanRequestModel);

        canIndFillEezzReq.setReqHeader(reqHeader);
        canIndFillEezzReq.setReqBody(reqBody);

        try {
            String xmlPayload = convertObjectToXml(canIndFillEezzReq);
            HttpHeaders headers = new HttpHeaders();
            headers.setContentType(MediaType.APPLICATION_XML);
            HttpEntity<String> request = new HttpEntity<>(xmlPayload, headers);

            String xmlResponse = restTemplate.exchange(
                    apiUrl,
                    HttpMethod.POST,
                    request,
                    String.class
            ).getBody();

            CANIndFillEezzResp canIndFillEezzResp = convertXmlToJson(xmlResponse);

            if (canIndFillEezzResp.getRespBody().getCan() == null || canIndFillEezzResp.getRespBody().getCan().isEmpty() || canIndFillEezzResp.getRespBody().getCan().isBlank()) {
                throw new ECanException(canIndFillEezzResp.getRespHeader().getResMsg());
            }

            return new ECanResponseModel(null, new ECanResponseModel.RespBody(
                    canIndFillEezzResp.getRespBody().getCan(),
                    canIndFillEezzResp.getRespBody().getProofUploadLink(),
                    canIndFillEezzResp.getRespBody().getNomVerLinkH1(),
                    canIndFillEezzResp.getRespBody().getNomVerLinkH2(),
                    canIndFillEezzResp.getRespBody().getNomVerLinkH3()
            ));

        } catch (ECanException exception) {
            throw new ECanException(exception.getMessage());
        } catch (Exception ex) {
            throw new ECanException(ErrorConstants.E_0008);
        }
    }

    private ReqHeader createReqHeader() {
        ReqHeader reqHeader = new ReqHeader();
        reqHeader.setEntityId(entityId);
        reqHeader.setUniqueId(uniqueId);
        reqHeader.setRequestType(requestType);
        reqHeader.setLogUserId(loginUserId);
        reqHeader.setEnEncrPassword(password);
        reqHeader.setVersionNo(version);
        reqHeader.setTimestamp(LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd'T'HH:mm:ss")));
        return reqHeader;
    }

    private ReqBody createReqBody(ECanRequestModel eCanRequestModel) {
        ReqBody reqBody = new ReqBody();
        reqBody.setReqEvent(RequestEvent.CR);
        reqBody.setRegType(RegistrationType.E);
        reqBody.setProofUploadByCan(ConfirmationStatus.Y);
        reqBody.setEnableOnlineAccessFlag(ConfirmationStatus.Y);
        reqBody.setEntityEmailDetails(new EntityEmailDetails(entityEmail));
        reqBody.setHoldingType(eCanRequestModel.getHoldingType());
        reqBody.setInvCategory(eCanRequestModel.getInvestorCategory());
        reqBody.setTaxStatus(eCanRequestModel.getTaxStatus());
        reqBody.setHolderCount(eCanRequestModel.getHolders());
        reqBody.setHolderRecords(new HolderRecords(createHolderRecords(eCanRequestModel)));
        reqBody.setBankDetails(getBankDetails(eCanRequestModel.getBankDetails()));
        reqBody.setNomineeDetails(getNomineeDetails(eCanRequestModel.getECanNomineeDetails()));
        return reqBody;
    }

    private List<HolderRecord> createHolderRecords(ECanRequestModel eCanRequestModel) {
        HolderRecord holderRecord = new HolderRecord(
                HolderType.PR, eCanRequestModel.getName(), eCanRequestModel.getDateOfBirth().toString(),
                ConfirmationStatus.N, eCanRequestModel.getPan(),
                new ContactDetail(eCanRequestModel.getMobileNumber(), eCanRequestModel.getMobileNumberDeclaration(),
                        eCanRequestModel.getEmail(), eCanRequestModel.getEmailDeclaration()),
                new FATCADetail()
        );
        return List.of(holderRecord);
    }

    private NomineeDetails getNomineeDetails(@NotEmpty(message = ErrorConstants.E_0035) @Valid List<ECanNomineeDetail> eCanNomineeDetails) {
        NomineeDetails nomineeDetails = new NomineeDetails();
        nomineeDetails.setNomDeclLvl(NomineeDeclaration.C);
        nomineeDetails.setNominOptFlag(NomineeOptionFlag.CHECKED);
        nomineeDetails.setNomVerifyType(NomineeVerificationType.NOMINEE_2FA);

        List<NomineeRecord> nomineeRecords = new ArrayList<>();
        for (ECanNomineeDetail nomineeDetail : eCanNomineeDetails) {
            NomineeRecord nomineeRecord = new NomineeRecord();
            nomineeRecord.setNomineeName(nomineeDetail.getName());
            nomineeRecord.setDob(String.valueOf(nomineeDetail.getDateOfBirth()));
            nomineeRecord.setRelation(nomineeDetail.getNomineeRelation());
            nomineeRecord.setPercentage(nomineeDetail.getPercentage());
            nomineeRecords.add(nomineeRecord);
        }

        nomineeDetails.setNomineesRecords(nomineeRecords);
        return nomineeDetails;
    }

    private BankDetails getBankDetails(@NotEmpty(message = ErrorConstants.E_0032) @Valid List<ECanBankDetails> bankDetails) {
        List<BankRecord> bankRecords = new ArrayList<>();
        for (int i = 0; i < bankDetails.size(); i++) {
            BankRecord bankRecord = new BankRecord();
            bankRecord.setSeqNum(i);
            bankRecord.setDefaultAccFlag(ConfirmationStatus.Y);
            bankRecord.setAccountNo(bankDetails.get(i).getBankAccNo());
            bankRecord.setAccountType(bankDetails.get(i).getAccountType());

            bankDetailsRepo.findByBankName(bankDetails.get(i).getBankName())
                    .ifPresentOrElse(bank -> {
                        bankRecord.setBankId(bank.getBankId());
                    }, () -> {
                        throw new ECanException(ErrorConstants.E_0033); // handle case when bank not found
                    });

            bankRecord.setMicrCode(bankDetails.get(i).getMicrCode());
            bankRecord.setIfscCode(bankDetails.get(i).getIfscCode());
            bankRecord.setProof(bankDetails.get(i).getBankProof());
            bankRecords.add(bankRecord);
        }
        return new BankDetails(bankRecords);
    }

    private String convertObjectToXml(Object obj) throws ECanException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.writeValueAsString(obj);
        } catch (Exception ex) {
            throw new ECanException(ErrorConstants.E_0009);
        }
    }

    private CANIndFillEezzResp convertXmlToJson(String xml) throws ECanException {
        try {
            XmlMapper xmlMapper = new XmlMapper();
            return xmlMapper.readValue(xml, CANIndFillEezzResp.class);
        } catch (Exception ex) {
            throw new ECanException(ErrorConstants.E_0010);
        }
    }
}