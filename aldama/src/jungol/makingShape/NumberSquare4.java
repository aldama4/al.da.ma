package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 정사각형의 한 변의 길이 n과 종류 m을 입력받은 후 다음과 같은 정사각형 형태로 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * 종류 2번의 경우 숫자의 진행 순서는 처음에 왼쪽에서 오른쪽으로 너비 n만큼 진행 한 후 방향을 바꾸어서 이를 반복한다.
 * 1 1 1 1 1     1 2 3 4 5     1 2 3 4 5
 * 2 2 2 2 2     5 4 3 2 1     2 4 6 8 10
 * 3 3 3 3 3     1 2 3 4 5     3 6 9 12 15
 * 4 4 4 4 4     5 4 3 2 1     4 8 12 16 20
 * 5 5 5 5 5     1 2 3 4 5     5 10 15 20 25
 *  <종류1>
 * [입력]
 * 정사각형 한 변의 길이 n(n의 범위는 100 이하의 정수)과 종류 m(m은 1부터 3사이의 정수)을 입력받는다.
 * [출력]
 * 위에서 언급한 3가지 종류를 입력에서 한 변의 길이 n과 종류 m에 맞춰서 출력한다. 숫자 사이는 공백으로 구분하여 출력한다.
 * 
 * @author x16
 *
 */
public class NumberSquare4 {

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/jungol/makingShape_numberSquare4_input.txt"));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
		int N = sc.nextInt();
		int type = sc.nextInt();
		int[][] data = new int[N][N];
		int num = 0;
		int sw = 0;
		for(int i=0;i<N;i++){
			if(type==1){
				num = i+1;
			}else if(type==2){
				sw = i%2==0?1:-1;
				num = i%2==0?0:N+1;
			}else if(type==3){
				sw = i+1;
				num = 0;
			}
			for(int j=0;j<N;j++){
				data[i][j] = num+=sw;
			}
		}
		
		for(int i=0;i<N;i++){
			for(int j=0;j<N;j++){
				System.out.printf("%d ",data[i][j]);
			}
			System.out.println();
		}
		System.out.println();
		}
	}

}
