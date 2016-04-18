package swc.basicMath;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 화장실 바닥을 새로운 타일로 교체하려고 한다. 타일은 모두 정사각형 모양으로 한 변의 길이는 정수로 표시되어 있다. 
 * 타일의 크기를 여러가지로 하면 보기가 싫기 때문에 모두 같은 크기의 타일을 사용하려고 한다. 
 * 타일의 개수가 많아지면 비용이 많이 들기 때문에 타일의 개수는 가능하면 최소한으로 사용하려고 한다.
 * [입력]
 * 화장실의 가로의 크기와 세로의 크기가 주어질 때 필요한 최소 타일의 개수를 구하는 프로그램을 작성하라.
 * 화장실 가로의 길이와 세로의 길이가 차례대로 입력된다. 1 <= 가로, 세로 <=1,000,000
 * [출력] 
 * 필요한 최소 타일의 개수를 출력한다.
 * 
 * @author KooKoo
 *
 */

public class ChangeTiles {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_changeTiles_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int M = sc.nextInt();
		int min = N > M ? M : N;
		int gcd = 1;
		for(int i = min; i>1;i--){
			if(N%i == 0 && M%i == 0){
				gcd = i;
				break;
			}
		}
		System.out.println((N/gcd)*(M/gcd));
	}

}
