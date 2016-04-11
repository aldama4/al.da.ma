package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 마름모의 한 변의 길이 N을 입력받아 아래와 같이 문자마름모를 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * (1) 첫 번째 행의 중앙부터 출발하여 시계 반대방향으로 'A'부터 차례대로 채워나간다. ('Z'다음에는 다시 'A'가 된다.) 
 * (2) 바깥 부분이 다 채워지면 두 번째 행 중앙부터 다시 같은 작업을 반복한다. 
 * (3) 같은 방법으로 마름모를 다 채워지도록하여 출력한다.
 * 
 *      A
 *    B M L
 *  C N U T K
 *D O V Y X S J
 *  E P W R I
 *    F Q H
 *      G
 * 
 * [입력]
 * 마름모의 한변의 길이 N(N의 범위는 100 이하의 양의 정수)을 입력받는다.
 * [출력]
 * 주어진 형태대로 한변의 길이가 N인 문자마름모를 출력한다. 문자 사이는 한 개의 공백으로 구분한다.
 * 
 * @author KooKoo
 *
 */
public class CharRhombus {
	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/makingShape_charRhombus_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[][] data = new char[N*2-1][];
		int x=N, y = -1, end = N, sw = 1, cnt=-1;
		for(int i=0; i<N*2-1;i++){
			sw = i >= N-1? -1 : 1;
			data[i] = new char[end];
			end += sw;
			for(int j=0;j<data[i].length;j++){
				data[i][j] = ' ';
			}
		}
		end = N;
		while(end-- > 0){
			for(int i=0; i<(end+1)*2-1;i++){
				sw = i >= end+1? -1 : 1;
				x = x-sw;
				data[y+=1][x] = (char)(++cnt%26+'A');
			}
			for(int i=0;i<(end)*2-1;i++){
				data[y-=1][x=data[y].length-(N-end)] =(char)(++cnt%26+'A');
			}
			y--;
		}
		for (char[] cs : data) {
			for (char c : cs) {
				System.out.printf("%c ",c);
			}
			System.out.println();
		}
	}
}
