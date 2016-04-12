package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 N을 입력받아서 아래와 같이 문자 'A'부터 차례대로 왼쪽 대각선으로 채워서 삼각형 모양을 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * (1) 오른쪽 위부터 왼쪽 아래쪽으로 이동하면서 문자 'A'부터 차례대로 채워나간다. 
 * (2) N번 행까지 채워지면 다시 오른쪽 둘째 행부터 왼쪽 아래로 채워나간다. 
 * (3) 삼각형이 모두 채워질 때까지 반복하면서 채워 나간다. (문자 'Z'다음에는 'A'부터 다시 시작한다.)
 *         A
 *       B F
 *     C G J
 *   D H K M
 * E I L N O
 * [입력]
 * 삼각형의 높이 N(N의 범위는 100 이하의 양의 정수)을 입력받는다.
 * [출력]
 * 주어진 형태대로 높이가 N인 문자삼각형을 출력한다. 문자 사이는 한 개의 공백으로 구분한다.
 * @author KooKoo
 *
 */
public class CharTriangle1 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_charTriangle1_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int cnt = -1;
		char[][] data = new char[N][N];
		for(int i=0;i<N;i++){
			for(int b=0;b<N-1-i;b++){
				data[i][b] = ' ';
			}
			for(int c=0;c<N-i;c++){
				data[i+c][N-1-c] = (char)(++cnt%26 + 'A'); 
			}
		}
		
		for (char[] cs : data) {
			for (char c : cs) {
				System.out.printf("%c ",c);
			}
			System.out.println();
		}
	}

}
