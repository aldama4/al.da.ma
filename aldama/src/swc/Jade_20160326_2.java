package swc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class Jade_20160326_2 {
	static int T, N;
	static int INF = 201;
	static ArrayList<Character> filteredList;
	static HashSet<Character> charSet = new HashSet<Character>();
	static String[] W = new String[200];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/20160326_2_input.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int answer;
		ArrayList<Character> selectedChar;
		for(int tc=1;tc<=T;tc++){
			long start = System.currentTimeMillis();
			charSet.clear();
			filteredList = new ArrayList<Character>();
			selectedChar = new ArrayList<Character>();
			N = sc.nextInt();
			for(int i=0;i<N;i++){
				W[i] = sc.next();
				setChar(W[i]);
			}
			Iterator<Character> itr = charSet.iterator();
			while(itr.hasNext()) filteredList.add((char)itr.next());
			
			answer = selectChar(selectedChar, 0);
			System.out.println("#"+tc+" "+answer);
			long end = System.currentTimeMillis();
			System.out.println(end-start);
		}
	}
	private static int selectChar(ArrayList<Character> selectedChar, int idx) {
		int ret;
		int temp;
		if(idx == filteredList.size()){
			if(canColorEveryWords(selectedChar)){
				return selectedChar.size();
			}
			return INF;
		}
		
		ret = selectChar(selectedChar, idx+1);
		selectedChar.add(filteredList.get(idx));
		temp = selectChar(selectedChar, idx+1);
		ret = ret > temp?temp:ret;
		selectedChar.remove(filteredList.get(idx));
		return ret;
	}
	private static boolean canColorEveryWords(ArrayList<Character> selectedChar) {
		boolean[] checker = new boolean[N];
		for (Character character : selectedChar) {
			for(int i=0;i<N;i++){
				if(W[i].indexOf(String.valueOf(character)) != -1){
					checker[i] = true;
				}
			}
		}
		for (boolean b : checker) {
			if(!b){
				return false;
			}
		}
		return true;
	}
	private static void setChar(String word) {
		char c;
		for(int j=0;j<word.length();j++){
			c = word.charAt(j);
			if(c !='a' && c != 'e' && c!= 'i' && c != 'o' && c != 'u')
				charSet.add(c);
		}
	}

	
}
