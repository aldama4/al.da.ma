package swc.search;

public class Backtracking_AllPermutation {

	static int N = 4;
	static int[] perm, sol;
	public static void main(String[] args) {
		// back-tracking 이용하여 1,2,3,...,n 의 모든 순열 구하기
		perm = new int[N];
		sol = new int[N];
		backTracking(0);
	}

	private static void backTracking(int n) {
		// 순열 배열을 선언
		if(n == N){
			processSolution();
			return;
		}
		for(int i=0;i<N;i++){
			if(perm[i] == 0){
				sol[n] = i+1;
				perm[i] = 1;
				backTracking(n+1);
				perm[i] = 0;
			}
		}
		
	}

	private static void processSolution() {
		for (Integer integer : sol) {
			System.out.printf("%d ",integer);
		}
		System.out.println();
		
	}

}
