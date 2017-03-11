package com.ksign.access.tool;

import com.ksign.access.util.HexPrint;
import javak.crypto.Cipher;
import javak.crypto.spec.IvParameterSpec;
import javak.crypto.spec.SecretKeySpec;
import ksign.jce.provider.pkcs.PrivateKeyException;
import ksign.jce.util.Base64;
import ksign.jce.util.JCEUtil;
import org.apache.log4j.Logger;

import java.security.MessageDigest;
import java.security.PrivateKey;
import java.security.SecureRandom;

public class SSOCipherUtil
{
	private static Logger log = Logger.getLogger(SSOCipherUtil.class);

	public static String lhead = "[SSOCipherUtil] ";

	public static String doB64Encode(byte[] src)
	{
		try
		{
			return new String(Base64.encode(src));
		} catch (Exception ex) {
			log.error(lhead + ex.getMessage(), ex);
		}return null;
	}

	public static byte[] doB64Decode(String src)
	{
		try
		{
			return Base64.decode(src);
		} catch (Exception ex) {
			log.error(lhead + ex.getMessage(), ex);
		}return null;
	}




	public static String doDigestEncode(String plainText, String algorithm)
	{
		return doDigestEncode(plainText, algorithm, null);
	}

	public static byte[] decrypt(String algorithm, byte[] keyBytes, byte[] ivBytes, byte[] encryptedData) throws Exception
	{
		byte[] result = null;
		SecretKeySpec sKey = new SecretKeySpec(keyBytes, algorithm);
		IvParameterSpec ivParam = new IvParameterSpec(ivBytes);
		System.out.println("algorithm : " + algorithm);
		Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding", "Ksign");
		cipher.init(2, sKey, ivParam);

		result = cipher.doFinal(encryptedData);

		return result;
	}

	public static synchronized byte[] encrypt(String algorithm, byte[] keyBytes, byte[] ivBytes, byte[] input) throws Exception
	{
		byte[] result = null;
		SecretKeySpec sKey = new SecretKeySpec(keyBytes, algorithm);
		IvParameterSpec ivParam = new IvParameterSpec(ivBytes);

		Cipher cipher = Cipher.getInstance(algorithm + "/CBC/PKCS5Padding", "Ksign");
		cipher.init(1, sKey, ivParam);

		result = cipher.doFinal(input);

		return result;
	}

	public static String doDigestEncode(String plainText, String algrorithm, String dataEncoding)
	{
		try {
			byte[] digestData = doDigest(plainText, algrorithm);

			if (digestData == null) return null;
			String result = "";

			if ((dataEncoding != null) && (dataEncoding.equalsIgnoreCase("hex")))
				result = HexPrint.byteArrayToHexString(digestData, false);
			else if ((dataEncoding == null) || (dataEncoding.equals("")))
				result = new String(digestData);
			else {
				result = new String(Base64.encode(digestData));
			}

			return result;
		}
		catch (Exception ex) {
			log.error("Error : " + ex.toString());
		}return null;
	}

	public static byte[] doDigest(String plainText, String algorithm)
	{
		try {
			MessageDigest md = MessageDigest.getInstance(algorithm, "Ksign");
			md.update(plainText.getBytes());

			return md.digest();
		} catch (Exception e) {
			log.error("digest Error: " + e.toString());
		}return null;
	}

	public static synchronized PrivateKey readServerPrivateKey(String privKeyPw, String privKeyPath)
	{
		PrivateKey signPri = null;
		try {
			String kcmv = System.getProperty("ksigncrypto.kcmv");

			signPri = JCEUtil.readPrivateKey(privKeyPw, privKeyPath);
		}
		catch (PrivateKeyException e)
		{
			log.error("readServerPrivateKey Error: " + e, e);
		}

		return signPri;
	}

	public static byte[] RSADecrypt(byte[] sinfo_dec_b64, PrivateKey signPri) {
		try {
			Cipher rsaCipher = Cipher.getInstance("RSA", "Ksign");
			rsaCipher.init(2, signPri);
			byte[] plainText = rsaCipher.doFinal(sinfo_dec_b64);
			return plainText; } catch (Exception e) {
		}
		return null;
	}

	public static String generateNonce(int length)
	{
		byte[] nonce = genRandomKey(length);
		String nonceStr = doB64Encode(nonce);
		return nonceStr;
	}

	public static byte[] genRandomKey(int length) {
		SecureRandom sr = new SecureRandom();

		byte[] nonce = new byte[length];
		sr.nextBytes(nonce);

		return nonce;
	}
}