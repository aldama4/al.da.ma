package jungol.level1;

import java.io.FileInputStream;
import java.util.Scanner;

public class Rings_Jade_1{
	static int count = 0;
	static String key, bridge[];
	static boolean DEV = false, ANG = true;
	public static void main(String[] args) throws Exception{
		long start = System.currentTimeMillis();
		System.setIn(new FileInputStream("resources/jungol/level1_rings_input.txt"));
		Scanner sc = new Scanner(System.in);
		key = sc.next();
		bridge = new String[2]; 
		bridge[0] = sc.next();
		bridge[1] = sc.next();
		crossBridge(0, 0, DEV);
		crossBridge(0, 0, ANG);
		System.out.println(count);
		long end = System.currentTimeMillis();
		System.out.println(end - start);
	}
	private static void crossBridge(int bridgePos, int k, boolean sw) {
		int i = sw ? 1 : 0;
		if(k == key.length()){
			count++;
			return;
		}else if(bridgePos >= bridge[i].length()){
			return;
		}
		int idx = bridge[i].indexOf(key.charAt(k), bridgePos);
		if(idx == -1){
			return;
		}
		if(bridge[i].length() - idx+1 >= key.length() - k){
			crossBridge(idx+1, k, sw);
		}
			crossBridge(idx+1, k+1, !sw);
	}
}
