package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 주어진 정수들 중 입력받은 수의 약수와 배수의 합을 각각 출력하라.
 * [입력]
 * 첫 줄에 정수의 개수 n (1<= n <=40)을 입력받는다. 
 * 둘째 줄에는 n개의 정수를 한 줄에 입력 받는다. 
 * 셋째 줄에는 약수와 배수를 구할 정수 m(1<=m<=100)을 입력 받는다.
 * [출력]
 * 첫 줄에는 정수 m의 약수의 합을 둘째 줄에는 정수 m의 배수의 합을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class DivisorAndMultiple {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_divisorAndMultiple_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] data = new int[N];
		int dsum = 0, msum=0;
		for(int n=0;n<N;n++){
			data[n] = sc.nextInt();
		}
		int M = sc.nextInt();
		for (int i : data) {
			dsum = M%i == 0 ? dsum+i : dsum;
			msum = i%M == 0 ? msum+i : msum;
		}
		System.out.println(dsum);
		System.out.println(msum);
	}

}
