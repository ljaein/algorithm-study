package study0204;

import java.util.Scanner;

public class Solution_모의_1952_수영장 {

	static int T, D, M, S, Y, min;
	static int[] plan;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			D = sc.nextInt();
			M = sc.nextInt();
			S = sc.nextInt();
			Y = sc.nextInt();
			min = Integer.MAX_VALUE;
			plan = new int[12];
			for (int i = 0; i < 12; i++) {
				plan[i] = sc.nextInt();
			}
			pay(0, 0);
			System.out.println("#" + t + " " + Math.min(min, Y));
		}
	}

	public static void pay(int m, int total) {
		if (m >= 12) {
			min = Math.min(min, total);
			return;
		}
		pay(m + 1, total + plan[m] * D);
		pay(m + 1, total + M);
		pay(m + 3, total + S);
	}

}
