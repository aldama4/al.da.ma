package algospot;

import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

/**
 * 너비가 같은 N개의 나무 판자를 붙여 세운 울타리가 있습니다. 시간이 지남에 따라 판자들이 부러지거나 망가져 높이가 다 달라진 관계로
 * 울타리를 통째로 교체하기로 했습니다. 이 때 버리는 울타리의 일부를 직사각형으로 잘라내 재활용하고 싶습니다. 울타리를 구성하는 각 판자의
 * 높이가 주어질 때, 잘라낼 수 있는 직사각형의 최대 크기를 계산하는 프로그램을 작성하세요. 단 직사각형을 비스듬히 잘라낼 수는 없습니다.
 * 판자의 너비는 모두 1이라고 가정합니다. ##입력## 첫 줄에 테스트 케이스의 개수 C (C≤50)가 주어집니다. 각 테스트 케이스의 첫
 * 줄에는 판자의 수 N (1≤N≤20000)이 주어집니다. 그 다음 줄에는 N개의 정수로 왼쪽부터 각 판자의 높이가 순서대로 주어집니다.
 * 높이는 모두 10,000 이하의 음이 아닌 정수입니다. ##출력## 각 테스트 케이스당 정수 하나를 한 줄에 출력합니다. 이 정수는 주어진
 * 울타리에서 잘라낼 수 있는 최대 직사각형의 크기를 나타내야 합니다.
 * 
 * @author KooKoo
 *
 */
public class Fence_Jade {

	// 1.최대값을 찾는다
	// 2.좌우로 자신과 같은 값이 있는지 확인한다.
	// 3-1.왼편에 같은 값이 있으면 더하고 한칸 더 이동하여 반복. 만약 없으면 종료
	// 3-2.오른편도 3-1과 마찬가지로.
	// 4. 3에서 구한 값을 Max 에 넣고, 그 Max 보다 크면 갱신하는 형태로
	// 1~4 반복.

	static int N, index, max = 0;
	static int[][] fence;
	static ArrayList<int[]> sortedFence;
	static boolean[] checker;

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/algospot/Fence_input.txt"));
		Scanner sc = new Scanner(System.in);

		int T = sc.nextInt();
		while (T-- > 0) {
			max = 0;
			index = 0;
			sortedFence = new ArrayList<int[]>();
			N = sc.nextInt();
			fence = new int[N][2];
			checker = new boolean[N];
			for (int i = 0; i < N; i++) {
				fence[i][0] = sc.nextInt();
				fence[i][1] = i;
				sortedFence.add(fence[i]);
			}
			Collections.sort(sortedFence, new Comparator<int[]>() {
				@Override
				public int compare(int[] a, int[] b) {
					return b[0] - a[0];
				}
			});
			System.out.println(searchBiggestSize());
		}
	}

	private static int searchBiggestSize() {
		while (index < N) {
			int[] temp = sortedFence.get(index);
			if (!checker[temp[1]]) {
				int result = calcSize(temp[1]) + fence[temp[1]][0];
				max = max < result ? result : max;
			}
			index++;
		}
		return max;
	}

	private static int calcSize(int idx) {
		int left = 0, right = 0;
		int selectedFence = fence[idx][0];
		for (int l = idx - 1; l >= 0; l--) {
			if (selectedFence > fence[l][0]) {
				break;
			}
			checker[l] = true;
			left += selectedFence;
		}

		for (int r = idx + 1; r < N; r++) {
			if (selectedFence > fence[r][0]) {
				break;
			}
			checker[r] = true;
			right += selectedFence;
		}
		return left + right;
	}

}
