package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 소수(prime number)란 1보다 큰 자연수 중 1과 자기 자신 두 개만을 약수로 갖는 수를 말한다. 
 * 자연수 M과 N을 입력받아 M부터 N까지 소수의 개수를 구하여 출력하는 프로그램을 작성하시오.
 * [입력]
 * 자연수 M과 N이 공백으로 구분되어 주어진다. (1 ≤ M ≤ N ≤ 2,000,000)
 * [출력]
 * M이상 N이하의 자연수 중 소수가 몇 개인지 구하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class CountOfPrime {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_countOfPrime_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		boolean[] checker = new boolean[M+1];
		int cnt = 0;
		for(int i=2;i<M+1;i++){
			if(!checker[i]){
				for(int j=2;i*j<M+1;j++){
					checker[i*j] = true;
				}
				if(i >= N){
					cnt++;
				}
			}
		}
		System.out.println(cnt);
	}
}
