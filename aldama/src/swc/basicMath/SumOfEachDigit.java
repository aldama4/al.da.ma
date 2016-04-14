package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 자연수 N을 입력받아서 각 자리수의 합이 한자리가 될 때까지 그 합을 출력하는 프로그램을 작성하시오.
 * 
 * ※ int형 변수로는 232-1 까지 입력받을 수 있다.
 * [입력]
 * 양의 정수 N을 입력받는다. (1 ≤ N ≤ 263-1)
 * [출력]
 * 첫 번째 줄에 입력받은 수의 각 자리수의 합을 출력한다. 
 * 출력한 수가 10 이상이면 그 수의 각 자리수의 합을 다음줄에 출력한다. 
 * 출력한 수가 10 미만이 될 때까지 반복하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class SumOfEachDigit {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_sumOfEachDigit_input.txt"));
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		char[] C;
		while(N > 9){
			long temp=0L;
			C = String.valueOf(N).toCharArray();
			for (char d : C) {
				temp += (long)d-48L;
			}
			System.out.println(N=temp);
		}
	}

}
