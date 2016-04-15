package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 자연수 M과 N이 주어질 때 M이상 N이하의 자연수 중 소수인 것을 모두 골라 이들 소수의 합과 최소값을 찾는 프로그램을 작성하시오.
 * 
 * 예를 들어 M=60, N=100이 경우 60이상 100이하의 자연수 중 소수는 
 * 61, 67, 71, 73, 79, 83, 89, 97 총 8개가 있으므로, 이들 소수의 합은 620이고, 최소값은 61이 된다.
 * [입력]
 * 입력의 첫째 줄에 M이, 둘째 줄에 N이 주어진다. M과 N은 10,000이하의 자연수이며, M은 N보다 같거나 작다.
 * [출력]
 * M이상 N이하의 자연수 중 소수인 것을 모두 찾아 첫째 줄에 그 합을, 둘째 줄에 그 중 최소값을 출력한다. 
 * 단, M이상 N이하의 자연수 중 소수가 없을 경우는 첫째 줄에 -1을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class Prime {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/basicMath_prime_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = 0, sum = 0;
		boolean[] filter = new boolean[M+1];
		for(int i=2;i<M+1;i++){
			if(!filter[i]){
				for(int j=2;i*j<M+1;j++){
					filter[i*j] = true;
				}
				if(i > N-1){
					if(min==0){
						min = i;
					}
					sum+=i;
				}
			}
		}
		if(sum==0){
			System.out.println(-1);
		}else{
			System.out.println(sum);
			System.out.println(min);
		}
	}

}
