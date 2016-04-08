package jungol.dataProcess;

import java.io.FileInputStream;
import java.util.Scanner;

/**
 * 큐는 먼저 들어온 데이터가 먼저 출력된다. 이러한 구조를 선입선출(FIFO - First In First Out)이라고 한다. 
 * 이러한 큐 자료구조는 보통 우리의 생활에서는 매우 일상적인 자료구조이다. 
 * 큐 자료구조의 형태를 가장 흔히 볼 수 있는 게 “줄서기”가 될 것이다.
 * 은행 창구에서 줄을 서거나, 버스를 기다리기 위해서 줄을 설 경우 가장 먼저 줄을 선 사람이 가장 먼저 은행 업무를 처리하거나, 
 * 버스를 타게 된다.(새치기 하는 경우는 생각하지 말자) 그림과 같은 큐 자료구조를 설계하고, 처리조건에 맞는 출력을 하시오.
 * 
 * ≪처리조건≫
 *  1. 주어지는 명령은 다음의 3가지이다. 
 *  2. "i a"는 a라는 수를 큐에 넣는다. 이때, a는 10,000 이하의 자연수이다. 
 *  3. "o"는 큐에서 데이터를 빼고, 그 데이터를 출력한다. 만약 큐가 비어있으면, "empty"를 출력한다. 
 *  4. "c"는 큐에 있는 데이터의 수를 출력한다.
 * [입력]
 * 첫줄에 N이 주어진다. N은 주어지는 명령어의 수이다.(1≤N≤100)
 * 둘째 줄부터 N+1줄까지 한 줄에 하나씩 명령이 주어진다.
 * [출력] 
 * 각 명령에 대한 출력 값을 한 줄에 하나씩 출력한다. 출력내용이 하나도 없는 경우는 주어지지 않는다.
 * 
 * @author KooKoo
 *
 */
public class Queue {

	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/dataProcess_queue_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] queue = new int[N];
		int first = -1;
		int last = -1;
		String cmd,temp;
		for(int n=0;n<N;n++){
			cmd = sc.next();
			if("i".equals(cmd)){
//			 *  1. "i a"는 a라는 수를 큐에 넣는다. 이때, a는 10,000 이하의 자연수이다.
				queue[++last] = sc.nextInt();
			}else if("o".equals(cmd)){
//			 *  2. "o"는 큐에서 데이터를 빼고, 그 데이터를 출력한다. 만약 큐가 비어있으면, "empty"를 출력한다.
				if(last-first == 0){
					temp = "empty";
				}else{
					temp = ""+queue[++first];
				}
				System.out.println(temp);
			}else if("c".equals(cmd)){
//			 *  3. "c"는 큐에 있는 데이터의 수를 출력한다.
				System.out.println(last-first);
			}
		}
	}

}
