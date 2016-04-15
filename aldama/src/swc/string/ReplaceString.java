package swc.string;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 현석이가 책을 발간하기 위해서 원고를 작성하여 출판사에 보냈다. 
 * 며칠 후 출판사에서 택배로 초안을 보내왔다. 현석이는 초안을 읽어보다가 오타를 발견하였다. 
 * 그런데 오타가 한글자만 있는 것이 아니어서 수정해야하는 문자를 기록하여 다시 출판사로 보내주었다. 
 * 여기서 문자란 숫자를 포함하며, 대소문자를 구별한다. 즉, 대문자와 소문자는 다른 문자이다. 
 * 당신이 할 일은 현석이가 보내온 정보를 가지고 제대로 수정된 문장을 출력하는 것이다.
 * [입력]
 * 입력의 첫줄에는 수정해야하는 정보의 개수 n(n≤50)이 들어온다. 
 * 그 다음 줄부터 n개의 줄에 각각 2개씩의 문자가 들어오는데 이것은 첫 번째 문자를 두 번째 문자로 바꾸라는 것이다.
 * 그다음 오타가 포함되어있는 문장의 문자개수 m(1≤m≤100,000)이 들어오고 그 다음부터 m개의 문자가 들어온다.
 * [출력] 
 * 출력은 m개의 문자를 수정하여 한 줄에 공백 없이 출력한다.
 * 
 * @author KooKoo
 *
 */
public class ReplaceString {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_replaceString_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] data = new char[65536];
		for(int i=0;i<N;i++){
			data[(int)sc.next().charAt(0)] = sc.next().charAt(0);
		}
		int M = sc.nextInt();
		String str = "";
		for(int i=0;i<M;i++){
			char temp = sc.next().charAt(0);
			if(data[temp] != 0){
				temp = data[temp];
			}
			System.out.printf("%c",temp);
		}
		System.out.println();
	}
}
