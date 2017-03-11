package com.ksign.access.tool;

import com.ksign.access.tool.SSOCipherUtil;
import org.apache.log4j.Logger;

public class SSOAgentCryptUtil
{
	private static Logger log = Logger.getLogger(SSOAgentCryptUtil.class);
	private String lhead = "[SSOAgentCryptUtil] ";
	private byte[] sKeyBytes = null;
	private byte[] ivBytes = null;
	private String algorithm = null;
	private String gid = null;

	private String b64KeyInfo = null;

	public SSOAgentCryptUtil(String algorithm, byte[] sKeyBytes, byte[] ivBytes) {
		this.algorithm = algorithm;
		this.sKeyBytes = sKeyBytes;
		this.ivBytes = ivBytes;
	}

	public void setKeyInfo(String b64KeyInfo) {
		this.b64KeyInfo = b64KeyInfo;
	}

	public String getKeyInfo() {
		return this.b64KeyInfo;
	}

	public byte[] doDecodeDecrypt(String encodedSrc) {
		byte[] encryptedData = SSOCipherUtil.doB64Decode(encodedSrc);
		byte[] result = null;
		try
		{
			result = SSOCipherUtil.decrypt(this.algorithm, this.sKeyBytes, this.ivBytes, encryptedData);
		} catch (Exception e) {
			log.error(this.lhead + this.gid + "> failed to doDecodeDecrypt", e);
		}

		return result;
	}

	public String doEncryptEncode(String inputStr)
	{
		return doEncryptEncode(inputStr, null);
	}

	public void setGid(String gid) {
		this.gid = gid;
	}

	public String doEncryptEncode(String inputStr, String encType) {
		byte[] encryptedData = null;
		String result = null;
		try
		{
			byte[] input = null;

			if (encType != null) input = inputStr.getBytes(encType); else {
				input = inputStr.getBytes();
			}
			encryptedData = SSOCipherUtil.encrypt(this.algorithm, this.sKeyBytes, this.ivBytes, input);
			result = SSOCipherUtil.doB64Encode(encryptedData);
		} catch (Exception e) {
			log.error(this.lhead + this.gid + "> failed to doEncryptEncode", e);
		}

		return result;
	}

	public String toString() {
		StringBuffer sb = new StringBuffer();
		sb.append("gid=").append(this.gid).append(", ");
		sb.append("algorithm=").append(this.algorithm).append(", ");
		sb.append("sKeyBytes=").append(SSOCipherUtil.doB64Encode(this.sKeyBytes)).append(", ");
		sb.append("ivBytes=").append(SSOCipherUtil.doB64Encode(this.ivBytes)).append(", ");
		sb.append("b64KeyInfo=").append(this.b64KeyInfo);

		return sb.toString();
	}
}