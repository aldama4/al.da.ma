package swc.greedy;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 정올 도서관은 학생들을 위하여 항상 열려있다. 
 * 학생의 입장에서는 아무 때든 도서관을 찾아 공부할 수 있어 편리하지만 정올 도서관의 입장에서는 그리 효율적이지 못했다. 
 * 학생이 몇 명 되지 않는 시간에도 모든 시설을 열어야 하며 심지어 학생이 오지 않는 시간에도 도서관을 열고 있어야 했다.
 * 이러한 문제점을 개선하고자 도서관 관리자인 창환이는 학생들의 도서관 이용 시간을 분석하고자 한다. 
 * 먼저 하루 중 도서관에 학생들이 머물고 있는 가장 긴 시간과 학생들이 다녀간 전체 시간 중 
 * 학생이 하나도 없었던 가장 긴 시간을 알아보는 것이다.
 * 예를 들어, 오늘 도서관에 온 학생이 준호, 서훈, 서은, 규찬 4명이고 준호의 이용시간은 1에서 3, 
 * 서훈의 이용시간은 3에서 6, 서은의 이용시간은 3에서 8, 규찬의 이용시간은 12에서 17 일때, 
 * 학생들이 머물었던 가장 긴 시간은 7, 학생들이 하나도 없었던 가장 긴 시간은 8~12까지 4가 된다.
 * N(1≤N≤10,000)의 학생이 도서관을 이용한다고 할 때, 다음을 계산하는 프로그램을 작성하시오. 
 * - 적어도 한 명 이상의 학생이 머물었던 가장 긴 시간 
 * - 학생들이 다녀간 전체 시간 중 학생이 한 명도 머물지 않았던 가장 긴 시간
 * [입력]
 * 첫 줄에 정수 N(1≤N≤10000)이 입력된다.
 * 두 번째 줄부터 N개의 줄에 걸쳐 두 정수 S, E(1≤S≤E≤(2^31)-1) 가 입력된다. 
 * S는 도서관에 들어온 시각 E는 학생이 도서관을 나간 시각이다.
 * [출력] 
 * 한 명 이상의 학생이 머물었던 가장 긴 시간과 학생이 한 명도 머물지 않았던 가장 긴 시간을 공백을 구분하여 한 줄에 출력하시오.
 * @author KooKoo
 *
 */
public class Library_Jade {
	// 들어온 시간 순으로 입력이 안되는 경우를 생각해볼 때에, 정렬이 필요.
	// 정렬된 상태로, 최초 학생의 입장시간(첫 정수값)을 stayingMin 으로 가지고, 퇴장시간(두번째 정수값)을 stayingMax로 놓고,
	// 다음 입력되는 학생의 입장시간이 stayingMax보다 작거나 같은지를 확인하고, 맞다면 두번째 학생의 퇴장시간을 stayingMax로 저장한다.
	// 이런식으로 이어가다가 n 번째의 학생의 입장시간이 stayingMax 보다 크다면 nobodyLength = 입장시간 - stayingMax 를 수행한다.
	// 입력 E 의 범위가 2에 31승 -1 까지 입력이 가능한 점으로 볼 때 입력이 하나이고, S = 1, E = (2^31)-1 일 때
	// 한명이상 머문 가장 긴 시간은 2^31, 머물지 않았던 가장 긴 시간은 0이 된다.
	static int S=0, E=1;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/greedy_library_input.txt"));
		Scanner sc = new Scanner(System.in);
		int[] stayingTime = new int[2];
		int stayingMax=0;
		int nobodyMax=0;
		stayingTime[S] = 1;
		stayingTime[E] = 1;
		int N = sc.nextInt();
		int[][] visitedStudents = new int[N][2];
		for(int n=0;n<N;n++){
			visitedStudents[n][S] = sc.nextInt();
			visitedStudents[n][E] = sc.nextInt();
		}
		
		Arrays.sort(visitedStudents, new Comparator<int[]>() {
			@Override
			public int compare(int[] o1, int[] o2) {
				return o1[S] - o2[S];
			}
		});
		int stayingLength, nobodyLength;	
		for(int n=0;n<N;n++){
			int s = visitedStudents[n][S];
			int e = visitedStudents[n][E];
			if(stayingTime[E] >= s){
				if(stayingTime[E]<e){
					stayingTime[E] = e;
				}
			}else{
				stayingLength = stayingTime[E] - stayingTime[S];
				stayingMax = stayingMax < stayingLength ? stayingLength : stayingMax;
				nobodyLength = s - stayingTime[E];
				nobodyMax = nobodyMax < nobodyLength ? nobodyLength : nobodyMax;
				stayingTime[S] = s;
				stayingTime[E] = e;
			}
		}
		stayingLength = stayingTime[E] - stayingTime[S];
		stayingMax = stayingMax < stayingLength ? stayingLength : stayingMax;
		
		System.out.println(stayingMax+" "+nobodyMax);
	}
}
