package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 컴퓨터는 내부적으로 0과 1 두 개의 숫자만을 사용하여 모든 프로그램이 동작된다. 
 * 이렇게 두 개의 숫자만으로 이루어진 수를 이진수라 한다.
 * 2진수를 입력받아 10진수로 변환하여 출력하는 프로그램을 작성하시오.
 * [입력]
 * 0과 1로만 이루어져 있는 30자리 이하의 2진수를 입력받는다.
 * [출력]
 * 입력된 2진수를 10진수로 변환하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class Binary {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_binary_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int num = 0;
		char[] binary = sc.next().toCharArray();
		int l = binary.length;
		for(int i=l-1;i>-1;i--){
			int m = 1;
			for(int j=1;j<l-i;j++){
				m *= 2;
			}
			num+=(int)(binary[i]-48)*m;
		}
		System.out.println(num);
	}

}
