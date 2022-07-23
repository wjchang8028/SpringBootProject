package testAlgorithms;

public class prog_1 {

	public long[] solution(int x, int n) {
		long[] answer = new long[n]; //길이 처음부터 할당

		long num = x;

		for (int i = 0; i < answer.length; i++) {
			answer[i] = num;
			num += x;
		}

		return answer;
	}

	public void start() { // 콘솔
		solution(5, 3);
	}

}
