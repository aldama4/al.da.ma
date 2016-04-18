package swc.string;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 자물쇠 사용자의 핸드폰 번호를 가지고 보다 기억하기 편하게 이를 암호로 만들려고 한다. 
 * 즉 자물쇠를 사면 처음에 숫자 두 개를 입력하는데 첫 번째 숫자는 각 자리에 더해질 숫자이고, 
 * 두 번째 숫자는 몇 번째 숫자 더미를 가지고 암호를 만들 것인가를 결정하는 것이다. 
 * 해당 더미 숫자에 각각 더해질 숫자를 더하면 이것이 암호가 된다. 
 * 자물쇠의 비밀번호를 만들어 내는 프로그램을 작성하라.
 * 
 * < 처리조건 > 
 * (1) 핸드폰 번호, 각 자리에 더해질 숫자, 숫자 더미의 위치를 입력받는다. 
 * (2) 입력된 핸드폰 번호에서, 각 숫자 더미사이의 구분은 하이픈(-)으로 하고, 번호는 0이상 9이하의 자연수만 들어온다. 
 * (3) 숫자 더미는 앞에서부터 자동적으로 1번부터 매겨지며, 그 수의 제한은 없다. 
 *     즉 반드시 abc-defg-hijk 형태의 3개의 숫자더미를 가지는 전화번호만이 있는 것은 아니다.
 * (4) 원하는 숫자더미에서 각 자리의 숫자를 더한다. 이때 더한 값이 9를 넘을 경우에는 그 중 일의 자리 값만을 취한다. 
 * (5) 각 숫자더미는 4자리를 넘어서는 안된다. 
 * (6) 각 숫자 더미의 크기가 4자리가 안될 경우에는 전체를 4자리로 한 후, 앞에 그 비는 자리 수만큼 0을 붙인다.
 * [입력]
 * 전화번호를 기억할 스트링과(s, s는 100자 이내의 스트링), 각 자리에 더해질 숫자(p, p는 1부터 9까지의 수), 
 * 숫자 더미의 번호(m)를 공백문자로 구분하여 입력받는다.
 * [출력]
 * 위의 입력된 전화번호 중에서의 원하는 더미에, 원하는 숫자가 더해진 후의 값을 출력한다. 
 * 처리조건에 맞지 않는 경우는 "INPUT ERROR!"를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class PasswordInPhoneNumber {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/string_passwordInPhoneNumber_input.txt"));
		Scanner sc = new Scanner(System.in);
		String numberStr = sc.next();
		String[] number = numberStr.split("-", numberStr.codePointCount(0, numberStr.length()));

		
		for (String str : number) {
			if(str.length() > 4){
				System.out.println("INPUT ERROR!");
				return;
			}
		}
		int N = sc.nextInt();
		int M = sc.nextInt();
		
		if(M > number.length){
			System.out.println("INPUT ERROR!");
			return;
		}
		String num = String.format("%04d", "".equals(number[M-1])?0:Integer.valueOf(number[M-1]));
		char[] answer = new char[4];
		for(int i=0;i<4;i++){
			answer[i] = (char)(((int)(num.charAt(i)-48) + N)%10+48);
		}
		System.out.println(answer);
		
	}

}
