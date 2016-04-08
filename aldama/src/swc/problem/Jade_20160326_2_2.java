package swc.problem;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class Jade_20160326_2_2 {
	static int min, N, counter[] = new int[26];
	static char[][] words = new char[200][];
	static Character[] key;
	static boolean[] alphabet = new boolean[26];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/20160326_2_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int kl;
		for(int tc=1;tc<=T;tc++){
			long start = System.currentTimeMillis();
			min = Integer.MAX_VALUE;
			N = sc.nextInt();
			for(int i=0;i<26;i++){
				counter[i] = 0;
				alphabet[i] = false;
			}
			kl = 0;
			int	temp;
			String str;
			for(int n=0;n<N;n++){
				// 들어오는 글자에서부터 a,e,o.i,u 와 중복되는 것을 제거한다? 일단 모음 5개 제거는 가능
				words[n] = sc.next().replaceAll("[a,e,o,u,i]", "").toCharArray();
				for(int w=0;w<words[n].length;w++){
					temp = words[n][w] - 'a';
					if(!alphabet[temp]){
						alphabet[temp] = true;
						kl++;
					}
				}
			}
			
			key = new Character[kl];
			for(int a=0,i=0;a<26;a++){
				if(alphabet[a]){
					key[i++] = (char)(97+a);
				}
			}
			
			searchLowestCount(0, 0, new boolean[N]);
			System.out.println(min);
			long end = System.currentTimeMillis();
			System.out.println(end-start+"(ms)");
			
		}
	}
	private static void searchLowestCount(int idx, int cnt, boolean[] checker) {
		if(min < cnt){
			return;
		}else if(idx >= key.length){
			if(isComplete(checker)){
				min = min > cnt? cnt : min;
			}
			return;
		}
		
		boolean[] temp = checker.clone();
		for(int n=0;n<N;n++){
			if(!checker[n]){
				for(int i=0;i<words[n].length;i++){
					if(key[idx] == words[n][i]){
						checker[n] = true;
						break;
					}
				}
			}
		}
		searchLowestCount(idx+1, cnt, temp);
		searchLowestCount(idx+1, cnt+1, checker);
	}
	private static boolean isComplete(boolean[] checker) {
		for (boolean b : checker) {
			if(!b){
				return false;
			}
		}
		return true;
	}
}
