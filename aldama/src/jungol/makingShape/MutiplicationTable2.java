package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 원하는 구구단의 범위를 입력받아 해당 구간의 구구단을 출력하는 프로그램을 작성하시오.
 * 
 * <처리조건> 
 * (1) 구간의 처음과 끝을 입력받는다. 
 * (2) 입력된 구간은 반드시 처음 입력 값이 끝의 입력 값보다 작아야 하는 것은 아니다. 
 *     즉, 입력된 구간의 범위는 증가하거나 감소하는 순서 그대로 출력되어야 한다.
 * [입력]
 * 구구단의 시작 범위 s와 끝 범위 e를 입력받는다. (s와 e는 2부터 9사이의 정수)
 * [출력]
 * 시작 범위와 끝 범위사이의 구구단을 출력하되 모든 값과 부호 사이는 공백으로 구분하여 아래 출력 예와 같이 줄을 맞추어 출력해야 한다.
 * 식과 식 사이는 3개의 공백으로 구분하고 구구단 사이에는 한 줄을 비워 두도록 한다.
 * 
 * @author KooKoo
 *
 */
public class MutiplicationTable2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_mutiplicationTable2_input.txt"));
		Scanner sc = new Scanner(System.in);
		int S = sc.nextInt();
		int E = sc.nextInt();
		if(S<2 || S > 9 || E < 2 || E>9){
			return;
		}
		int sw = S > E ? -1 : 1;
		for(int n=S;n!=E+sw;n+=sw){
			for(int i=0, cnt=0;i<3;i++){
				for(int j=0;j<3;j++){
					System.out.printf("%d * %d = %2d   ", n, ++cnt, n*cnt);
				}
				System.out.println();
			}
			System.out.println();
		}
	}
}
