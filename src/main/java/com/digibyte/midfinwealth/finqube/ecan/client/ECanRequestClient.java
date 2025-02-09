package com.digibyte.midfinwealth.finqube.ecan.client;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.digibyte.midfinwealth.finqube.ecan.payload.CANIndFillEezzResp;
import com.digibyte.midfinwealth.finqube.ecan.payload.CanIndFillEezzReq;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.dataformat.xml.XmlMapper;

@Service
public class ECanRequestClient {

    private final RestTemplate restTemplate = new RestTemplate();

    public String sendCanIndFillEezzRequest(CanIndFillEezzReq requestPayload) throws Exception {
        // Convert the object to XML string
        String xmlPayload = convertObjectToXml(requestPayload);
        System.out.println("XML Payload: " + xmlPayload);

        // Set headers
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_XML);
        headers.set("Cookie", "JSESSIONID=3041358A1E918ACB9A133B2B5FFBDFBA");

        // Create the request entity
        HttpEntity<String> request = new HttpEntity<>(xmlPayload, headers);

        // Send POST request and get the response as XML
        String xmlResponse = restTemplate.postForObject(
                "https://test.mfuonline.com:4091/MFUCanFillEezzService",
                request,
                String.class
        );

        // Convert the XML response to JSON
        String jsonResponse = convertXmlToJson(xmlResponse);

        return jsonResponse;
    }

    // Convert Java object to XML String using Jackson XmlMapper
    private String convertObjectToXml(Object obj) throws Exception {
        XmlMapper xmlMapper = new XmlMapper();
        return xmlMapper.writeValueAsString(obj);
    }

    // Convert XML String to JSON String using XmlMapper and ObjectMapper
    private String convertXmlToJson(String xml) throws Exception {
        // Deserialize the XML into the response object
        XmlMapper xmlMapper = new XmlMapper();
        CANIndFillEezzResp response = xmlMapper.readValue(xml, CANIndFillEezzResp.class);

        // Convert the response object to JSON
        ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(response);
    }
}

