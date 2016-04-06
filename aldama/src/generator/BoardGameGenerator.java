package generator;

import java.util.Random;

public class BoardGameGenerator {

	public static void main(String[] args) {
		// 6 <= N <= 21;
		int N = 21;
		// 1 <= M <= 4;
		int M = 4;
		// 0 <= cost <= 2000, 0 < costMax < 2001;
		int costMax = 2001;
		
		Random rd = new Random();
		
		int size = (N-1)*4;
		
		while(size-- >0){
			System.out.printf("%d ",rd.nextInt(costMax));
		}
		System.out.println();
	}

}
