package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 각형의 높이 n과 너비 m을 입력받은 후 사각형 내부에 지그재그 형태로 
 * 1부터 n*m번까지 숫자가 차례대로 출력되는 프로그램을 작성하시오.
 * < 처리조건 > 
 * 숫자의 진행 순서는 처음에 왼쪽에서 오른쪽으로 너비 m만큼 진행 한 후 방향을 바꾸어서 이를 반복한다.
 * 1 2 3 4 5
 * 10 9 8 7 6
 * 11 12 13 14 15
 * [입력]
 * 사각형의 높이n와 너비m( n과 m의 범위는 100 이하의 정수)을 입력받는다.
 * [출력]
 * 위에서 형태의 직사각형을 입력에서 들어온 높이 n과 너비 m에 맞춰서 출력한다. 숫자 사이는 공백으로 구분한다.
 * 
 * @author x16
 *
 */
public class NumberSquare2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_numberSquare2_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int num = 0;
		int sw,temp = 0;
		for(int n=0;n<N;n++){
			if(n%2==0){
				num = temp;
				sw = 1;
			}else{
				num += M+1;
				temp = num-1;
				sw = -1;
			}
			for(int m=0;m<M;m++){
				System.out.printf("%d ",num+=sw);
			}
			System.out.println();
		}
	}

}
