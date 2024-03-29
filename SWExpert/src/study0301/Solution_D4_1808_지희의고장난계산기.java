package study0301;

import java.util.Scanner;

public class Solution_D4_1808_지희의고장난계산기 {

	static int X;
	static int[] num;
	static int[] dp;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			num = new int[10];
			for (int i = 0; i < 10; i++)
				num[i] = sc.nextInt();
			X = sc.nextInt();
			dp = new int[X + 1];
			System.out.println("#" + t + " " + (calc(X) == Integer.MAX_VALUE ? -1 : calc(X) + 1));
		}

	}

	static int calc(int n) {
		if (dp[n] != 0)
			return dp[n];
		dp[n] = numcnt(n);
		for (int i = 1; i <= (int) Math.sqrt(n); i++) {
			if (n % i == 0) {
				int a = calc(i);
				int b = calc(n / i);
				if (a != Integer.MAX_VALUE && b != Integer.MAX_VALUE)
					dp[n] = Math.min(dp[n], a + b + 1);
			}
		}
		return dp[n];
	}

	static int numcnt(int n) {
		int cnt = 0;
		while (n > 0) {
			int rest = n % 10;
			if (num[rest] == 0)
				return Integer.MAX_VALUE;
			n = n / 10;
			cnt++;
		}
		return cnt;
	}

}
