package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * (세 자리 수) × (세 자리 수)는 다음과 같은 과정을 통하여 이루어진다.
 * 
 *       4 7 2   ... (1)
 *     X 3 8 5   ... (2)
 * -------------
 *     2 3 6 0   ... (3)
 *   3 7 7 6     ... (4)
 * 1 4 1 6       ... (5)
 * -------------
 * 1 8 1 7 2 0   ... (6)
 * 
 * (1)과 (2)위치에 들어갈 세 자리 자연수가 주어질 때 (3), (4), (5), (6)위치에 들어갈 값을 구하는 프로그램을 작성하시오.
 * [입력]
 * 첫째 줄에 (1)의 위치에 들어갈 세 자리 자연수가, 둘째 줄에 (2)의 위치에 들어갈 세자리 자연수가 주어진다.
 * [출력]
 * 첫째 줄부터 넷째 줄까지 차례대로 (3), (4), (5), (6)에 들어갈 값을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class Mutiplication {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_mutiplication_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		for(int i=0, temp=M;i<3;i++){
			System.out.println(N*(temp%10));
			temp/=10;
		}
		System.out.println(N*M);
	}
}
