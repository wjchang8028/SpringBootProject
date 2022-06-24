package testAlgorithms;

import java.util.Scanner;

public class test2675 {

	public static void main(String[] args) {
		Scanner scan = new Scanner(System.in);
		int TestCase = scan.nextInt(); // 케이스

		while (TestCase > 0) {

			int repeat = scan.nextInt(); // 반복 횟수
			String word = scan.next(); // 입력받는 단어
			String result = ""; // 결과 문자

			for (int i = 0; i < word.length(); i++) {
				char temp = word.charAt(i);

				for (int j = 0; j < repeat; j++) {
					result += temp;
				}
			}
			System.out.println(result);
			TestCase--;
		}
	}

}
