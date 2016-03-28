package swc;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;

public class 글자색바꾸기 {
	static int T, N;
	static int INF = 201;
	static ArrayList<Character> filteredList;
	static HashSet<Character> charSet = new HashSet<Character>();
	static String[] W = new String[200];
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/글자색바꾸기입력.txt"));
		
		Scanner sc = new Scanner(System.in);
		
		T = sc.nextInt();
		int answer;
		ArrayList<Character> selectedChar;
		for(int tc=1;tc<=T;tc++){
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
		}
	}
	private static int selectChar(ArrayList<Character> selectedChar, int idx) {
		int ret;
		if(idx == filteredList.size()){
			if(canColorEveryWords(selectedChar)){
				return selectedChar.size();
			}
			return INF;
		}
		
		ret = selectChar(selectedChar, idx+1);
		selectedChar.add(filteredList.get(idx));
		ret = Math.min(ret, selectChar(selectedChar, idx+1));
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
		HashSet<Character> temp = new HashSet<Character>();
		char c;
	
		for(int j=0;j<word.length();j++){
			c = word.charAt(j);
			if(c !='a' && c != 'e' && c!= 'i' && c != 'o' && c != 'u')
				charSet.add(c);
		}
	}

	
}
