package jungol.dataProcess;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 선택 정렬(selection sort)이란 내부정렬 알고리즘의 하나로 다음 순서대로 실행하여 정렬을 한다. 
 * 1. 주어진 수열 중에 최소값을 찾는다. 
 * 2. 찾은 최소값을 맨 앞의 값과 자리를 바꾼다. 
 * 3. 맨 앞의 값을 뺀 나머지 수열을 같은 방법으로 전체 개수-1번 반복 실행한다. 
 * n개의 주어진 수열을 위와 같은 방법으로 정렬한다. 수열이 주어지면 선택정렬의 과정을 한 단계씩 출력한다.
 * [입력]
 * 첫줄에 수열의 길이 N(4≤N≤100)이 주어진다.
 * 두 번째 줄에 N개의 0이상 100이하의 정수가 주어진다.
 * [출력] 
 * 처음 상태를 제외하고 정렬과정의 각 단계별 결과를 "출력형식"과 같이 출력한다.
 * 
 * @author KooKoo
 *
 */
public class SelectionSort {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/dataProcess_selectionSort_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int data[] = new int[N];
		for(int n=0;n<N;n++){
			data[n] = sc.nextInt();
		}
		int min, temp;
			for(int i=0;i<data.length-1;i++){
				min = i;
				for(int k=i;k<data.length;k++){
					if(data[min] > data[k]){
						min = k;
					}
				}
				temp = data[min];
				data[min] = data[i];
				data[i] = temp;
				for (int d : data) {
					System.out.printf("%d ",d);
				}
				System.out.println();
			}
	}

}
