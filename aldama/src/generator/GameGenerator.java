package generator;

import java.io.PrintStream;
import java.util.Random;

public class GameGenerator {

	public static void main(String[] args) throws Exception{
		System.setOut(new PrintStream("resources/generator/Game.txt"));
		generator(500, 499);
	}

	private static void generator(int N, int K) {
		System.out.println(N + " " + K);
		Random rd = new Random();
		int i = 0;
		for(int n = 0; n < N; n++){
			for(int k = 0; k < K; k++){
				if(i == k){
					System.out.print(0+" ");
				}else{
					System.out.print(rd.nextInt(60)+" ");
				}
			}
			i++;
			System.out.println();
		}
	}

}
