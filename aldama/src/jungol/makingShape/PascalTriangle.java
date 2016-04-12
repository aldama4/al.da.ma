package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 파스칼 삼각형이란 아래 <표1> 과 같은 자신의 왼쪽 위의 좌표와 오른쪽 위의 좌표 값을 더해서 값을 계속 갱신시켜 나가는 형태의 삼각형을 말한다. 
 * 아래와 같은 파스칼 삼각형의 높이 n과 종류 m을 입력받은 후 다음과 같은 형태의 파스칼 삼각형을 출력하는 프로그램을 작성하시오.
 * 
 *              1
 *             1 1
 *            1 2 1
 *           1 3 3 1
 *          1 4 6 4 1
 *         <N = 5 일때>
 * <처리조건> m에 대한 파스칼 삼각형의 모습은 아래 <표2>의 모습과 같다.
 * 1                1 4 6 4 1            1
 * 1 1               1 3 3 1             4 1
 * 1 2 1              1 2 1              6 3 1
 * 1 3 3 1             1 1               4 3 2 1
 * 1 4 6 4 1            1                1 1 1 1 1
 *  <종류 1>           <종류 2>              <종류 3> 
 * [입력]
 * 삼각형의 높이n(1부터 30사이의 정수)과 종류m(1부터 3사이의 정수)을 입력받는다.
 * [출력]
 * 위에서 제시한 형태의 파스칼 삼각형을 입력에서 들어온 높이 n과 종류 m에 맞춰서 출력한다. 숫자는 한칸의 공백으로 구분하여 출력한다.
 * 
 * @author KooKoo
 *
 */
public class PascalTriangle {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_pascalTriangle_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		if(N < 1 || N > 30 || M < 1 || M > 3){
			return;
		}
		int[][] data = new int[N][];
		for(int i=0;i<N;i++){
			data[i] = new int[i+1];
			for(int j=0;j<data[i].length;j++){
				if(j==0 || j==data[i].length-1){
					data[i][j] = 1;
				}else{
					data[i][j] = data[i-1][j-1] + data[i-1][j];
				}
			}
		}
		if(M==1){
			for(int i=0;i<N;i++){
				for(int j=0;j<data[i].length;j++){
					System.out.printf("%d ",data[i][j]);
				}
				System.out.println();
			}
		}else if(M==2){
			for(int i=0;i<N;i++){
				for(int j=0;j<i;j++){
					System.out.print(" ");
				}
				for(int k=0;k<data[N-1-i].length;k++){
					System.out.printf("%d ",data[N-1-i][k]);
				}
				System.out.println();
			}
		}else{
			for(int i=N-1;i>-1;i--){
				for(int j=0;j<N-i;j++){
					System.out.printf("%d ",data[N-1-j][i]);
				}
				System.out.println();
			}
		}
	}
}
