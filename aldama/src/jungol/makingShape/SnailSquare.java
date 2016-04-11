package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 정사각형의 크기를 입력 받은 후 시계방향으로 돌면서 다음과 같은 형태로 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * (1) 가장 왼쪽 위의 좌표부터 차례로 숫자를 대입시킨다. 
 * (2) 오른쪽으로 채워 나가다가 끝이면 다시 아래 → 왼쪽 → 위 →오른쪽의 순으로 모두 채워질때까지 반복한다.
 * 
 * 1 2 3 4 5
 * 16 17 18 19 6
 * 15 24 25 20 7
 * 14 23 22 21 8
 * 13 12 11 10 9
 * 
 * [입력]
 * 정사각형의 크기 n(1부터 100사이의 정수)을 입력받는다.
 * [출력]
 * 위에서 언급한 형태로 정사각형의 내부 숫자를 차례로 채운 후의 모습을 출력한다. 숫자 사이는 공백으로 구분한다.
 * 
 * @author KooKoo
 *
 */
public class SnailSquare {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/makingShape_snailSquare_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] square = new int[N][N];
		int sw = 1;
		int y = 0, x = -1;
		int cnt = 0;
		while(N-- > 0){
			for(int i=0;i<N+1;i++){
				square[y][x=x+sw] = ++cnt;
			}
			for(int j=0;j<N;j++){
				square[y=y+sw][x] = ++cnt;
			}
			sw = sw==1?-1:1;
		}
		
		for (int[] row : square) {
			for (int i : row) {
				System.out.printf("%d ",i);
			}
			System.out.println();
		}
	}

}
