package generator;

import java.io.PrintStream;
import java.util.Random;

public class RandomInt {
	public static void main(String[] args) throws Exception{
		System.setOut(new PrintStream("resources/generator/randomInt.txt"));
		Random rand = new Random();
		int n = 20000;
		while(n-- > 0){
			System.out.println(rand.nextInt(10001));
		}
	}
}
