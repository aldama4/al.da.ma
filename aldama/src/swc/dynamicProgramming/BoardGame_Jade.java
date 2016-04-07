package swc.dynamicProgramming;

import java.io.FileInputStream;
import java.util.Scanner;

public class BoardGame_Jade {

	// [위치] 별로 입력값인, 지불 비용을 저장한다.
	static int[] board = new int[80];
	// [위치][남은카드] 별로 최소값을 저장한다.
	static int[][] memo = new int[86][15625];
	// [위치][남은카드] 별로 사용된 카드를 저장한다.
	static int[][] usedCards = new int[86][15625];
	static int N, M, SIZE, min, maxDistance, num;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream(
				"resources/swc/dynamicProgramming_boardGame_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int minCostPos = 0;
		for (int tc = 1; tc <= T; tc++) {
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			SIZE = (N - 1) * 4;
			M = sc.nextInt();
			maxDistance = 21 * M + 1;
			// M+1 진법을 통한 각 주사위별 고유 수치(각 자리별로 카드가 되는 것)를 10진수로 변환.
			num = (int)Math.pow(M+1, 6)-1;
			for (int n = 0; n < SIZE; n++) {
				board[n] = sc.nextInt();
			}
			
			for (int m = 0; m <= maxDistance; m++) {
				for(int cn = 0; cn <= num; cn++){
					memo[m][cn] = -1;
					usedCards[m][cn] = 0;
				}
			}

			// 제한조건 : 6 <= N <= 21
			// 1 <= M <= 4
			// 0 <= cost <= 2000(cost : 정수)
			
			for(int n=SIZE;n<maxDistance;n++){
				// 출발점을 한바퀴 돌아 도착하거나 지나쳤을 때, 최소 지출비용을 저장한다.
				// --한바퀴 돌아 출발점에 도달하는 최소 이동거리에서 나올 수 있는 최대 이동 거리까지
				if(min > searchLowestCosts(n,num)){
					min = searchLowestCosts(n,num);
					minCostPos = n;
				}
			}
			System.out.printf("#%d %d", tc, min);
			printUsedCoards(minCostPos, num-1);
			System.out.println();
		}
	}

	private static void printUsedCoards(int pos, int left) {
		//
		if(pos - usedCards[pos][left] >= 0 && usedCards[pos][left] > 0){
			printUsedCoards(pos - usedCards[pos][left], left - (int)Math.pow(M+1, usedCards[pos][left]-1));
		}
		if(usedCards[pos][left] != 0){
			System.out.printf("[%d]",usedCards[pos][left]);
		}
	}
	// 도착지점에서부터 시작하여, 출발점으로 되돌아갈 수 있는 이동카드 값들을 찾아 들어가는 재귀
	private static int searchLowestCosts(int pos, int left) {
		int sum, temp;
		// 도착했으면 0을 반환한다.
		if(pos == 0){
			return 0;
		}
		// 해당 위치에 남은 카드량(예시.6위치에 2 - 4 또는 6위치에 4 - 2 를 사용했을 때)이 일치한 지출 비용값이
		// 저장되어있다면 그것을 그대로 사용한다.
		if(memo[pos][left] != -1){
			return memo[pos][left];
		}
		// 위의 조건에 해당하지 않는, 즉 사용된 카드에 맞는 해당 위치의 총 지출값이 없기에 큰 값을 저장한다.
		memo[pos][left] = 987654321;
		for(int i=1;i<=6;i++){
			// 10진법으로 변환된 해당 이동카드의 남은 수량을 알기 위해, M+1 진법에 해당 카드 위치값을 저장한다.
			// 각 카드가 2장씩 있을 때 1의 위치 - 3^(1-1) = 3^0(첫번째칸), 2의 위치 - 3^(2-1) = 3^1(두번째칸)
			// 2장씩 있을 때 3진법을 적용하게 되어 222222(3) 의 형태가 만들어짐.
			temp = (int)Math.pow(M+1, i-1);
			// 해당 이동카드가 한장이상 남았고, 해당 이동카드를 사용했을 때 가야할 위치가 남았을 때를 조건으로 비용합계를 저장함
			if(((left/temp)%(M+1) > 0) && (pos - i >=0)){ 
				// 재귀호출을 통해 비용을 저장한다.
				sum = searchLowestCosts(pos-i, left-temp) + board[pos%SIZE];
				// 예시. 6위치에 2 - 4 를 사용하여 들렀을 때의 지출비용이 먼저 저장 되었을 때에,
				// 방금 구한 값 4 - 2 를 사용했을 때보다 크다면, 4 -2 를 사용했을 때의 값을 저장하고
				// 그 때 사용된 카드를 기록한다.
				if(memo[pos][left] > sum){
					memo[pos][left] = sum;
					usedCards[pos][left] = i;
				}
			}
		}
		
		return memo[pos][left];
	}
}
