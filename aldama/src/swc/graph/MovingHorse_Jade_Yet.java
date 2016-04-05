package swc.graph;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

public class MovingHorse_Jade_Yet {

	static int[][] orderTable,horseTable;
	static ArrayDeque<int[]> queue;
	static boolean[][] visited;
	static int N, answer, K = 0, X = 1, Y = 2;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/swc/graph_MovingHorse_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		for (int tc = 1; tc <= T; tc++) {
			answer = 0;
			N = sc.nextInt();
			visited = new boolean[N][N];
			queue = new ArrayDeque<int[]>();
			orderTable = new int[N][N];
			horseTable = new int[N][N];
			for (int y = 0; y < N; y++) {
				for (int x = 0; x < N; x++) {
					horseTable[y][x] = sc.nextInt();
				}
			}
			searchShortestGoalCount();
			System.out.printf("#%d %d", tc, answer);
			System.out.println();
		}
	}

	private static void searchShortestGoalCount() {
		int[] pollData = new int[3];
		int[] temp = new int[3];
		int x, y, cnt;
		pollData[K] = horseTable[0][0];
		pollData[X] = 0;
		pollData[Y] = 0;
		orderTable[0][0] = 0;
		visited[0][0] = true;
		queue.add(pollData);
		while (queue.size() > 0) {
			pollData = queue.pollFirst();
			cnt = orderTable[pollData[Y]][pollData[X]] + 1;
			for (int move = 1; move <= pollData[K]; move++) {
				x = pollData[X] + move;
				y = pollData[Y];
				if (x < N && !visited[y][x]) {
					temp[K] = horseTable[y][x];
					temp[X] = x;
					temp[Y] = y;
					visited[y][x] = true;
					orderTable[y][x] = cnt;
					queue.add(temp.clone());
				}
				x -= move;
				y += move;
				if (y < N && !visited[y][x]) {
					temp[K] = horseTable[y][x];
					temp[X] = x;
					temp[Y] = y;
					orderTable[y][x] = cnt;
					visited[y][x] = true;
					queue.add(temp.clone());
				}
				if(visited[N-1][N-1]){
					answer = orderTable[N-1][N-1];
					return;
				}
			}
			
		}
	}
}
