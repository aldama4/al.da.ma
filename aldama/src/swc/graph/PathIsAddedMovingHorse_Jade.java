package swc.graph;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

// 경로 출력도 해야할때 어떻게 해야할까?
// 1. 현재 상황에서 상위 정보를 옮긴다?
// 마지막 번째에 그 위의 칸을 저장하고, 그 위의 칸에 또 그 위... 끝으로 제일 처음이 나타나게?
// 그럼 이건 스택으로 저장해서 꺼내도록 하면 될거 같다.
// parent node 에 대한 좌표 저장을 어떤 식으로 하는 것이 좋을까?
// 우선, 해당 정보를 가지는 변수를 하나 만들어보자.
// 더 좋은 방법이 있을지는 나중에 생각해보자.
public class PathIsAddedMovingHorse_Jade {
	static int[][] orderTable, horseTable, parentTable;
	static boolean[][] visited;
	static ArrayDeque<int[]> queue;
	static ArrayDeque<Integer> parentNodeStack;
	static int answer, N, M=2, X=0, Y=1;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/graph_MovingHorse_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1; tc<=T;tc++){
			answer = 0;
			N = sc.nextInt();
			orderTable = new int[N][N];
			horseTable = new int[N][N];
			parentTable = new int[N][N];
			queue = new ArrayDeque<int[]>();
			parentNodeStack = new ArrayDeque<Integer>();
			visited = new boolean[N][N];
			for(int y=0;y<N;y++){
				for(int x=0;x<N;x++){
					horseTable[y][x] = sc.nextInt();
				}
			}
			searchShortestGoalCount();
			System.out.printf("#%d %d",tc,answer);
			while(parentNodeStack.size() > 0){
				int temp = parentNodeStack.pop();
				int x = temp / N;
				int y = temp % N;
				System.out.printf(" [%d, %d]", x, y);
			}
			System.out.println();
		}
	}
	private static void searchShortestGoalCount() {
		int x, y, cnt = 0;
		int[] pollData = new int[3];
		addQueueAndStack(0,0,0, null);
		while(queue.size() > 0){
			pollData = queue.pollFirst();
			cnt = orderTable[pollData[Y]][pollData[X]]+1;
			for(int move=1;move<=pollData[M];move++){
				x = pollData[X] + move;
				y = pollData[Y];
				if(x<N && !visited[y][x]){
					addQueueAndStack(x, y, cnt, pollData);
				}
				x -= move;
				y += move;
				if(y<N && !visited[y][x]){
					addQueueAndStack(x, y, cnt, pollData);
				}
				if(visited[N-1][N-1]){
					answer = orderTable[N-1][N-1];
					checkPath();
					return;
				}
			}

		}
	}
	private static void checkPath() {
		int x,y, xy = (N-1)*N+(N-1);
		parentNodeStack.push(xy);
		int temp = parentTable[N-1][N-1];
		for(int i=0;i<orderTable[N-1][N-1];i++){
			parentNodeStack.push(temp);
			x = temp/N;
			y = temp%N;
			temp = parentTable[y][x];
		}
		
	}
	private static void addQueueAndStack(int x, int y, int cnt, int[] parent) {
		int[] queueData = new int[3];
		queueData[M] = horseTable[y][x];
		queueData[X] = x;
		queueData[Y] = y;
		orderTable[y][x] = cnt;
		visited[y][x] = true;
		queue.add(queueData);
		
		if(parent != null){
			parentTable[queueData[Y]][queueData[X]] = parent[X]*N+parent[Y];
		}
	}

}
