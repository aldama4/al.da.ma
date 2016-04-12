package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 n과 종류 m을 입력받은 후 다음과 같은 삼각형 형태로 출력하는 프로그램을 작성하시오. 다음은 n이 5인 경우의 예시이다.
 * 
 * *          *       *****       ***
 * **        **        ***         **
 * ***      ***         *           *
 * **        **        ***          **
 * *          *       *****         ***
 * <1>      <2>        <3>         <4>
 * [입력]
 * 삼각형의 크기 n(n의 범위는 100 이하의 홀수)과 종류 m(m은 1부터 4사이의 정수)을 입력받는다.
 * [출력]
 * 위에서 언급된 4가지 종류를 입력에서 들어온 높이 n과 종류 m에 맞춰서 출력한다. 
 * 입력된 데이터가 주어진 범위를 벗어나면 "INPUT ERROR!"을 출력한다. 
 * '*'과 '*' 사이에는 공백이 없다.
 * 
 * @author KooKoo
 *
 */
public class StarTriangle2 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_starTriangle2_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		if(N%2==0 || N>100 || N<1 || M<1 || M>4){
			System.out.println("INPUT ERROR!");
			return;
		}
		int sw;
		int blank = M==2? N/2+1 : -1;
		int end = M==3? N+2 : M==4? N/2+2 : 0;
		for(int i=0;i<N;i++){
			if(M==1){
				sw = i > N/2? -1 : 1;
				end += sw;
			}else{
				if(M==2){
					sw = i > N/2? -1 : 1;
					end+=sw;
					blank-=sw;
				}else if(M==3){
					sw = i > N/2? -2 : 2;
					end-=sw;
					blank=i>N/2?blank-1:blank+1;
				}else if(M==4){
					sw = i > N/2? -1 : 1;
					end-=sw;
					blank=i>N/2?blank:blank+1;
				}
				for(int j=0;j<blank;j++){
					System.out.print(" ");
				}
			}
			for(int k=0;k<end;k++){
				System.out.print("*");
			}
			System.out.println();
		}
	}

}
