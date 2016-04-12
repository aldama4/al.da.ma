package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 삼각형의 높이 n과 종류 m을 입력받은 후 다음과 같은 삼각형 형태로 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * 종류 1번의 숫자의 진행 순서는 처음에 왼쪽에서 오른쪽으로 진행 한 후 방향을 바꾸어서 이를 반복한다.
 * 
 * 1                     0 0 0 0 0 0 0 0 0            1
 * 3 2                     1 1 1 1 1 1 1              1 2
 * 4 5 6                     2 2 2 2 2                1 2 3
 * 10 9 8 7                    3 3 3                  1 2
 * 11 12 13 14 15                4                    1
 * <종류1>                     <종류 2>                <종류 3>
 * 
 * 
 * 삼각형의 크기 n(n의 범위는 100 이하의 홀수)과 종류 m(m은 1부터 3사이의 정수)을 입력받는다.
 * 
 * 
 * 위에서 언급한 3가지 종류를 입력에서 들어온 높이 n과 종류 m에 맞춰서 출력한다. 숫자사이는 공백으로 구분한다. 입력된 데이터가 주어진
 * 범위를 벗어나면 "INPUT ERROR!"을 출력한다.
 * 
 * @author KooKoo
 *
 */
public class NumberTriangle {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_numberTriangle_input.txt"));
		Scanner sc = new Scanner(System.in);	
		int N = sc.nextInt();
		int M = sc.nextInt();
		if(N%2==0 || N < 1 || N > 100 || M < 1 || M > 3){
			System.out.println("INPUT ERROR!");
			return;
		}
		int cnt = 0, num=0, end=0, sw=0;
		for(int i=0;i<N;i++){
			if(M==1){
				sw = i%2==0 ? 1 : -1;
				cnt= cnt+i+1;
				end = i+1;
				num = i%2==0 ? cnt-(i+1) : cnt+1;
			}else if(M==2){
				num = i;
				end = 2*(N-i)-1;
				for(int j=0;j<i;j++){
					System.out.print("  ");
				}
			}else{
				sw = 1;
				end += i > N/2 ? -1 : 1;
			}
			for(int k=0;k<end;k++){
				System.out.printf("%d ", num+sw*(k+1));
			}
			System.out.println();
		}
	}

}
