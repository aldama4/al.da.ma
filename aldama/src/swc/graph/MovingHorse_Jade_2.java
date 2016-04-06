package swc.graph;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

// 회사와서 회고하며 다듬은 거
public class MovingHorse_Jade_2 {
	static int[][] orderTable, horseTable;
	static boolean[][] visited;
	static ArrayDeque<int[]> queue;
	static int answer, N, M=0, X=1, Y=2;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/graph_MovingHorse_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++){
			answer = 0;
			N = sc.nextInt();
			orderTable = new int[N][N];
			horseTable = new int[N][N];
			queue = new ArrayDeque<int[]>();
			visited = new boolean[N][N];
			for(int y=0;y<N;y++){
				for(int x=0;x<N;x++){
					horseTable[y][x] = sc.nextInt();
				}
			}
			searchShortestGoalCount();
			System.out.printf("#%d %d",tc,answer);
			System.out.println();
		}
	}
	private static void searchShortestGoalCount() {
		int x, y, cnt = 0;
		int[] pollData = new int[3];
		addQueue(0,0,0);
		while(queue.size() > 0){
			pollData = queue.pollFirst();
			cnt = orderTable[pollData[Y]][pollData[X]]+1;
			for(int move=1;move<=pollData[M];move++){
				x = pollData[X] + move;
				y = pollData[Y];
				if(x<N && !visited[y][x]){
					addQueue(x, y, cnt);
				}
				x -= move;
				y += move;
				if(y<N && !visited[y][x]){
					addQueue(x, y, cnt);
				}
				if(visited[N-1][N-1]){
					answer = orderTable[N-1][N-1];
					return;
				}
			}

		}
	}
	private static void addQueue(int x, int y, int cnt) {
		int[] temp = new int[3];
		temp[M] = horseTable[y][x];
		temp[X] = x;
		temp[Y] = y;
		orderTable[y][x] = cnt;
		visited[y][x] = true;
		queue.add(temp);
	}

}
