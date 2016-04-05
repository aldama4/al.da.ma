package swc.problem;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class Bobin_20160326_2 {
	
	static List<Character> templist = null;
	static List<LinkedHashSet<Character>> wordlist = null;
	static HashMap<Character, Integer> map = null;
	static int count;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/20160326_2_input.txt"));
		Scanner scan = new Scanner(System.in);
		int TC = scan.nextInt();
		for (int i = 0; i < TC; i++) {
			long startTime = System.currentTimeMillis();
			count = 0;
			map = new HashMap<>();
			int words = scan.nextInt();
			wordlist = new LinkedList<>();
			for (int j = 0; j < words; j++) {
				String next = scan.next();
				templist = new ArrayList<>();
				for (int k = 0; k < next.length(); k++) {
					char c = next.charAt(k);
					if(c!='a'&&c!='e'&&c!='i'&&c!='u'&&c!='o'){
						templist.add(next.charAt(k));
					}
				}
				LinkedHashSet<Character> hashSet = new LinkedHashSet<>(templist);
				wordlist.add(hashSet);
				for (Character c1 : hashSet) {
					if(map.containsKey(c1)){
						Integer val = map.get(c1);
						val += 1;
						map.put(c1, val);
					}else{
						map.put(c1, 1);
					}
				}
				
			}
			minANDremove();
			 
			System.out.println("#"+TC+" "+count);
			long stopTime = System.currentTimeMillis();
			long runTime = stopTime - startTime;
			System.out.println("#"+TC+" runtime : "+runTime);
		}
		
	}
	
	private static void minANDremove() {
		int max = 0;
		char maxC = 0;
		for (Character c : map.keySet()) {
			if(map.get(c)>max){
				max=map.get(c);
				maxC=c;
			}
		}			
		if(max==1){
			count += wordlist.size();
			return;
		}
		
		count++;
		
		for (int j = 0; j < wordlist.size(); j++) {
			if(wordlist.get(j).contains(maxC)){
				for (Character c : wordlist.get(j)) {
					Integer val = map.get(c);
					val -= 1;
					map.put(c, val);
				}
				wordlist.remove(j);
				j--;
			}
			if(wordlist.size()==0){
				return;
			}
		}
		minANDremove();
	}
}