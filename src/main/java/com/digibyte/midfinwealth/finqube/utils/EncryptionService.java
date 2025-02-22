package com.digibyte.midfinwealth.finqube.utils;

import java.io.UnsupportedEncodingException;
import java.security.*;
import java.util.Base64;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @author Naveen
 *
 * History:
 * -20-02-2025 <NaveenDhanasekaran> EncryptionService
 *      - InitialVersion
 */

@Component
public class EncryptionService {

	private static Logger logger = LogManager.getLogger(EncryptionService.class);

	private final static String PADNG_TYPE = "AES/CBC/PKCS7Padding";
	private final static String ENCODE_TYPE = "UTF-8";
	private final static String ENCODE_STANDERD = "AES";
	private static final String BC = "BC";
	
	@Value("${mfu.public-key}")
	private String publicKey;

	@Value("${mfu.iv-key}")
	private String ivKey;

	public String encrypt(String plainText) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
			Cipher cipher = getCipher(Cipher.ENCRYPT_MODE);
			byte[] encrypted = cipher.doFinal(plainText.getBytes(ENCODE_TYPE));
			return Base64.getUrlEncoder().encodeToString(encrypted);
	}

	public String decrypt(String cipherText) throws Exception {
			byte[] encrypted = Base64.getUrlDecoder().decode(cipherText);
			Cipher cipher = getCipher( Cipher.DECRYPT_MODE);
			return new String(cipher.doFinal(encrypted));
	}

	private Cipher getCipher(int mode) throws NoSuchPaddingException, NoSuchAlgorithmException, NoSuchProviderException, InvalidAlgorithmParameterException, InvalidKeyException, UnsupportedEncodingException {
		Security.addProvider(new org.bouncycastle.jce.provider.BouncyCastleProvider());
		IvParameterSpec ivSpec = new IvParameterSpec(ivKey.getBytes(ENCODE_TYPE));
		SecretKeySpec secretKeySpec = new SecretKeySpec(publicKey.getBytes(ENCODE_TYPE), ENCODE_STANDERD);
		Cipher cipher = Cipher.getInstance(PADNG_TYPE, BC);
		cipher.init(mode, secretKeySpec, ivSpec);
		return cipher;
	}
}