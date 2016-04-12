package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 정사각형의 크기를 입력 받은 후 대각선으로 지그재그 형태인 다음과 같은 형태로 출력하는 프로그램을 작성하시오.
 * 
 * < 처리조건 > 
 * (1) 가장 왼쪽 위의 좌표부터 차례로 숫자를 대입시킨다. 
 * (2) 대각선을 기준으로 계속 지그재그 모양으로 채워져야 하며 숫자는 1씩 증가하는 형태로 채워나가야 한다.
 * 
 *  1  3  4 10 11  
 *  2  5  9 12 19 
 *  6  8 13 18 20
 *  7 14 17 21 24
 * 15 16 22 23 25
 * <크기가 5일 경우>
 * [입력]
 * 정사각형의 크기 n(1부터 100사이의 정수)을 입력받는다.
 * [출력]
 * 위에서 언급한 형태의 지그재그 모양의 정사각형의 내부 숫자를 차례로 채운 후의 모습을 출력한다. 
 * 숫자 사이는 공백으로 구분한다.
 * 
 * @author KooKoo
 *
 */
public class DiagonalZigzag {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_diagonalZigzag_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[][] data = new int[N][N];
		int cnt = 1, sw = 1, x = 0, y = 0;
		data[y][x] = cnt; 
		while(cnt < N*N){
			if(sw == 1){
				if(x == 0 && y < N-1){
					y++;
				}else{
					x++;
				}
			}else if(sw == -1){
				if(y == 0 && x < N-1){
					x++;
				}else{
					y++;
				}
			}
			data[y][x] = ++cnt; 
			
			while(y-sw>=0&&y-sw<N && x+sw>=0&&x+sw<N){
				data[y-=sw][x+=sw] = ++cnt;
			}
			sw = sw == 1? -1 : 1;
		}
		for (int[] is : data) {
			for (int i : is) {
				System.out.printf("%d ",i);
			}
			System.out.println();
		}
	}

}
