package jungol.makingShape;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 홀수 정사각형의 크기를 입력 받은 후, 가로 세로 대각선의 합이 일정한 마방진을 출력하는 프로그램을 작성하시오.
 * 
 * 마방진이란 1부터 N*N까지의 숫자를 한 번씩만 써서 정사각형에 배치하여 가로와 세로, 그리고 대각선의 합이 같도록 하는 것이다.
 * 
 * 다음의 순서에 따라 각 위치에 차례대로 값을 넣는다. 
 * 1. 첫 번째 숫자인 1을 넣는 위치는 첫 번째 행 가운데이다. 
 * 2. 숫자가 N의 배수이면 바로 아래의 행으로 이동하여 다음의 수를 넣고 
 * 3. 그렇지 않으면 왼쪽 위로 이동하여 다음의 숫자를 넣는다. 
 *    만약 행이 첫 번째를 벗어나면 마지막 행으로 이동하고, 열이 첫 번째를 벗어나면 마지막 열로 이동한다.
 * 
 * 6 1 8
 * 7 5 3
 * 2 9 4
 * 
 * 1. 첫 번째 행 가운데(1,2)에 1을 넣는다. 
 * 2. 왼쪽 위로 이동하면 (0,1)인데 행의 위치가 처음을 벗어났으므로 마지막행(3,1)의 위치로 이동하여 2를 넣는다. 
 * 3. 왼쪽 위로 이동하면 (2,0)인데 열의 위치가 처음을 벗어났으므로 마지막열(2,3)의 위치로 이동하여 3을 넣는다. 
 * 4. 배열에 넣은 값(3)이 N의 배수이므로 바로 아래행으로(3,3) 이동하여 4를 넣는다. 
 * 5. 왼쪽 위로 이동하여 (2,2) 5를 넣는다. 
 * 6. 왼쪽 위로 이동하여 (1,1) 6를 넣는다. 
 * 7. 배열에 넣은 값(6)이 N의 배수이므로 바로 아래행으로(2,1) 이동하여 7을 넣는다. 
 * 8. 왼쪽 위로 이동하면 (1,0)인데 열의 위치가 처음을 벗어났으므로 마지막열(1,3)의 위치로 이동하여 8을 넣는다. 
 * 9. 왼쪽 위로 이동하면 (0,2)인데 행의 위치가 처음을 벗어났으므로 마지막행(3,2)의 위치로 이동하여 9를 넣는다.
 * [입력]
 * 정사각형의 크기 n(2부터 100사이의 홀수)을 입력받는다.
 * [출력]
 * 위에서 언급한 형태로 정사각형의 내부 숫자를 차례로 채운 후의 모습을 출력한다. 숫자 사이는 공백으로 구분한다.
 * 
 * @author KooKoo
 *
 */
public class MagicSquare {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/makingShape_magicSquare_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int x = N/2, y=0, cnt=0;
		int[][] data = new int[N][N];
		data[y][x] = ++cnt;
		while(cnt < N*N){
			if(cnt%N==0){
				y++;
			}else{
				y--;
				x--;
			}
			x = x==-1? N-1 : x==N? 0 : x;
			y = y==-1? N-1 : y==N? 0 : y;
			data[y][x] = ++cnt;
		}
		
		for (int[] is : data) {
			for (int i : is) {
				System.out.printf("%d ",i);
			}
			System.out.println();
		}
	}

}
