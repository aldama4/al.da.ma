package swc.string;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 병현이는 지은이에게 문자 A, B, C, D, E, F, G, H 로 쓰여진 편지를 날마다 보내는데, 
 * 컴퓨터로 보내는 비밀편지로, 한 문자마다 0 또는 1인 숫자 여섯 개를 사용하여 보낸다. 둘 사이의 약속은 다음과 같다.
 * 
 * A 000000 
 * B 001111 
 * C 010011 
 * D 011100 
 * E 100110 
 * F 101001 
 * G 110101 
 * H 111010
 * 
 * 병현이가 어느 날 001111000000011100 을 보내면 지은이는 이것을 BAD로 이해하게 된다. 
 * 그런데 둘 사이에 약속이 잘 만들어져 있기 때문에, 통신에 문제가 생겨서 한 문자를 표시하는 여섯 숫자 중 어느 한 숫자만 틀리게 오는 경우, 
 * 지은이는 원래 보내려는 문자를 알아 낼 수가 있다.
 * 
 * 예를 들어 지은이가 000100을 받았을 때, a와 숫자 한자만 다르고, 다른 문자들과는 각각 숫자 두 자 이상이 다르므로 지은이는 이것이 A라고 알아보게 된다. 
 * 다만 111111과 같이 모든 문자의 표현과 숫자 두 자 이상이 다른 경우에는 무슨 문자인지 알 수가 없게 된다.
 * 예를 들어 지은이가 011111000000111111000000111111 을 받았을 때, BA 다음에 알아 볼 수 없는 문자가 나오는데.
 * 이 경우 이런 것이 처음 나오는 문자의 위치인 3을 출력한다.
 * 
 * 지은이가 받은 편지를 보고 문자들을 알아내어 출력하거나, 
 * 모르는 문자가 있는 경우, 이것이 처음 나오는 위치를 출력하는 프로그램을 작성하시오.
 * [입력]
 * 첫줄에는 보낸 문자의 개수(10개 보다 작다.)가 입력된다. 다음 줄에는 문자의 개수의 여섯 배 만큼의 숫자 입력이 주어진다.
 * [출력]
 * 주어진 입력에서 지은이가 이해한 문자들을 출력하거나 모르는 문자가 나오는 경우 그런 것이 처음 나오는 위치를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class SecretLetter {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_secretLetter_input.txt"));
		Scanner sc = new Scanner(System.in);
		boolean O = false, L = true;

		boolean[][] decoder = {{O,O,O,O,O,O},//		 * A 000000
							   {O,O,L,L,L,L},//		 * B 001111
							   {O,L,O,O,L,L},//		 * C 010011 
							   {O,L,L,L,O,O},//		 * D 011100 
							   {L,O,O,L,L,O},//		 * E 100110 
							   {L,O,L,O,O,L},//		 * F 101001 
							   {L,L,O,L,O,L},//		 * G 110101 
							   {L,L,L,O,L,O}};//		 * H 111010
		int N = sc.nextInt();
		char[] str = sc.next().toCharArray();
		boolean[][] ps = new boolean[N][6];
		char[] letter = new char[N];
		for(int i=0,idx=0;i<N;i++){
			for(int j=0;j<6;j++){
				ps[i][j] = str[idx++] == '1'? L : O;
			}
			for(int k=0;k<8;k++){
				int cnt = 0;
				for (int p=0;p<6;p++) {
					if(decoder[k][p] == ps[i][p]){
						cnt++;
					}
				}
				if(cnt > 4){
					letter[i] = (char)('A'+k);
					break;
				}else if(k==7){
					System.out.println(i+1);
					return;
				}
			}
		}
		System.out.println(letter);
	}

}
