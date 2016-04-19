package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 소수(prime number)란 2이상의 수로써 1과 자기 자신 외에는 약수를 갖지 않는 수를 의미한다. 
 * 임의의 M값에 대하여 M에 가장 가까운 소수를 구하는 프로그램을 아래 조건에 따라 작성한다.
 * [입력]
 * 첫 번째 줄에는 처리해야 할 수의 개수 N을 입력 받는다. (N은 100이하의 정수)
 * 다음 줄에는 처리해야할 수 N개(M1부터 Mn까지)를 한 줄에 한 개씩 차례로 입력 받는다. (Mi 는 1,000,000 이하의 양의 정수)
 * 데이터의 크기가 주어진 범위를 벗어나는 입력은 없다.
 * [출력]
 * 임의의 값 Mi에 대해 차이가 가장 작은 소수를 구하여 출력한다.
 * 만약 차이가 같은 소수가 여러 개이면 작은수부터 모두 출력한다.
 * 
 * @author KooKoo
 *
 */
public class CalPrime {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_calPrime_input.txt"));
		Scanner sc = new Scanner(System.in);
		int MAX = 1300000;
		boolean[] checker = new boolean[MAX+1];
		int N = sc.nextInt();
		int[] data = new int[N];
		for(int i=0;i<N;i++){
			data[i] = sc.nextInt();
		}
		for(int i=2;i<Math.sqrt(MAX)+1;i++){
			if(!checker[i]){
				for(int j=2;i*j<MAX+1;j++){
					checker[i*j] = true;
				}
				
			}
		}
		
		for (int i : data) {
			int[] temp = new int[2];
			int idx = 0;
			if(!checker[i]){
				System.out.println(i);
			}else{
				for(int j=1;;j++){
					if(i-j > 1 && !checker[i-j]){
						temp[idx++] = i-j;
					}
					if(i+j < MAX+1 && !checker[i+j]){
						temp[idx] = i+j;
					}
					
					if(temp[0] > 0){
						break;
					}
				}
				for(int n=0;n<2&&temp[n]!=0;n++){
					System.out.printf("%d ",temp[n]);
				}
				System.out.println();
			}
		}
		
	}

}
