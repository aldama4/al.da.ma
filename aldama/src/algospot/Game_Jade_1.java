package algospot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * N명의 사람이 있다. 편의상 각 사람을 1...N 번 사람이라고 부른다. 
 * 이들은 서로 눈치를 보며 1부터 K까지 순서대로 숫자를 외친다.
 * K는 N보다 작다 두 사람 이상이 동시에 같은 숫자를 외치면 그 사람들은 게임에 지게 된다. 
 * 한 번 숫자를 외친 사람은 더 이상 다른 숫자를 외치지 않는다. 
 * K 까지 숫자를 외치는 동안 패자가 없으면, 숫자를 외치지 못한 나머지 사람들이 지게 된다. 
 * 게임이 시작하면 1을 외칠 수 있고, 누군가 j를 외치면 그 순간부터 j+1을 외칠 수 있다. 
 * i번 사람은 숫자 j를 외칠 수 있는 순간부터 W(i,j) 시간만큼 기다리며 눈치를 본다. 
 * 그리고 그 시간동안 아무도 숫자를 외치지 않으면 j를 외친다.
 * N명이 각각 숫자에 대해서 기다리는 시간이 주어졌을 때 눈치게임에서 지는 사람은 누구인가?
 * 
 * ###입력### 
 * 첫 줄에는 게임의 회수 T가 주어진다. (1 ≤ T ≤ 100 ) 각 테스트 케이스의 첫 줄에는 정수 N과 K가 주어진다.
 * (1 ≤ K < N ≤ 500) 다음 줄부터 N 줄에 걸쳐서 N x K 의 행렬이 주어진다. 
 * i행의 j열에 있는 수는 W(i,j)를 나타낸다. 
 * (0 ≤ W(i,j) ≤ 60, 1 ≤ i ≤ N, 1 ≤ j ≤ K) 
 * ###출력### 
 * 각각의 게임에 대하여 지는 사람의 목록을 오름차순으로 한 줄에 출력한다. 
 * 각 사람은 한 칸의 공백으로 구분하도록 한다.
 * 
 * @author KooKoo
 *
 */
public class Game_Jade_1 {

	// 1-1.W(i,j) 가 제일 낮은 사람이 유일하면 그 사람을 제외한다
	// 1-2.만약 둘 이상이면 해당 인원이 탈락
	// 2.다음 번호를 대기하고 1번 반복
	static int N, K;
	static int[][] waitTable;
	static boolean[] checker;
	static ArrayList<int[]> sortedWaitTable;
	static String losers;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/algospot/Game_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			long start = System.currentTimeMillis();
			waitTable = new int[N = sc.nextInt()][(K = sc.nextInt()) + 1];
			checker = new boolean[N];
			losers = "";
			sortedWaitTable = new ArrayList<int[]>();
			for (int i = 0; i < N; i++) {
				for (int j = 1; j <= K; j++) {
					waitTable[i][j] = sc.nextInt();
					waitTable[i][0] = i;
				}
				sortedWaitTable.add(waitTable[i]);
			}
			playGame();
			long end = System.currentTimeMillis();
			System.out.println(end-start+"(ms)");
		}
	}

	private static void playGame() {
		inspectLoser();
		finish();		
		
		System.out.println(losers.trim());
	}

	private static void inspectLoser() {
		for (int k = 1; k <= K; k++) {
			sort(k);
			boolean check = false;
			int[] temp = sortedWaitTable.get(0);
			for(int n = 1; n < sortedWaitTable.size();) {
				int[] next = sortedWaitTable.get(n);
				if (temp[k] != next[k]) {
					if(check){
						return;
					}
					sortedWaitTable.remove(0);
					break;					
				} else {
					check = true;
					checker[temp[0]] = true;
					checker[next[0]] = true;
					n++;
				}
			}
		}
	}

	private static void finish() {
		boolean ret = false;
		for (boolean b : checker) {
			if(b){
				ret = true;
				break;
			}
		}
		if(!ret){
			for (int[] user : sortedWaitTable) {
				checker[user[0]] = true;
			}
		}
		for (int i = 0; i < N; i++) {
			if (checker[i]) {
				losers += i+1+" ";
			}
		}
	}

	private static void sort(final int index) {
		Collections.sort(sortedWaitTable, new Comparator<int[]>() {
			@Override
			public int compare(int[] a, int[] b) {
				return a[index] - b[index];
			}
		});
	}

}
