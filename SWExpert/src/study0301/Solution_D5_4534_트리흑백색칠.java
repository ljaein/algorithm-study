package study0301;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Solution_D5_4534_트리흑백색칠 {

	static int T, N;
	static List<Integer>[] link;
	static long[][] memo;
	static final int MOD = 1000000007;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			link = new ArrayList[N];
			memo = new long[2][N];
			for (int i = 0; i < N; i++) {
				link[i] = new ArrayList<>();
			}
			for (int i = 0; i < N - 1; i++) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				link[a - 1].add(b - 1);
				link[b - 1].add(a - 1);
			}
			long ans = (dfs(0, 0, -1) + dfs(0, 1, -1)) % MOD;
			System.out.println("#" + t + " " + ans);
		}
	}

	public static long dfs(int v, int c, int parent) {
		if (memo[c][v] != 0)
			return memo[c][v];
		long res = 1;
		if (c == 0) {
			for (int i : link[v]) {
				if (i != parent) {
					res *= dfs(i, 0, v) + dfs(i, 1, v);
					res %= MOD;
				}
			}
		} else {
			for (int i : link[v]) {
				if (i != parent) {
					res *= dfs(i, 0, v);
					res %= MOD;
				}
			}
		}
		memo[c][v] = res;
		return res;
	}

}
