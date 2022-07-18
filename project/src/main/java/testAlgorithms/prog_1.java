package testAlgorithms;

public class prog_1 {

	public long[] solution(int x, int n) {
		long[] answer = new long[n];

		long num = x;

		for (int i = 0; i < answer.length; i++) {
			answer[i] = num;
			num += x;
		}

		return answer;
	}

	public void start() {
		solution(5, 3);
	}

}
