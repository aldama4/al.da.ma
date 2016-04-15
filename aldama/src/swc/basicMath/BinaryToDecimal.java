package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 2진수를 입력받아 10진수로 바꾸어주는 프로그램을 작성하시오.
 * 
 * 입력받는 2진수는 8비트로 구성되어있으며 최상위비트는 부호비트이다. 
 * 즉, 최상위 비트의 값이 0이면 양수, 1이면 음수이며 음수의 경우 2의 보수로 구성되어있다.
 * 
 * 최상위 비트를 제외한 나머지 7개의 비트를 1, 2의 보수로 바꾸는 방법:
 * 1의 보수는 2진수의 1과 0을 바꾸면 된다. 
 *  1101000 -> 0010111 (2진수) (1의 보수)
 * 2의 보수는 1의 보수의 마지막 비트에 1을 더한다. 
 * 0010111 (1의 보수) + 1 --------- 0011000 (2의 보수)
 * [입력]
 * 입력의 첫 줄에 8자리의 2진수가 들어온다.
 * [출력]
 * 출력의 첫 줄에 10진수로 변환한 값을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class BinaryToDecimal {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_binaryToDecimal_input.txt"));
		Scanner sc = new Scanner(System.in);
		char[] binary = sc.next().toCharArray();
		int l = binary.length;
		int p = binary[0] == '1' ? -1 : 1;
		char checker = binary[0] =='1' ? '0' : '1';
		int num = binary[0] == '1' ? 1 : 0;
		for(int i=l-1;i>0;i--){
			int m=1;
			if(binary[i]==checker){
				for(int j=1;j<l-i;j++){
					m*=2;
				}
				num+=m;
			}
		}
		System.out.println(num*p);
	}
}
