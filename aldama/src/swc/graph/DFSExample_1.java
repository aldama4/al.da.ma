package swc.graph;

import java.util.ArrayList;

public class DFSExample_1 {
	// 정점의 개수
	static int V = 5;
	// 방문 정점의 순서정보 배열
	static int[] visited = new int[V];
	// 현재 탐색중인 경로 상의 정점인지를 표시하는 배열
	static int[] onstack = new int[V];
	// 경로정보 배열
	static int[] parent = new int[V];
	static int visitedCnt = 0;
	static boolean found = false;
	// 인접 리스트
	static ArrayList<Integer>[] adjList = new ArrayList[V];

	public static void main(String args[]) {
		// 예제 그래프 간선 정보 입력
		adjList[1] = new ArrayList<Integer>();
		adjList[1].add(0);
		adjList[2] = new ArrayList<Integer>();
		adjList[2].add(0);
		adjList[2].add(1);
		adjList[2].add(4);
		adjList[3] = new ArrayList<Integer>();
		adjList[3].add(2);
		adjList[4] = new ArrayList<Integer>();
		adjList[4].add(3);
		// 초기화
		for (int i = 0; i < V; i++) {
			visited[i] = -1;
			onstack[i] = 0;
		}
		visitedCnt = 0;
		// 정점의 방문여부를 체크하여 사이클을 발견할 때 까지 탐색
		for (int i = 0; i < V; i++) {
			if (visited[i] == -1) {
				dfs(i);
				if (found) {
					break;
				}
			}
		}
	}

	public static void dfs(int node) {
		// 현재 탐색 중인 경로 상의 정점 표시
		onstack[node] = 1;
		// 방문순서 기록
		visited[node] = visitedCnt++;
		if (adjList[node] != null) {
			// 모든 인접정점들을 방문
			for (int adjacent : adjList[node]) {
				// 방문하지 않은 정점일 경우 방문
				if (visited[adjacent] == -1) {
					// 경로 정보 저장
					parent[adjacent] = node;
					// 재귀호출
					dfs(adjacent);
					if (found) {
						return;
					}
				} else if (onstack[adjacent] == 1
						&& visited[adjacent] < visited[node]) {
					// 현재 탐색 중인 경로 상에서 현재 정점 보다 빨리 방문한 인접정점이 발견 됨
					found = true;
					printPath(adjacent, node);
					return;
				}
			}
		}
		// 현재 탐색 중인 경로 상의 정점 표시 해제
		onstack[node] = 0;
	}

	// 사이클의 경로 출력
	public static void printPath(int start, int end) {
		if (start != end && end != 0) {
			printPath(start, parent[end]);
		}
		System.out.println(end + 1);
	}
}
