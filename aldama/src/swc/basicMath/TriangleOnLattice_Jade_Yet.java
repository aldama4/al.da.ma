package swc.basicMath;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

// 잘 모르겠다... ㅠㅠ
public class TriangleOnLattice_Jade_Yet {
	static int X=0, Y=1;
	static int[][] triangle;
	static int[] a,b,c, sign;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/basicMath_triangleOnLattice_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int tc=1;tc<=T;++tc){
			a = new int[3];
			b = new int[3];
			c = new int[3];
			sign = new int[3];
			triangle = new int[3][2];
			for(int i=0;i<3;i++){
				triangle[i][X] = sc.nextInt();
				triangle[i][Y] = sc.nextInt();
			}
			Arrays.sort(triangle, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return a[X] - b[X];
				}
			});
			System.out.printf("#%d %d",tc,countPointInTriangle());
			System.out.println();
		}
		
		
		

	}

	private static int countPointInTriangle() {
		// 1. 입력된 3개의 점으로 삼각형을 그릴 수 있는가 확인. 그릴 수 없으면 0 출력
		if(isNotTriangle()){
			return 0;
		}
		return 1;
	}

	private static boolean isNotTriangle() {
		// 삼각형이 불가한 경우? 같은 선상에 3점이 있는 경우.
		int j=0, k=0;
		for (int i=0;i<3;i++) {
			j = (i+1) % 3;
			k = (i+2) % 3;
			a[i] = triangle[i][Y] - triangle[j][Y];
			b[i] = triangle[j][X] - triangle[i][X];
			c[i] = triangle[i][X] * triangle[j][Y] - triangle[j][X] * triangle[i][Y];
			sign[i] = a[i]*triangle[k][X]+b[i]*triangle[k][Y]+c[i];
		}
		
		for (int s : sign) {
			if(s == 0){
				return true;
			}
		}
		return false;
	}

}
