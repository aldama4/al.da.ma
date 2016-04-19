package jungol.basicMath;

import java.io.FileInputStream;
import java.util.ArrayDeque;
import java.util.Scanner;

/**
 * 한 개의 정수를 입력받아 입력받은 정수의 약수를 모두 출력하는 프로그램을 작성하시오.
 * [입력]
 * 정수 N이 주어진다. (2 ≤ N ≤ 21억)
 * [출력]
 * N의 약수를 작은 수부터 차례로 모두 출력한다.
 * 
 * @author KooKoo
 *
 */
public class Divisor {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_divisor_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		ArrayDeque<Integer>	stack = new ArrayDeque<Integer>();
		for(int i=1;i<Math.sqrt(N);i++){
			if(N%i==0){
				System.out.printf("%d ",i);
				stack.push(N/i);
			}
		}
		int sqrt = (int)Math.sqrt(N);
		if(sqrt*sqrt==N){ 
			stack.push((int)Math.sqrt(N));
		}
		while(stack.size() > 0){
			System.out.printf("%d ",stack.pop());
		}
		System.out.println();
	}
}
