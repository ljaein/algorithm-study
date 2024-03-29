package todo;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Main_1756_피자굽기 {

	static int D, N, ans;
	static int[] oven;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = null;
		st = new StringTokenizer(br.readLine());
		D = Integer.parseInt(st.nextToken());
		N = Integer.parseInt(st.nextToken());
		oven = new int[D];
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < D; i++) {
			oven[i] = Integer.parseInt(st.nextToken());
		}
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int r = Integer.parseInt(st.nextToken());
			if (ans != -1)
				go(r);
		}
		System.out.println(ans + 1);
	}

	static void go(int r) {
		for (int i = 0; i < D; i++) {
			if (oven[i] < r) {
				oven[i - 1] = 0;
				ans = i - 1;
				break;
			}
		}
	}

}
