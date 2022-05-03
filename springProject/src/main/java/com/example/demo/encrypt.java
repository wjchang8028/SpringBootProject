package com.example.demo;

import java.security.MessageDigest;
import java.security.SecureRandom;

public class encrypt {
	public static String Byte_To_String(byte[] byteArr) {
		StringBuilder sb = new StringBuilder();

		for (byte a : byteArr) {
			sb.append(String.format("%02x", a)); // 02x hex코드포맷
		}
		return sb.toString();
	}

	public static String makeSalt() throws Exception {
		int codeLen = 15; // 임의의 hex코드의 길이

		SecureRandom sr = new SecureRandom();
		byte[] srCode = new byte[codeLen];
		sr.nextBytes(srCode);

		return Byte_To_String(srCode);
	}

	public static String encryptToken(String pwd) {
		try {

			MessageDigest digest = MessageDigest.getInstance("SHA-256");
			byte[] hash = digest.digest(pwd.getBytes("UTF-8"));
			StringBuffer hexString = new StringBuffer();

			for (int i = 0; i < hash.length; i++) {
				String hex = Integer.toHexString(0xff & hash[i]);
				if (hex.length() == 1)
					hexString.append('0');
				hexString.append(hex);
			}

			// 출력
			return hexString.toString();

		} catch (Exception ex) {
			throw new RuntimeException(ex);
		}
	}

	public static String makeToken(String birth, String name, String password) { // 해시 토큰 생성
		String token = new StringBuffer(birth).append(name).append(password).toString();

		String encryptToken = encryptToken(token);

		return encryptToken;
	}

	public static void main(String[] args) {
		String birth = "19901230";
		String name = "유재석";
		String password = "dbwoTjr123";

		String UID = makeToken(birth, name, password);
		System.out.println(UID);

		try {
			String salt = makeSalt();
			System.out.println(salt);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
