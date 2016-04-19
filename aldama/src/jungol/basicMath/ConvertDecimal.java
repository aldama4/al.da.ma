package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 10진수를 입력 받아서 2, 8, 16진수로 바꾸어 출력하는 프로그램을 작성하시오.
 * [입력]
 * 입력의 첫줄에는 10진수 N(1≤N≤100,000)과 바꿀 진수 B(2, 8, 16)가 공백으로 구분하여 입력된다.
 * 16진수에서 10이상의 수는 순서대로 'A', 'B', 'C', 'D', 'E', 'F'로 나타낸다.
 * [출력] 
 * 입력받은 10진수를 B진수로 바꾸어 출력한다.
 * 
 * @author KooKoo
 *
 */
public class ConvertDecimal {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_covertDecimal_input.txt"));
		Scanner sc = new Scanner(System.in);
		int d = sc.nextInt();
		int c = sc.nextInt();
		char[] num = new char[16]; // 2진수 131071 표현가능
		int idx=-1;
		while(d>0){
			int mod = d%c;
			num[++idx] = c==16&&mod>9?(char)('A'+mod-10):(char)(mod+48);
			d/=c;
		}
		for(int i=idx;i>-1;i--){
			System.out.printf("%c",num[i]);
		}
		System.out.println();
	}

}
