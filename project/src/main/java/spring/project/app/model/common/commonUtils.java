package spring.project.app.model.common;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class commonUtils {

	/**
	 * API 커넥션 메소드
	 * 
	 * @param data
	 * @param reqUrl
	 */
	public String connectToServer(String data, String reqUrl) throws Exception {
		HttpURLConnection conn = null;
		BufferedReader resultReader = null;
		PrintWriter pw = null;
		URL url = null;

		int statusCode = 0;
		StringBuffer recvBuffer = new StringBuffer();
		try {
			url = new URL(reqUrl);
			conn = (HttpURLConnection) url.openConnection(); // url커넥션 오픈설정
			conn.setRequestMethod("POST");// 전송방식 설정
			conn.setDoOutput(true);

			pw = new PrintWriter(conn.getOutputStream());
			pw.write(data);
			pw.flush();

			statusCode = conn.getResponseCode();

			resultReader = new BufferedReader(new InputStreamReader(conn.getInputStream(), "UTF-8"));
			for (String temp; (temp = resultReader.readLine()) != null;) {
				recvBuffer.append(temp).append("\n");
			}

			if (!(statusCode == HttpURLConnection.HTTP_OK)) {
				System.out.println("statusCode httpok와 다른 오류");
			}

			System.out.println("리턴 데이터 값 : " + recvBuffer.toString().trim());

			return recvBuffer.toString().trim();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			return "ERROR";
		}

	}

	/**
	 * json -> hashmap 변환 메소드
	 * 
	 * @param str
	 */

	public HashMap jsonStringToHashMap(String str) throws Exception {
		HashMap dataMap = new HashMap();
		JSONParser parser = new JSONParser();

		try {
			Object obj = parser.parse(str);
			JSONObject jsonObject = (JSONObject) obj;

			Iterator<String> keyStr = jsonObject.keySet().iterator();
			while (keyStr.hasNext()) {
				String key = keyStr.next();
				Object value = jsonObject.get(key);

				dataMap.put(key, value);
			}

		} catch (Exception e) {
			// TODO: handle exception
		}

		return dataMap;

	}
	
	// httpclient vs httpurlconnection 추가예정

}
