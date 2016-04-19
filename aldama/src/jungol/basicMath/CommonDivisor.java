package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 어떤 두 자연수에 공통인 약수들 중에서 가장 큰 수를 최대공약수라고 하고, 
 * 두 자연수의 공통인 배수들 중에서 가장 작은 수를 최소공배수라고 한다.
 * 
 * 예를 들어, 두 자연수 12와 90의 최대공약수는 6이며, 최소공배수는 180이다.
 * 
 * 이와 반대로 두 개의 자연수 A, B가 주어졌을 때, A를 최대공약수로, B를 최소공배수로 하는 두 개의 자연수를 구할 수 있다. 
 * 그러나, 이러한 두 개의 자연수 쌍은 여러 개 있을 수 있으며, 또한 없을 수도 있다.
 * 
 * 예를 들어, 최대공약수가 6이며 최소공배수가 180인 두 정수는 위의 예에서와 같이 12와 90일 수도 있으며, 
 * 30과 36, 18과 60, 혹은 6과 180일 수도 있다. 
 * 그러나, 최대공약수가 6이며 최소공배수가 20인 두 자연수는 있을 수 없다.
 * 
 * 두 개의 자연수가 주어졌을 때, 이 두 수를 최대공약수와 최소공배수로 하는 두 개의 자연수를 구하는 프로그램을 작성하시오.
 * [입력]
 * 첫째 줄에 두 개의 자연수가 빈칸을 사이에 두고 주어진다. 
 * 첫 번째 수는 어떤 두 개의 자연수의 최대공약수이고, 두 번째 수는 그 자연수들의 최소공배수이다. 
 * 입력되는 두 자연수는 2 이상 100,000,000 이하이다.
 * [출력]
 * 첫째 줄에는 입력되는 두 자연수를 최대공약수와 최소공배수로 하는 두 개의 자연수를 크기가 작은 수부터 하나의 공백을 사이에 두고 출력한다.
 * 입력되는 두 자연수를 최대공약수와 최소공배수로 하는 두 개의 자연수 쌍이 여러 개 있는 경우에는 
 * 두 자연수의 합이 최소가 되는 두 수를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class CommonDivisor {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_commonDivisor_input.txt"));
		Scanner sc = new Scanner(System.in);
		long gcd = sc.nextInt();
		long lcm = sc.nextInt();
		long a=0, b=0, min=Long.MAX_VALUE;
		loop : for(long i=lcm,ii=2;i>Math.sqrt(lcm);i=lcm/++ii){
			long temp = gcd * lcm / i;
			if(i*temp == lcm * gcd && i % gcd == 0 && temp % gcd == 0){
				for(long j=gcd+1;j<i;j++){
					if(i%j==0 && temp%j==0){
						continue loop;
					}
				}
				if(min > i+temp){
					min = i+temp;
					a = i > temp ? temp : i;
					b = i > temp ? i : temp;
				}
			}
		}
		System.out.println(a+" "+b);
	}

}