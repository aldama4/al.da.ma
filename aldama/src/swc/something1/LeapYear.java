package swc.something1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 현재 어떤 사람이 살고 있는 년도 B와 다른 어떤 사람이 태어난 년도 A가 주어질 때, 
 * 그 사이에 포함된 윤년의 수가 몇인지 알아보는 프로그램을 작성하라. 
 * 여기서 윤년이란 2월 29일이 있는 해를 말하며, 해당 년의 숫자가 4로 떨어지고 100으로 나눠떨어지지 않거나, 400으로 떨어지는 년을 뜻한다. 
 * 태어난 년도가 윤년일 경우에는 세지 않으며, 현재 년도가 윤년일 경우는 세어준다.
 * [입력]
 * 입력은 2개의 자연수 B와 A가 입력되며, A와 B는 1이상 1,000,000,000 이하의 숫자이며 B가 A보다 크다.
 * [출력]
 * 입력된 년 사이의 A+1년부터 B년 사이에 존재하는 윤년의 수를 출력한다.
 * 
 * @author KooKoo
 *
 */
public class LeapYear {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/something1_leapYear_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int B = sc.nextInt();
		int A = sc.nextInt();
		int count = 0;
		for(int y=A+1;y<B+1;){
			if((y%100!=0 && y%4==0) || y%400==0){
				count++;
				y+=4;
			}else{
				y++;
			}
		}
		System.out.println(count);
	}

}
