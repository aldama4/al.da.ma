package algospot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public class Game_Jade_2 {

	static int N, K;
	static int[][] waitTable;
	static boolean[] checker;
	static ArrayList<Integer> losers;

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/algospot/Game_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			losers = new ArrayList<Integer>();
			N = sc.nextInt();
			K = sc.nextInt();
			waitTable = new int[N][K];
			checker = new boolean[N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < K; j++) {
					waitTable[i][j] = sc.nextInt();
				}
			}

			for(int k=0;k<K;k++){
				int min = 61;
				losers.clear();
				for(int i=0;i<N;i++){
					if(!checker[i] && min > waitTable[i][k]){
						min = waitTable[i][k];
						losers.add(i+1);
						checker[i] = true;
					}else if(!checker[i] && min == waitTable[i][k]){
						losers.add(i+1);
					}					
				}
				
				if(losers.size() > 1){
					break;
				}
			}
			
			if(losers.size() > 1){
				for (Integer loser : losers) {
					System.out.print(loser+" ");
				}
				System.out.println();
			}else{
				for (int i=0;i<N;i++) {
					if(!checker[i]){
						System.out.print(i+1+" ");
					}
				}
				System.out.println();
			}
			
		}
	}

}
