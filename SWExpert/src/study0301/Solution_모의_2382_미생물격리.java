package study0301;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_모의_2382_미생물격리 {

	static int N, M, K, ans;
	static LinkedList<Bug> list;
	static int[] dy = { 0, -1, 1, 0, 0 };
	static int[] dx = { 0, 0, 0, -1, 1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			M = sc.nextInt();
			K = sc.nextInt();
			list = new LinkedList<>();
			ans = 0;
			for (int i = 0; i < K; i++)
				list.add(new Bug(sc.nextInt(), sc.nextInt(), sc.nextInt(), sc.nextInt()));
			for (int i = 0; i < M; i++)
				move();
			for (int i = 0; i < list.size(); i++)
				ans += list.get(i).c;
			System.out.println("#" + t + " " + ans);
		}
	}

	static void move() {
		for (int i = 0; i < list.size(); i++) {
			Bug cur = list.get(i);
			int y = cur.y + dy[cur.d];
			int x = cur.x + dx[cur.d];
			int c = cur.c;
			int d = cur.d;
			if (y == 0 || x == 0 || y == N - 1 || x == N - 1) {
				c = c / 2;
				if (d == 1)
					d = 2;
				else if (d == 2)
					d = 1;
				else if (d == 3)
					d = 4;
				else if (d == 4)
					d = 3;
			}
			list.get(i).y = y;
			list.get(i).x = x;
			list.get(i).c = c;
			list.get(i).d = d;
		}
		int[][] sum = new int[N][N];
		int[][] max = new int[N][N];
		int[][] d = new int[N][N];
		for (int i = 0; i < list.size(); i++) {
			Bug cur = list.get(i);
			sum[cur.y][cur.x] += cur.c;
			if (max[cur.y][cur.x] < cur.c) {
				max[cur.y][cur.x] = cur.c;
				d[cur.y][cur.x] = cur.d;
			}
		}
		list = new LinkedList<>();
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (sum[i][j] != 0) {
					list.add(new Bug(i, j, sum[i][j], d[i][j]));
				}
			}
		}
	}

	static class Bug {
		int y, x, c, d;

		public Bug(int y, int x, int c, int d) {
			this.y = y;
			this.x = x;
			this.c = c;
			this.d = d;
		}

	}

}
