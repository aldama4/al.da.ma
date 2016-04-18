package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 소수(prime number)란 1보다 큰 자연수 중 1과 자기 자신 두 개만을 약수로 갖는 수를 말한다. 
 * 합성수(composite number)란 1보다 큰 자연수 중 소수가 아닌 수를 말하며 3개 이상의 약수를 갖는다. 
 * 1은 소수도 합성수도 아니다. 5개의 자연수를 입력받아 소수인지 합성수인지를 판단하는 프로그램을 작성하시오.
 * [입력]
 * 10억 이하의 자연수 5개가 공백으로 구분되어 주어진다.
 * [출력]
 * 입력된 순서대로 한 줄에 한 개씩 소수이면 "prime number", 합성수이면 "composite number", 소수도 합성수도 아니면 "number one"이라고 출력한다.
 * 
 * @author KooKoo
 *
 */
public class PrimeAndComposite {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_primeAndComposite_input.txt"));
		Scanner sc = new Scanner(System.in);
		loop : for(int i=0; i<5; i++){
			int temp = sc.nextInt();
			if(temp == 1){
				System.out.println("number one");
			}else{
				for(int j=2;j<Math.sqrt(temp)+1;j++){
					if(temp % j == 0){
						System.out.println("composite number");
						continue loop;
					}
				}
				System.out.println("prime number");
			}
		}
	}
}
