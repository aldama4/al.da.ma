package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 정사각형의 한 변의 길이 n을 입력받은 후 다음과 같은 문자로 된 정사각형 형태로 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * 문자의 진행 순서는 맨 오른쪽 아래에서 위쪽으로 'A'부터 차례대로 채워나가는 방법으로 아래 표와 같이 왼쪽 위까지 채워 넣는다. 
 * 'Z' 다음에는 다시 'A'부터 반복된다.
 * 
 * P L H D
 * O K G C
 * N I F B
 * M I E A
 * 
 * [입력]
 * 정사각형 한 변의 길이 n(n의 범위는 1이상 100 이하의 정수)을 입력받는다.
 * [출력]
 * 위의 형식과 같이 한변의 길이가 n인 문자 사각형을 출력한다. 문자 사이는 공백으로 구분하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class CharSquare1 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/makingShape_charSquare1_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int cnt = -1;
		char square[][] = new char[N][N];
		for(int x=N-1;x>=0;x--){
			for(int y=N-1;y>=0;y--){
				square[y][x] = (char)(++cnt%26 + 'A');
			}
		}
		for (char[] row : square) {
			for (char c : row) {
				System.out.printf("%c ",c);
			}
			System.out.println();
		}
	}

}
