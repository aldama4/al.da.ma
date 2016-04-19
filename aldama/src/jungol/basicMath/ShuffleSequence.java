package jungol.basicMath;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Scanner;

/**
 * A1, A2, …, AN으로 표시된 N 개의 카드를 정해진 방법으로 섞고자 한다. 
 * 그 섞는 방법은 1에서 N까지의 숫자로 이루어진 수열로 표시된다. 
 * 이 수열을 섞기 수열이라 하자. 
 * 섞기는 현재 가지고 있는카드에서 섞기 수열의 각 숫자가 나타내는 위치에 있는 카드를 순서대로 뽑아서나열하는 것이다.
 * [A1, A2, A3, A4, A5, A6]
 * 예를 들어, N = 6이고 섞기 수열이 [3, 2, 5, 6, 1, 4]라고 하자.
 * 카드의 처음 상태가 [A1, A2, A3, A4, A5, A6]일 때, 섞기를 한 번 실행하면 카드의 순서가 다음과 같이 된다.
 * [A3, A2, A5, A6, A1, A4]
 * 이 상태에서 다시 한 번 섞기를 실행하면 카드의 순서가 [A5, A2, A1, A4, A3, A6]이 되고, 
 * 다시 한 번 더 섞기를 실행하면 카드의 순서가 [A1, A2, A3, A6, A5, A4]가 된다. 
 * 이렇게 섞기를 반복하면 카드의 순서가 처음 상태인 [A1, A2, A3, A4, A5, A6]이 된다. 
 * 처음 상태로 돌아 올 때까지 반복한 섞기의 최소 횟수를 주어진 섞기 수열의 궤적이라 한다.
 * 임의의 섞기 수열이 주어졌을 때, 그 섞기 수열의 궤적을 구하는 프로그램을 작성하시오.
 * [입력]
 * 첫 번째 줄에 카드의 수 N이 주어진다. N은 1 이상 20,000 이하의 수이다. 
 * 두 번째 줄에 섞기 수열을 나타내는 N 개의 자연수가 빈칸을 사이에 두고 주어진다.
 * [출력]
 * 첫 번째 줄에 입력으로 주어진 섞기 수열의 궤적을 출력한다. 
 * 단, 궤적이 1 이상 2,000,000,000 이하인 입력만 주어진다.
 * 
 * @author KooKoo
 *
 */
public class ShuffleSequence {
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/jungol/basicMath_shuffleSequence_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int N = sc.nextInt();
		int[] data = new int[N];
		int[] seq = new int[N];
		boolean[] checker = new boolean[N];
		for(int i=0;i<N;i++){
			data[i] = sc.nextInt();		
		}
		int cnt = 0, idx=0, i=0, sIndex=0;
		while(isNotCompleted(checker)){
			if(checker[idx]){
				idx = ++i;
				continue;
			}
			cnt++;
			checker[idx] = true;
			idx = data[idx]-1;
			if(idx == i){
				seq[sIndex++] = cnt;
				idx = ++i;
				cnt = 0;
			}
		}
		Arrays.sort(seq, 0, sIndex);
		int max = seq[sIndex-1];
		loop : for(int n=1;;n++){
			for(i=0;i<sIndex;i++){
				if((n*max)%seq[i]!=0){
					continue loop;
				}
			}
			System.out.println(n*max);
			return;
		}
	}

	private static boolean isNotCompleted(boolean[] checker) {
		for (boolean b : checker) {
			if(!b){
				return true;
			}
		}
		return false;
	}
}
