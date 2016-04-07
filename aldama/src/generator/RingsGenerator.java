package generator;

import java.io.PrintStream;
import java.util.Random;

public class RingsGenerator {

	public static void main(String[] args) throws Exception{
		Random rand = new Random();
		int N = 20;
		int M = 100;
		String[] word = {"R", "I", "N", "G", "S"};
		int wordlength = 5;
		String key = "";
		String[] bridge = new String[2];
		bridge[0] = "";
		bridge[1] = "";
		for(int n=0;n<N;n++){
			key += word[rand.nextInt(5)];
		}
		
		for(int m=0;m<M;m++){
			bridge[0] += word[rand.nextInt(5)];
			bridge[1] += word[rand.nextInt(5)];
		}
		
		
		System.out.println(key);
		System.out.println(bridge[0]);
		System.out.println(bridge[1]);
	}

}
