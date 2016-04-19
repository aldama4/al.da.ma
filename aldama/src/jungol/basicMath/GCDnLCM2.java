package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * n개의 정수를 입력받아서 최대공약수와 최소공배수를 구하는 프로그램을 작성하여 보자.
 * [입력]
 * 첫째 줄에 N (2≤N≤10) 을 입력받고 다음 줄에 N개의 정수를 공백으로 구분하여 입력받는다. 
 * 입력받는 정수는 2이상 10 000 이하이다.
 * 데이터의 크기가 주어진 범위를 벗어나는 입력은 없다.
 * [출력] 
 * 입력받은 정수들의 최대공약수와 최소공배수를 공백으로 구분하여 출력한다.
 * 최소공배수는 20억 이하의 정수이다.
 * 
 * @author KooKoo
 *
 */
public class GCDnLCM2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_GCDnLCM2_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] data = new int[N];
		
		for(int i=0;i<N;i++){
			data[i] = sc.nextInt();
		}
		Arrays.sort(data);
		int gcd = 0;
		int lcm = 0;
		loop1 : for(int i=1;i<data[0]+1;i++){
			for (int n : data) {
				if(n%i!=0)
					continue loop1;
			}
			gcd = i;
		}
		int j = 0;
		int max = data[data.length-1];
		loop2 : while(lcm == 0){
			j++;
			for (int i : data) {
				if((max*j)%i!=0)
					continue loop2;
			}
			lcm = max*j;
		}
		System.out.println(gcd+" "+lcm);
	}
}
