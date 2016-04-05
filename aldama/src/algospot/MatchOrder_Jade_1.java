package algospot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

/**
 * 전세계 최대의 프로그래밍 대회 알고스팟 컵의 결승전이 이틀 앞으로 다가왔습니다. 
 * 각 팀은 n명씩의 프로 코더들로 구성되어 있으며, 결승전에서는 각 선수가 한 번씩 출전해 1:1 경기를 벌여 
 * 더 많은 승리를 가져가는 팀이 최종적으로 우승하게 됩니다. 
 * 각 팀의 감독은 대회 전날, 주최측에 각 선수를 출전시킬 순서를 알려 주어야 합니다.
 * 결승전 이틀 전, 한국팀의 유감독은 첩보를 통해 상대 러시아팀의 출전 순서를 알아냈습니다. 
 * 이 대회에서는 각 선수의 실력을 레이팅(rating)으로 표현합니다. 
 * 문제를 간단히 하기 위해 1:1 승부에서는 항상 레이팅이 더 높은 선수가 승리하고, 레이팅이 같을
 * 경우 우리 선수가 승리한다고 가정합시다.
 * 경기        1     2     3     4     5     6 
 * 러시아팀 3,000 2,700 2,800 2,200 2,500 1,900 
 * 한국팀   2,800 2,750 2,995 1,800 2,600 2,000 
 * 표와 같이 출전 순서를 정했다고 하면 한국팀은 2번, 3번, 5번, 6번 경기에서 승리해 전체 네 경기를 이기게 됩니다. 
 * 그러나 대신 4번 경기와 1번 경기에 나갈 선수를 바꾸면 1번 경기만을 제외하고 모든 경기에 승리할 수 있지요. 
 * 상대방 팀 선수들의 순서를 알고 있을 때, 어느 순서대로 선수들을 내보내야 승수를 최대화할 수 있을까요?
 * ####입력####
 * 입력의 첫 줄에는 테스트 케이스의 수 C (C≤50)가 주어집니다. 
 * 각 테스트 케이스의 첫 줄에는 각 팀 선수의 수 N(1≤N≤100)가 주어집니다. 
 * 그 다음 줄에는 N개의 정수로 러시아팀 각 선수의 레이팅이 출전 순서대로 주어지며, 
 * 그 다음 줄에는 N개의 정수로 한국팀 각 선수의 레이팅이 무순으로 주어집니다. 
 * 모든 레이팅은 1 이상 4000 이하의 정수입니다.
 * ####출력####
 * 각 테스트 케이스마다 한 줄에 한국팀이 얻을 수 있는 최대 승수를 출력합니다.
 * 
 * @author KooKoo
 *
 */
public class MatchOrder_Jade_1 {
	//다승을 위해선? 레이팅이 같거나 적보다 조금 높은 수준으로 상대.
	//1.적과 나를 오름차순한다.
	//2.제일 낮은 적(첫번째 적)과 같거나 가장 적은 차로 높은 아군을 선택
	//2-1.제일 낮은 아군(첫번째 아군)부터 비교하면서 선택하면 됨. ( 선택 -> 승 + 1 )
	//3.다음 적도 2번처럼 반복.
	//4.남은 아군에서 이길 수 있는 선택지가 없을 때에는 그냥 종료.
	
	static int N;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/algospot/MatchOrder_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		int cnt,index;
		while(T-- > 0){
			N = sc.nextInt();
			Team rus = new Team();
			Team kor = new Team();
			for(int r=0;r<N;r++){
				rus.rating.add(sc.nextInt());
			}
			Collections.sort(rus.rating, Collections.reverseOrder());
			for(int k=0;k<N;k++){
				kor.rating.add(sc.nextInt());
			}
			Collections.sort(kor.rating, Collections.reverseOrder());
			
			cnt = 0;
			index = 0;
			for (int r : rus.rating) {
				if(r <= kor.rating.get(index)){
					cnt++;
					index++;
				}
			}
			System.out.println(cnt);
		}
	}
	
	static class Team{
		ArrayList<Integer> rating;
		Team(){
			this.rating = new ArrayList<Integer>();
		}
	}
}
