package swc.string;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 문자열을 입력 받고, 그 문자열 중 어떤 한 문자라도 발생빈도가 소수를 만족하면 이는 소수문자열이라고 한다.
 * 
 * 예를 들어 AABAAB는 소수문자열이다. A의 경우 4번 나타나며, B의 경우 2번 나타나기 때문에 이문자열은 소수문자열인 것이다.
 * [입력]
 * 10,000 이하의 문자열이 입력된다. 문자열은 알파벳 대문자만 구성된다.
 * [출력] 
 * 입력에 대해서 해당 문자열이 소수문자열이 아닌 경우 "NONE"을 출력하며 
 * 소수문자열일 경우 소수문자열을 이루게 만들어주는 문자를 사전순으로 한 줄에 공백없이 출력한다.
 * 
 * @author KooKoo
 *
 */
public class PrimeString {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_primeString_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int[] alpha = new int[26];
		int MAX = 10000;
		boolean[] checker = new boolean[MAX+1];
		char[] str = sc.next().toCharArray();
		for (char c : str) {
			alpha[(int)(c-'A')]++;
		}
		for(int i=2;i<Math.sqrt(MAX)+1;i++){
			if(!checker[i]){
				for(int j=2;i*j<MAX+1;j++){
					checker[i*j] = true;
				}
			}
		}
		char[] data = new char[26];
		int idx = 0;
		for(int i=0;i<26;i++){
			if(alpha[i] > 1 && !checker[alpha[i]]){
				data[idx++] = (char)('A'+i);
			}
		}
		System.out.println(idx==0?"NONE".toCharArray():data);
	}

}
