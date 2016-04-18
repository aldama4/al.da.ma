package swc.string;

import java.io.FileInputStream;
import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeMap;

/**
 * 임의의 문장을 입력받아 각 단어별로 나눈 후에 단어들의 중복되는 개수를 구하는 프로그램을 작성하시오. 
 * <처리조건> 
 * (1) 입력된 스트링은 글자의 제한은 없다. 즉 공백이나 ', ' 등도 입력으로 들어 올 수 있다. 
 * (2) 입력된 문장에서 각 단어사이의 구분은 공백으로 한다.
 * (3) 단어에는 공백을 제외한 단어들만이 포함된다.
 * [입력]
 * 임의의 문장을 입력받는다.(문장의 길이는 200 이하)
 * [출력]
 * 하나의 결과가 나온 후에도 계속 새로운 입력을 받다가, "END"가 입력되면 프로그램을 종료하다.
 * 
 * @author KooKoo
 *
 */
public class CountWords {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_countWords_input.txt"));
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			String line = sc.nextLine().replaceAll("[//,]", "");
			if("END".equals(line)){
				return;
			}
			String[] words = line.split(" ");
			TreeMap<String, Integer> counter = new TreeMap<String, Integer>();
			for (String str : words) {
				if(counter.containsKey(str)){
					counter.put(str, counter.get(str)+1);
				}else{
					counter.put(str, 1);
				}
			}
			Iterator<String> itr = counter.keySet().iterator();
			while(itr.hasNext()){
				String key = String.valueOf(itr.next());
				System.out.printf("%s : %d",key,counter.get(key));
				System.out.println();
			}
		}
	}

}
