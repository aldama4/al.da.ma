package swc;

import java.io.FileInputStream;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Stack;

public class Jade_20160326_2_DP {
	static int T, N;
	static char[] filteredList;
	static boolean[][] checker;
	static boolean[] includedAlphabet;
	static String[] W = new String[200];
	static int index, min, INF = 22;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/20160326_2_input.txt"));
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for(int tc=1;tc<=T;tc++){
			Stack<Character> selectedChar = new Stack<Character>();
			includedAlphabet = new boolean[26];
			filteredList = new char[21];
			index = 0;
			min = 22;
			long start = System.currentTimeMillis();
			N = sc.nextInt();
			checker = new boolean[N][26];
			for(int i=0;i<N;i++){
				W[i] = sc.next().replaceAll("[aeoui]","");
				setChar(W[i],i);
			}
			setFilteredList();
			int answer = selectChar(selectedChar, 0);
			System.out.println("#"+tc+" "+answer);
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		}
	}
	private static void setFilteredList() {
		for(int i=0;i<26;i++){
			if(includedAlphabet[i]){
				filteredList[index] = (char)('a'+i);
				index++;
			}
		}
		
	}
	private static int selectChar(Stack<Character> selectedChar, int idx) {
		int ret1, ret2;
		if(min != 0 && selectedChar.size() > min) return INF;
		else if(idx == index){
			if(canColorEveryWords(selectedChar)){
				return selectedChar.size();
			}
			return INF;
		}
		
		ret1 = selectChar(selectedChar, idx+1);
		min = min > ret1? ret1 : min;
		selectedChar.push(filteredList[idx]);
		ret2 = selectChar(selectedChar, idx+1);
		min = min > ret2? ret2 : min;
		selectedChar.pop();
		return min;
	}
	private static boolean canColorEveryWords(Stack<Character> selectedChar) {
		boolean[] temp = new boolean[N];
		for (Character character : selectedChar) {
			for(int i=0;i<N;i++){
				if(checker[i][character-'a']){
					temp[i] = true;
				}
			}
		}
		for (boolean b : temp) {
			if(!b){
				return false;
			}
		}
		return true;
	}
	private static void setChar(String word, int idx) {
		char c;
		for(int j=0;j<word.length();j++){
			c = word.charAt(j);
			includedAlphabet[c-'a'] = true;
			checker[idx][c-'a'] = true;
		}
	}

	
}
