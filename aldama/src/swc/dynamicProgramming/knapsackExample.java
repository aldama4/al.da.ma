package swc.dynamicProgramming;

/**
 * 배낭 문제(Knapsack problem) 
 * 배낭 문제는 유명한 최적화 문제 중 하나이다. 
 * 용량이 정해진 배낭에 특정한 무게와 가치를 가지는 물건들을 넣을 때 배낭의 용량을 초과하지 않으면서 
 * 가치의 합을 최대화 시 키는 물건의 조합을 찾는 문제이다. 
 * 예를 들어 5개의 물건이 있고 각 물건이 가지는 무 게와 가치가 각각 2, 1, 4, 1, 12(Kg)와 
 * 2, 1, 10, 2, 4(천원) 라 할 때 배낭의 용량 15Kg 내 에서 가방에 담을 수 있는 물건들의 
 * 가치합의 최대치를 구하는 경우를 생각해보자.
 * 
 * @author KooKoo
 *
 */
public class knapsackExample {
	// 물건의 개수
	static int N = 5;
	// 배낭의 용량
	static int W = 15;
	// 물건의 가치 배열
	static int[] ci = { 2, 1, 10, 2, 4 };
	// 물건의 무게 배열
	static int[] wi = { 2, 1, 4, 1, 12 };
	// 메모이제이션을 위한 배열
	static int[][] M = new int[N + 1][W + 1];
	// 담은 물건 저장을 위한 배열
	static int[][] S = new int[N + 1][W + 1];

	public static void main(String args[]) {
		// 초기화
		for (int i = 0; i < N + 1; i++) {
			for (int j = 0; j < W + 1; j++) {
				M[i][j] = -1;
			}
		}
		// 최대 가치합 출력
		System.out.println(ks(N, W));
		printSolution(N, W);
	}

	public static int ks(int i, int w) {
		// 담을 물건이 없으므로 0을 리턴
		if (i == 0) {
			return 0;
		}
		// 배열에 이전에 계산한 값이 존재
		if (M[i][w] != -1) {
			return M[i][w];
		}
		// 부분문제의 관계로 부터 값을 계산
		// i번째 물건을 담지 않는 경우
		M[i][w] = ks(i - 1, w);
		// i번째 물건을 담는 경우 배낭의 남은 용량이 물건의 무게보다 크거나 같아야 한다.
		if (w - wi[i - 1] >= 0) {
			M[i][w] = Math.max(M[i][w], ks(i - 1, w - wi[i - 1]) + ci[i - 1]);
			if (ks(i - 1, w) < M[i][w]) {
				S[i][w] = 1;
			}
		}
		return M[i][w];
	}

	// 선택한 물건정보 출력(추가된 메소드)
	// printSolution(N, W)
	public static void printSolution(int i, int w) {
		if (i == 0) {
			return;
		}
		if (S[i][w] == 1) {
			printSolution(i - 1, w - wi[i - 1]);
			System.out.print(i + " ");
		} else {
			printSolution(i - 1, w);
		}
	}
}
