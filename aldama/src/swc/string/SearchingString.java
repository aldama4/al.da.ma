package swc.string;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 주어진 문자열에서 연속 3개의 문자가 IOI 이거나 KOI인 문자열이 각각 몇 개 있는지 찾는 프로그램을 작성하라. 
 * 문자열은 알파벳의 대문자로만 이루어진다. 
 * 예를 들어 "KOIOIOI"라는 문자열은 KOI 1개 , IOI 2개가 포함되어있다.
 * KOIOIOI
 * KOI IOI
 *   IOI
 * [입력]
 * 입력은 한 줄이며 10, 000자 이하의 알파벳 대문자로 구성된다.
 * [출력]
 * 출력은 2줄이며, 첫 번째 줄에는 KOI의 개수, 두 번째 줄에는 IOI의 개수를 각각 출력하라.
 * 
 * @author KooKoo
 *
 */
public class SearchingString {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_searchingString_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		String data = sc.next();
		int kCnt = 0;
		int iCnt = 0;
		int k=0, i=0;
		while((k=data.indexOf("KOI",k)+2) != 1){
			++kCnt;
		}
		while((i=data.indexOf("IOI",i)+2) != 1){
			++iCnt;
		}
		System.out.println(kCnt);
		System.out.println(iCnt);
	}

}
