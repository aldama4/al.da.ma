package jungol.dataProcess;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삽입정렬(Insertion sort)은 자료 배열의 모든 요소를 앞에서부터 차례대로 이미 정렬된 배열 부분과 비교하여, 
 * 자신의 위치를 찾아 삽입하는 방법이다. 
 * 수열이 {5 4 3 7 6}이 있을 경우의 삽입정렬 과정은 다음과 같다.
 * 처음상태에서 처음 값 5 앞에 아무것도 없으므로 5는 이미 정렬된 상태가 되므로, 이후 4부터 정렬과정을 살펴보자. 
 * 1) [5] 4  3  7  6
 * 2) [4  5] 3  7  6
 * 3) [3  4  5] 7  6
 * 4) [3  4  5  7] 6
 * 5) [3  4  5  6  7]
 * ※ 3단계의 경우 7은 앞의 "3 4 5"보다 크므로 제자리에 삽입된다. 
 * n개의 수열이 주어지면 위와 같은 방법으로 정렬하는 과정 각 단계를 출력하는 프로그램을 작성하시오.
 * [입력]
 * 첫줄에 수열의 길이 N(4≤N≤100)이 주어진다.
 * 두 번째 줄에 N개의 0이상 100이하의 정수가 주어진다.
 * [출력] 
 * 처음 상태를 제외하고 정렬과정의 각 단계별 결과를 "출력예"와 같이 출력한다.
 * 
 * @author KooKoo
 *
 */
public class InsertionSort {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/dataProcess_insertionSort_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] data = new int[N];
		int temp;
		for(int n=0;n<N;n++)
		{
			data[n] = sc.nextInt();
		}
		for(int n=0;n<N;n++)
		{
			for(int i=n;i>0;i--){
				if(data[i-1] > data[i]){
					temp = data[i-1];
					data[i-1] = data[i];
					data[i] = temp;
				}
			}
			if(n > 0){
				for (int d : data) {
					System.out.printf("%d ",d);
				}
				System.out.println();
			}
		}
	}

}
