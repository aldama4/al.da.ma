package swc.sort;

import java.io.FileInputStream;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Scanner;

public class Dinner_Jade {
	static int N, min, X=1, Y=2;
	static Integer[][] xyMap;
	static String sol;
	public static void main(String[] args) throws Exception{
		System.setIn(new FileInputStream("resources/swc/sort_dinner_input.txt"));
		Scanner sc = new Scanner(System.in);
		
		int T = sc.nextInt();
		int number = 0;
		while(T-- > 0){
			min = 1000001;
			sol = "";
			number++;
			N = sc.nextInt();
			xyMap = new Integer[N][3];
			for(int i=0;i<N;i++){
				xyMap[i][0] = i+1;
				xyMap[i][X] = sc.nextInt();
				xyMap[i][Y] = sc.nextInt();
			}
			
			Arrays.sort(xyMap, new Comparator<Integer[]>() {
				@Override
				public int compare(Integer[] a, Integer[] b) {
					if(a[X] < b[X]){
						return -1;
					}else if(a[X] == b[X]){
						if(a[Y] < b[Y]){
							return -1;
						}
					}
					return 1;
				}
			});
			System.out.println("#"+number+" "+searchRestaurant(0).trim());
		}
	}
		
	private static String searchRestaurant(int n) {
		if(n==N){
			return sol;
		}
		if(min > xyMap[n][Y]){
			min = xyMap[n][Y];
			sol += xyMap[n][0]+" ";
		}
		
		return searchRestaurant(n+1);
	}
}
