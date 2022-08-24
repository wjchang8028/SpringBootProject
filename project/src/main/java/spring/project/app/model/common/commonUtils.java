package spring.project.app.model.common;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.HttpClientBuilder;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class commonUtils {

	/**
	 * API 커넥션 메소드(urlConnection)
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

	public String RestApiConnection(String requestURL) {
		String result = "";

		try {
			HttpClient hclient = HttpClientBuilder.create().build(); // HttpClient 생성
			HttpPost postRequest = new HttpPost(requestURL); // 요청 URL에 post 전송
			HttpResponse response = hclient.execute(postRequest);

		} catch (Exception e) {
			// TODO: handle exception
		}

		return result;
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

	// httpclient 확장 및 vs httpurlconnection 추가예정 restTemplate

	public String connectToServer2(String requestURL, String jsonMessage) { // httpClient 이용
		HttpClient client = HttpClientBuilder.create().build(); // httpClient 생성
		// HttpGet getRequest = new HttpGet(requestURL); // get 메소드 url
		HttpPost postRequest = new HttpPost(requestURL); // post 메소드 url

		try {
			postRequest.setHeader("Accept", "application/json");
			postRequest.setHeader("Connection", "keep-alive");
			postRequest.setHeader("Content-Type", "application/json");
			// postRequest.addHeader("x-api-key",key값입력);

			postRequest.setEntity(new StringEntity(jsonMessage)); // json 메세지 입력
			HttpResponse response = client.execute(postRequest);

			// Response 출력 json

			if (response.getStatusLine().getStatusCode() == 200) {
				ResponseHandler<String> handler = new BasicResponseHandler();
				String body = handler.handleResponse(response);
				System.out.println(body);

			} else {
				System.out.println("response error ! : " + response.getStatusLine().getStatusCode());
			}

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return "";
	}

	public HashMap apiInit(HttpServletRequest request) {

		HashMap<Object, Object> reqMap = new HashMap<>();
		// HashMap paramMap = new HashMap(request.getParameterMap());
		//
		// System.out.println(paramMap.get("userpw"));
		// Iterator it = paramMap.keySet().iterator();
		//
		// String key = null;
		// String value = null;
		// String paramName = null;
		//
		// while (it.hasNext()) {
		// key = String.valueOf(it.next());
		// value = String.valueOf(paramMap.get(key));
		//
		// for (int i = 0; i < value.length(); i++) {
		// System.out.println("key : " + key + " , " + "value : " + value);
		// }
		//
		// }

		String paramName = null;

		Enumeration params = request.getParameterNames();
		while (params.hasMoreElements()) {
			paramName = (String) params.nextElement();
			reqMap.put(paramName, request.getParameter(paramName));

		}

		System.out.println(reqMap);
		return reqMap;

	};

}
