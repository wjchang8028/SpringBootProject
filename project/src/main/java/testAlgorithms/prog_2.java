package testAlgorithms;

public class prog_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

	public int[][] solution(int[][] arr1, int[][] arr2) {
		int[][] answer = new int[arr1.length][arr2.length];

		for (int i = 0; i < arr1.length; i++) {
			for (int j = 0; j < arr1[i].length; j++) {

				answer[i][j] = arr1[i][j] + arr2[i][j];
			}
		}

		return answer;
	}

}
