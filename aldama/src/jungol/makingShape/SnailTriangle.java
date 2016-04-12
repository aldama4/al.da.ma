package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 N을 입력받아서 아래와 같이 숫자 0부터 달팽이 모양으로 차례대로 채워진 삼각형을 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * 왼쪽 위부터 시계방향으로 오른쪽 아래로 이동하면서 숫자 0부터 N개를 채우고 다시 왼쪽으로, 
 * 다음은 위쪽으로 반복하면서 채워 나간다. (숫자 9 다음에는 0부터 다시 시작한다.)
 * 
 * 0
 * 4 1
 * 3 5 2
 * 2 0 6 3
 * 1 9 8 7 4
 * 0 9 8 7 6 5
 * [입력]
 * 마름모의 한변의 길이 N(N의 범위는 100 이하의 양의 정수)을 입력받는다.
 * [출력]
 * 주어진 형태대로 높이가 N인 달팽이 삼각형을 출력한다. 숫자 사이는 한 개의 공백으로 구분한다.
 * 
 * @author KooKoo
 *
 */
public class SnailTriangle {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_snailTriangle_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] data = new int[N][];
		for(int i=0;i<N;i++){
			data[i] = new int[i+1];
		}
		int cnt = 0, x = 0, y = 0;
		int xE = 0, yE = N-1;
		data[y][x] = cnt;
		while(cnt < N*N/2+N/2-1){
			while(y < yE)
				data[++y][++x] = ++cnt%10;
			yE--;
			while(x > xE)
				data[y][--x] = ++cnt%10;
			xE++;
			while(y > xE*2-1)
				data[--y][x] = ++cnt%10;
			
		}
		
		for (int[] is : data) {
			for (int i : is) {
				System.out.printf("%d ",i);
			}
			System.out.println();
		}
	}

}
