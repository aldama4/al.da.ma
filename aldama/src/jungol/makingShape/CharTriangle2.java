package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 N을 입력받아서 아래와 같이 문자 'A'부터 차례대로 맨 오른쪽 가운데 행부터 차례대로 
 * 아래와 같이 채워서 삼각형 모양을 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * (1) 오른쪽 가운데 행에 문자 'A'를 채우고 왼쪽 열로 이동하여 위에서 아래로 채워나간다. 
 * (2) 가장 왼쪽 행까지 반복하여 모두 채워 나간다. (문자 'Z'다음에는 'A'부터 다시 시작한다.)
 * E
 * F B
 * G C A
 * H D
 * I
 * [입력]
 * 삼각형의 높이 N(N의 범위는 1이상 100 이하의 홀수)을 입력받는다.
 * [출력] 
 * 주어진 형태대로 높이가 N인 문자삼각형을 출력한다. 문자 사이는 한 개의 공백으로 구분한다. 
 * 입력범위를 벗어나면 "INPUT ERROR"를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class CharTriangle2 {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/makingShape_charTriangle2_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		if(N%2==0 || N < 1 || N > 100){
			System.out.println("INPUT ERROR");
			return;
		}
		char[][] data = new char[N][];
		int end = 0;
		for(int i=0;i<N;i++){
			int sw=i > N/2 ? -1 : 1;
			data[i] = new char[end+=sw];
		}
		int cnt = -1, x = N/2, y = N/2;
		for(int i=0;i<N/2+1;i++){
			for(int j=0;j<2*i+1;j++)
				data[y+j][x] = (char)(++cnt%26+'A');
			y--;x--;
		}
		for (char[] cs : data) {
			for (char c : cs) {
				System.out.printf("%c ",c);
			}
			System.out.println();
		}
	}
}
