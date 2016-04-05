package swc.problem;

/**
 * @author	Lee Jinseoung
 * @type	DFS
 */
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;

public class AD_20160326_DFS {

	public static int n, minCount;
	public static int[] stats;
	public static boolean[][] words;
	public static ArrayList<UsedAlphabet> usedAlphabets;

	public static class UsedAlphabet {
		public UsedAlphabet(int charater, int count) {
			this.character = charater;
			this.count = count;
		}

		int character;
		int count;
	}

	public static void main(String[] args) throws Exception {
		System.setIn(new FileInputStream("resources/swc/20160326_2_input.txt"));
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while (T-- > 0) {
			 long startTime = System.currentTimeMillis();
			usedAlphabets = new ArrayList<UsedAlphabet>();
			minCount = Integer.MAX_VALUE;
			n = sc.nextInt();
			stats = new int[26];
			words = new boolean[n][26];
			/********************************** ������ �Է� �ʵ� **********************************/
			for (int i = 0; i < n; i++) {

				String word = sc.next().replaceAll("[aeuio]", "").toLowerCase();
				Character alphabet;

				for (int j = 0; word.length() != 0;) {
					words[i][(alphabet = word.charAt(j)) - 'a'] = true;
					word = word.replaceAll(alphabet.toString(), "");
					stats[alphabet - 'a']++;
				}
			}


			for (int i = 0; i < 26; i++)
				if (stats[i] != 0)
					usedAlphabets.add(new UsedAlphabet(i, stats[i]));

			Collections.sort(usedAlphabets, new Comparator<UsedAlphabet>() {
				@Override
				public int compare(UsedAlphabet a, UsedAlphabet b) {
					return b.count - a.count;
				}
			});

			search(-1, 0, new boolean[n]);
			System.out.println(minCount);
			printInformation(startTime);
		}
	}

	public static void search(int target, int count, boolean[] usedWords) {
		for (int i = target + 1; i < usedAlphabets.size(); i++) {

			boolean[] copyed = Arrays.copyOf(usedWords, n);

			useAlpha(usedAlphabets.get(i).character, copyed);

			if (isAllUsed(copyed)) {
				if (minCount > count + 1)
					minCount = count + 1;
				return;
			} else {
				search(i, count + 1, copyed);
			}
		}
	}

	public static boolean isAllUsed(boolean[] usedWords) {
		for (boolean isUsed : usedWords) {
			if (!isUsed)
				return false;
		}
		return true;
	}

	public static void useAlpha(int alpha, boolean[] usedWords) {
		for (int i = 0; i < words.length; i++) {
			if (words[i][alpha])
				usedWords[i] = true;
		}
	}

	// TEST �Լ�
	public static void printInformation(long startTime) {
		System.out.println("PROCESS TIEM : "
				+ ((long) System.currentTimeMillis() - startTime));

//		for (int i = 0; i < n; i++) {
//			for (int j = 0; j < 26; j++) {
//				if (words[i][j]) {
//					System.out.print((char) ('a' + j));
//				}
//			}
//			System.out.println();
//		}
//
//		for (UsedAlphabet alpha : usedAlphabets)
//			System.out.println((char) ('a' + alpha.character) + " : "
//					+ alpha.count);
	}
}