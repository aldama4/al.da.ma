package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 두개의 자연수를 입력받아 최대 공약수와 최소 공배수를 출력하는 프로그램을 작성하시오.
 * [입력]
 * 입력 파일의 첫째 줄에는 두 개의 자연수가 주어진다. 
 * 이 둘은 10,000이하의 자연수이며 사이에 한 칸의 공백이 주어진다.
 * [출력]
 * 첫째 줄에는 입력으로 주어진 두 수의 최대공약수를 둘째 줄에는 입력으로 주어진 두 수의 최소 공배수를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class GCDnLCM {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_GCDnLCM_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int b = N > M ? N : M;
		int s = N > M ? M : N;
		int gcd=1;
			for(int i=2;i<s+1;i++){
				if(N%i==0 && M%i==0){
					gcd = i;
				}
			}
			System.out.println(gcd);
			System.out.println(b*(s/gcd));
	}
}
