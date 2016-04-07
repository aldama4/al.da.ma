package jungol.level1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 369게임은 많은 사람들이 즐기는 게임으로 원으로 둘러앉아서 
 * 순서대로 1 부터 숫자를 부르면서 3 이 들어가는 숫자(다른 방법으론 3의 배수)를 부를 경우 숫자 대신 박수를 쳐야하는 게임이다.
 * 
 * 어느날 정올의 학생들이 소풍을 가서 369게임을 하려고 한다. 
 * 하지만 369 게임은 너무 식상하다 생각하던 차라 박수를 치는 수를 
 * 소수(1이외에 자기 자신으로만 나눠지는 2이상의 숫자)로 바꿔서 게임을 하고자 한다.
 * 
 * 게임을 학생들의 수와 마지막에 부른 번호가 주어졌을 때 특정 사람이 박수를 몇 번 쳤는지 알아보는 프로그램을 작성하라.
 * [입력]
 * 입력은 한 줄로 주어진다. 
 * 학생 수 N(2≤N≤1,000)이 주어지고, 끝까지 부른 숫자 M(1≤M≤1,000,000)이 주어지며, 
 * 박수를 몇 번 쳤는지 알고 싶은 사람의 번호 K(0≤K＜N) 가 주어진다. 
 * 첫 번째 숫자를 부르는 학생은 0번 마지막 학생은 N-1번이며 N-1번 학생 다음에는 0번 학생의 차례가 오게 된다.
 * [출력]
 * 해당 번호의 사람이 박수를 치는 횟수를 출력하라.
 * 
 * @author KooKoo
 *
 */
public class Prime369 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/level1_prime369_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		boolean isNotPrime[] = new boolean[M+1];
		int cnt = 0;
		
		for(int m=2;m<M/2;m++){
			if(isNotPrime[m]){
				continue;
			}else{
				int n = 2;
				while(m*n <= M){
					isNotPrime[m*n] = true;
					n++;
				}
			}
		}
		
		for(int m=1;m<=M;m++){
 			if((m-1)%N != K){
				continue;
			}else if(!isNotPrime[m]){
				cnt++;
			}
		}
		System.out.println(cnt);
	}

}
