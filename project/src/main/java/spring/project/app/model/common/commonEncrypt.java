package spring.project.app.model.common;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

public class commonEncrypt {
	/**
	 * SHA암호화 생성 메소드
	 * 
	 * @param text
	 */
	public String encrypt(String text) throws NoSuchAlgorithmException {
		MessageDigest md = MessageDigest.getInstance("SHA-256");
		md.update(text.getBytes());

		return byteToHex(md.digest());
	}

	/**
	 * byte배열 -> 해시화 메소드
	 * 
	 * @param bytes
	 */

	public String byteToHex(byte[] bytes) {
		StringBuilder builder = new StringBuilder();
		for (byte b : bytes) {
			builder.append(String.format("%02x", b));
		}

		return builder.toString();
	}

	/**
	 * SHA256 해시암호화 메소드
	 * 
	 * @param strData
	 */
	public String encryptSHA256(String strData) {
		String strOUTData = "";
		try {
			MessageDigest md = MessageDigest.getInstance("SHA-256");
			md.update(strData.getBytes());

			byte[] md5Sig = md.digest();
			StringBuffer sb = new StringBuffer();
			for (int i = 0; i < md5Sig.length; i++) {
				String hex = Integer.toHexString(0xff & md5Sig[i]);
				if (hex.length() == 1)
					sb.append('0');
				sb.append(hex);
			}
			strOUTData = sb.toString();
		} catch (Exception e) {
			System.out.print(e.toString());
		}
		System.out.println(strOUTData);
		return strOUTData;
	}
	
	/**
	 * 검증데이터 생성 메소드
	 * 
	 * @param
	 */

	public String makeSignData(String plainstring) throws NoSuchAlgorithmException {

	String validationData = encryptSHA256(plainstring);

	return validationData;
	}
}
