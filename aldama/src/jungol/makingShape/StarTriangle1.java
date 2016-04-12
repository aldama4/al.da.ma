package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 n과 종류 m을 입력받은 후 다음과 같은 삼각형 형태로 출력하는 프로그램을 작성하시오.
 * 
 * *              *****             *
 * **             ****             ***
 * ***            ***             *****
 * ****           **             *******
 * *****          *             *********
 * <종류1>        <종류2>          <종류3>
 * 
 * [입력] 
 * 삼각형의 크기 n(n의 범위는 100 이하의 자연수)과 종류 m(m은 1부터 3사이의 자연수)을 입력받는다.
 * [출력]
 * 위에서 언급한 3가지 종류를 입력에서 들어온 높이 n과 종류 m에 맞춰서 출력한다. 
 * 입력된 데이터가 주어진 범위를 벗어나면 "INPUT ERROR!"을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class StarTriangle1 {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_starTriangle1_input.txt"));
		Scanner sc = new Scanner(System.in);
		boolean isInputError = false;
		do{
			int N = sc.nextInt();
			int M = sc.nextInt();
			isInputError = N<1 || N>100 || M<1 || M>3? true : false;
			if(isInputError){
				System.out.println("INPUT ERROR!");
				continue;
			}
			int end;			
			for(int i=0;i<N;i++){
				if(M==1){
					end = i+1;
				}else if(M==2){
					end = N-i;
				}else{
					end = 2*i+1;
					for(int j=1;j<N-i;j++){
						System.out.print(" ");
					}
				}
				for(int k=0;k<end;k++){
					System.out.print("*");
				}
				System.out.println();
			}
		}while(isInputError);
	}

}
