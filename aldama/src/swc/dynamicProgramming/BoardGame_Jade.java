package swc.dynamicProgramming;

import java.io.FileInputStream;
import java.util.Scanner;

public class BoardGame_Jade {

	static int[] board = new int[80];
	static int[][] memo = new int[86][15625];
	static int N, M, SIZE, min, maxDistance, num;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				"resources/swc/dynamicProgramming_boardGame_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();

		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			SIZE = (N - 1) * 4;
			M = sc.nextInt();
			maxDistance = 21 * M + 1;
			// M+1 진법을 통한 각 주사위별 고유 수치
			num = (int)Math.pow(M+1, 6)-1;
			for (int n = 0; n < SIZE; n++) {
				board[n] = sc.nextInt();
			}
			
			for (int m = 0; m <= maxDistance; m++) {
				for(int cn = 0; cn <= num; cn++){
					memo[m][cn] = -1;
				}
			}

			// 제한조건 : 6 <= N <= 21
			// 1 <= M <= 4
			// 0 <= cost <= 2000(cost : 정수)
			
			for(int n=SIZE;n<maxDistance;n++){
				if(min > searchLowestCosts(n,num)){
					min = searchLowestCosts(n,num);
				}
			}
			System.out.printf("#%d %d", tc, min);
			System.out.println();
		}
	}

	private static int searchLowestCosts(int pos, int left) {
		int sum, temp;
		if(pos == 0){
			return 0;
		}
		if(memo[pos][left] != -1){
			return memo[pos][left];
		}
		memo[pos][left] = 987654321;
		for(int i=1;i<=6;i++){
			temp = (int)Math.pow(M+1, i-1);
			if(((left/temp)%(M+1) > 0) && (pos - i >=0)){ 
				sum = searchLowestCosts(pos-i, left-temp) + board[pos%SIZE];
				if(memo[pos][left] > sum){
					memo[pos][left] = sum;
				}
			}
		}
		
		return memo[pos][left];
	}
}
