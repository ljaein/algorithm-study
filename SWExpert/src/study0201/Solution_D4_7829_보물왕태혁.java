package study0201;

import java.util.Arrays;
import java.util.Scanner;

public class Solution_D4_7829_보물왕태혁 {

	static int T, P, N;
	static int[] arr;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			P = sc.nextInt();
			arr = new int[P];
			for (int i = 0; i < P; i++) {
				arr[i] = sc.nextInt();
			}
			Arrays.sort(arr);
			if (P % 2 == 0) {
				N = arr[0] * arr[P - 1];
			} else {
				N = arr[P / 2] * arr[P/2];
			}
			System.out.println("#" + t + " " + N);

		}

	}

}
