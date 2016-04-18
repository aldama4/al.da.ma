package swc.string;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * 스트링을 입력 한 후, 스트링을 구성하는 단어들 중, 현재 단어목록에 포함이 되어있지 않은 단어를 단어목록의 가장 뒤에 추가하는 프로그램을 작성하시오.
 * 
 * (1) 처음에는 단어의 목록이 하나도 없다. 
 * (2) 단어의 구분은 공백으로 한다. 
 * (3) 스트링은 계속 입력받으며, 프로그램이 종료되지 않는 이상 기존의 단어들의 목록은 계속 유지된다. 
 * (4) 목록에 단어가 없을 경우 단어를 목록의 가장 뒤에 추가하고, 있을경우 추가하지 않는다. 
 * (5) 단어목록에는 입력되는 순서대로 저장된다. 
 * (6) 알파벳 대.소문자는 구분된다(다르다).
 * [입력]
 * 입력되는 스트링의 최대 길이는 50이하이며, 스트링은 최대 10개 이하이다. 
 * 하나의 결과가 나온 후에도 계속 새로운 입력을 받다가, 스트링 값이 "END"이면 프로그램을 종료한다.
 * [출력]
 * 현재의 단어목록을 공백으로 구분하여 한줄에 한번씩 출력한다.
 * 
 * @author KooKoo
 *
 */
public class WordSet {

	public static void main(String[] args) throws Exception {
//		System.setIn(new FileInputStream("resources/jungol/string_wordSet_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		ArrayList<String> words = new ArrayList<String>();
		while(sc.hasNext()){
			String line = sc.nextLine();
			if("END".equals(line)){
				return;
			}
			String[] temp = line.split(" ");
			for (String str : temp) {
				if(!words.contains(str)){
					words.add(str);
				}
			}
			for (String str : words) {
				System.out.printf("%s ",str);
			}
			System.out.println();
		}

	}

}
