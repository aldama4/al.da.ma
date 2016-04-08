package jungol.dataProcess;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * Stack은 "더미"란 뜻을 가진다. 
 * 책 더미, 신문 더미 등에 사용하는 단어이다. 책 더미를 예로 들어 보자. 
 * 책 더미를 쌓았다고 했을 때, 이 책 더미에서 책을 가져오는 가장 정상적인 방법은 제일 위에 있는 책을 가져오는 방식이다. 
 * 다시 말하면 가장 먼저 들어간 책은 가장 나중에 꺼낼 수 있을 것이다. 
 * 이런식으로 자료가 사장 밑에 쌓이고(입력). 자료를 가져올 때(출력)는 가장 위(최근)의 자료를 가져오는 자료구조를 Stack하고 한다. 
 * 이러한 Stack의 특징 때문에 흔히 "FILO(First-In-Last-Out : 선입후출)" 혹은 "LIFO(Last-In-First-Out : 후입선출)"라고 한다. 
 * 다음의 처리조건에 맞는 출력을 하시오.
 * 
 * <처리조건> 
 * 주어진 명령은 다음의 3가지이다. 
 * 1. "i a"는 a라는 수를 스택에 넣는다. 이때, a는 10,000 이하의 자연수이다.
 * 2. "o"는 스택에서 데이터를 빼고, 그 데이터를 출력한다. 만약 스택이 비어있으면, "empty"를 출력한다. 
 * 3. "c"는 스택에 쌓여있는 데이터의 수를 출력한다.
 * [입력]
 * 첫 줄에 N이 주어진다. N은 주어지는 명령의 수이다. (1≤N≤100)
 * 둘째 줄부터 N+1줄까지 N개의 명령이 주어지는데, 한 줄에 하나씩 주어진다.
 * [출력] 
 * 각 명령에 대한 출력 값을 한 줄에 하나씩 출력한다. 출력내용이 하나도 없는 경우는 주어지지 않는다.
 * 
 * @author KooKoo
 *
 */
public class Stack {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/dataProcess_stack_input.txt"));
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] stack = new int[10000];
		int idx = -1;
		String cmd, temp;
		for(int n=0;n<N;n++){
			cmd = sc.next();
			if("i".equals(cmd)){
//				 * 1. "i a"는 a라는 수를 스택에 넣는다. 이때, a는 10,000 이하의 자연수이다.
				stack[++idx] = sc.nextInt();
			}else if("o".equals(cmd)){
//				 * 2. "o"는 스택에서 데이터를 빼고, 그 데이터를 출력한다. 만약 스택이 비어있으면, "empty"를 출력한다.
				if(idx == -1){
					temp = "empty";
				}else{
					temp = ""+stack[idx];
					stack[idx--] = 0;
				}
				System.out.println(temp);
			}else if("c".equals(cmd)){
//				 * 3. "c"는 스택에 쌓여있는 데이터의 수를 출력한다.
				System.out.println(idx+1);
			}
		}
	}
}
