package jungol.level1;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 원하는 년 월 일을 입력받아 해당 년 월의 달력과 해당일의 요일을 출력하는 프로그램을 작성하시오. 
 * ※ 윤년과 평년을 구별하는 방법은 다음과 같다. 
 * 1) 400의 배수는 모두 윤년이다. 
 * 2) 4의 배수이며 100의 배수가 아니면 윤년이다. 
 * 3) 나머지는 모두 평년이다. 
 * ※ 요일은 영어로 아래와 같다. 
 * 일요일 Sunday 월요일 Monday 화요일 Tuesday 수요일 Wednesday 목요일 Thursday 금요일 Friday 토요일 Saturday
 * [입력]
 * 해당하는 년 y(y 는 2,000 이상 2,010 이하의 정수) 월 m( m은 1부터 12사이의 정수) 일 d( d는 해당 월 사이의 수)을 공백으로 구분하여 입력받는다.
 * 하나의 결과가 출력되면 프로그램을 종료한다.
 * 데이터의 크기가 주어진 범위를 벗어날 경우는 "INPUT ERROR!"를 출력하고 다시 입력받는다.
 * [출력]
 * 해당 년 월의 달력을 출력하고 해당 날짜의 요일을 출력한다.
 * 달력의 가장 왼쪽은 일요일이다.
 * 요일은 공백으로 구분하여 출력한다.
 * 날짜는 아래 출력 예와 같이 자리수를 맞추어 출력해야 한다.(요일과 요일사이 공백 날짜는 요일의 마지막글자에 맞춘다.)
 * 날짜를 계산할 때에는 윤년도 고려하여야 한다.
 * 2000년 1월 1일은 토요일이다.
 * 
 * @author KooKoo
 *
 */
public class Calendar {
	static int[] dpm = {0,31, 28, 31, 30, 31,30,31,31,30,31,30,31}; 
	static String[] days = {"Sunday", "Monday", "Tuesday", "Wednesday", "Thursday", "Friday", "Saturday"};
	static int[][] calendar = new int[6][7];
	static final int BEGIN_DAY = 5;  
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/level1_calendar_input.txt"));
		Scanner sc = new Scanner(System.in);
		int year, month, day;
		do{
			year = sc.nextInt();
			month = sc.nextInt();
			day = sc.nextInt();
		}while(isInputError(year,month,day));
		
		printCalendar(year,month,day);
	}
	private static void printCalendar(int year, int month, int day) {
		int week,dayz,temp = BEGIN_DAY;
		for(int y=2000;y<year;y++){
			setLeapYear(y);
			for(int m=1;m<=12;m++){
				temp += dpm[m];
			}
		}
		setLeapYear(year);
		for(int m=1;m<month;m++){
			temp += dpm[m];
		}
		week = 0;
		for(int d=1;d<=dpm[month];d++){	
			dayz = (temp+d)%7;
			calendar[week][dayz] = d;
			if(dayz == 6){ week ++; }
		}
		day += temp;
		System.out.printf("%d. %d",year,month);
		System.out.println();
		System.out.println("sun mon tue wed thu fri sat");
		loop : for (int[] w : calendar) {
			for (int d : w) {
				if(d != 0){
				System.out.printf("%3d ",d);
				}else{
					System.out.printf("    ");
				}
				if(d == dpm[month]){
					System.out.println();
					break loop;
				}
			}
			System.out.println();
		}
		System.out.println(days[day%7]);
		
	}
	private static boolean isInputError(int year, int month, int day) {
		if(year < 2000 || year > 2010){
			System.out.println("INPUT ERROR!");
			return true;
		}else if(month < 1 || month > 12){
			System.out.println("INPUT ERROR!");
			return true;
		}
		setLeapYear(year);
		if(day < 1 || day > dpm[month]){
			System.out.println("INPUT ERROR!");
			return true;
		}
		return false;
	}
	private static void setLeapYear(int year) {
		int temp = year;
		if(temp%400 == 0 || (temp%4==0 && temp%100!=0)){
			dpm[2] = 29;
		}else{
			dpm[2] = 28;
		}
	}

}
