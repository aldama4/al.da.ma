package swc.search;

import java.util.Arrays;

// 다 못풀음..
public class NQueen_Jade_Yet {
	// NQueen 문제를 back-tracking 으로 풀기
	
	// 체스보드의 크기
	static int N = 8;
	// B = 빈칸, Q = 퀸, O 못두는 곳 
	static char[][] board = new char[N][N];
	static char[][] solBoard = new char[N][N];
	static int solCnt = 0;
	public static void main(String[] args) {
		char[] str = ("B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B "
			        + "B B B B B B B B ").replace(" ", "").toCharArray();
		
		int idx = 0;
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				board[i][j] = str[idx];
				solBoard[i][j] = str[idx];
				idx++;
			}
		}

		backTracking(0);
		System.out.println(solCnt);
	}
	private static void backTracking(int i) {
		if(i==N){
			processSolution();
			return;
		}
		
		for(int j=0;j<N;j++){
			if(solBoard[i][j] == 'Q' || solBoard[i][j] == 'O'){
				continue;
			}
			for(int n=0;n<N;n++){
				board[n] = solBoard[n].clone();
			}
			setQueen(i,j);
		}
		backTracking(i+1);
		for(int n=0;n<N;n++){
			solBoard[n] = board[n].clone();
		}

		
	}
	private static void backUp() {
		for(int n=0;n<N;n++){
			board[n] = solBoard[n].clone();
		}
	}
	private static void setQueen(int i, int j) {
		solBoard[i][j] = 'Q';
		for(int c=0;c<N;c++){
			if(solBoard[i][c] == 'B'){
				solBoard[i][c] = 'O';
			}
			
			if(solBoard[c][j] == 'B'){
				solBoard[c][j] = 'O';
			}
			
			// 좌상향
			if(i-c >= 0 && j-c >= 0 && solBoard[i-c][j-c] == 'B'){
				solBoard[i-c][j-c] = 'O';
			}
			// 우상향
			if(i-c >= 0 && j+c < N && solBoard[i-c][j+c] == 'B'){
				solBoard[i-c][j+c] = 'O';
			}
			// 좌하향
			if(i+c < N && j-c >= 0 && solBoard[i+c][j-c] == 'B'){
				solBoard[i+c][j-c] = 'O';
			}
			// 우하향
			if(i+c < N && j+c < N && solBoard[i+c][j+c] == 'B'){
				solBoard[i+c][j+c] = 'O';
			}
		}
	}
	private static void processSolution() {
		System.out.println("########");
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.printf("%c ", solBoard[i][j]);
			}
			System.out.println();
		}
		solCnt++;
		
	}

}
