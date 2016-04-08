package jungol.dataProcess;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 거품 정렬(Bubble sort)이란? 
 * 두 인접한 원소를 검사하여 자리를 바꾸는 과정을 반복하며 정렬하는 방법이다. 
 * 다음과 같은 과정으로 정렬을 한다. 
 * 1. 첫번째 값과 두번째 값을 비교하여 첫번째 값이 크면 자리를 바꾼다. 
 * 2. 두번째 값과 세번째 값을 비교하여 두번째 값이 크면 자리를 바꾼다. 
 * 3. 위와 같이 반복하여 N-1번째 값과 N번째 값을 비교하여 N-1번째 값이 크면 자리를 바꾼다. 
 *    이 단계가 끝나면 N번째에 가장 큰 수가 자리하게 된다. (한단계완료) 
 * 4. N번째를 제외하고 1~3을 반복하면 N-1번째에 두 번째로 큰수가 자리한다. (2단계 완료) 
 * 5. 위와같은 작업을 N-1번 반복하면 모든 데이터가 순서대로 정렬된다. 
 *    예를 들어 수열 {62, 23, 32, 15} 가 있을 때 아래와 같은 과정으로 정렬이 된다.
 *   62 ? 23   32   15
 *   23   62 ? 32   15
 *   23   32   62 ? 15
 *   23 ? 32   15  [62]
 *   23   32 ? 15  [62]
 *   23 ? 15  [32   62]
 *  [15   23   32   62]
 * ([] 칸은 정렬이 끝나 더이상 확인 안해도 되는 값이다.) 
 * 정렬되지 않은 수열이 주어지면 버블정렬의 각 단계가 끝날때마다 결과를 출력하는 프로그램을 작성하시오
 * [입력]
 * 첫줄에 수열의 길이 N(4≤N≤100)이 주어진다.
 * 두 번째 줄에 N개의 0이상 100이하의 정수가 주어진다.
 * [출력] 
 * 처음 상태를 제외하고 정렬과정의 각 단계별 결과를 "출력예"와 같이 출력한다.
 * 
 * @author KooKoo
 *
 */
public class BubbleSort {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/dataProcess_bubbleSort_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] data = new int[N];
		for(int n=0;n<N;n++){
			data[n] = sc.nextInt();
		}
		
		int temp;
		for(int n=N;n>1;n--){
			for(int i=0;i<n-1;i++){
				if(data[i] > data[i+1]){
					temp = data[i];
					data[i] = data[i+1];
					data[i+1] = temp;
				}
			}
			for (int d : data) {
				System.out.printf("%d ",d);
			}
			System.out.println();
		}

	}

}
