package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 N을 입력받아 아래와 같은 모양을 출력하는 프로그램을 작성하시오.
 * 
 * *
 *  ***
 *   *****
 *    *******
 *   *****
 *  ***
 * *
 * <N = 7일때>
 * [입력]
 * 삼각형의 높이 N(N의 범위는 100 이하의 양의 홀수)을 입력받는다.
 * [출력]
 * N의 높이에 맞추어 주어진 형태의 모양을 출력한다. 입력된 데이터가 주어진 범위를 벗어나면 "INPUT ERROR!"를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class StarTriangle3 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_starTriangle3_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		if(N%2==0 || N<1 || N>100){
			System.out.println("INPUT ERROR!");
			return;
		}
		for(int i=0,blank=-1;i<N;i++){
			int sw = i>N/2? -1 : 1;
			blank += sw;
			for(int j=0;j<blank;j++){
				System.out.print(" ");
			}
			for(int k=0;k<2*blank+1;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
