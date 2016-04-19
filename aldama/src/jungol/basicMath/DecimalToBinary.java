package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 10진수를 입력받아 2진수로 변환하는 프로그램을 작성하시오.
 * [입력]
 * 정수 N을 입력받는다. (1 <= N <= 2^(31)-1)
 * [출력]
 * 입력된 10진수를 2진수로 변환하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class DecimalToBinary {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_decimalToBinary_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int d = sc.nextInt();
		boolean[] binary = new boolean[31];
		int l = -1;
		while(d>0){
			++l;
			binary[l] = d % 2 == 0 ? false : true;
			d/=2;
		}
		for(int i=l;i>-1;i--){
			System.out.print(binary[i]?1:0);
		}
		System.out.println();
	}

}
