package study0304;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1600_말이되고픈원숭이 {

	static int K, W, H, ans;
	static int[][] map;
	static boolean[][][] visit;
	static int[] n_dy = { -1, -2, -2, -1, 1, 2, 2, 1 };
	static int[] n_dx = { -2, -1, 1, 2, 2, 1, -1, -2 };
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ans = -1;
		K = sc.nextInt();
		W = sc.nextInt();
		H = sc.nextInt();
		map = new int[H][W];
		visit = new boolean[H][W][K + 1];
		for (int i = 0; i < H; i++) {
			for (int j = 0; j < W; j++) {
				map[i][j] = sc.nextInt();
			}
		}
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		visit[0][0][0] = true;
		q.add(new Point(0, 0, 0, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.y == H - 1 && cur.x == W - 1 && cur.kcnt <= K) {
				ans = cur.cnt;
				return;
			}
			if (cur.kcnt < K) {
				for (int d = 0; d < 8; d++) {
					int ny = cur.y + n_dy[d];
					int nx = cur.x + n_dx[d];
					if (ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][cur.kcnt + 1] || map[ny][nx] == 1)
						continue;
					// System.out.println("ch"+ ny+" "+nx);
					visit[ny][nx][cur.kcnt + 1] = true;
					q.add(new Point(ny, nx, cur.cnt + 1, cur.kcnt + 1));
				}
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= H || nx >= W || visit[ny][nx][cur.kcnt] || map[ny][nx] == 1)
					continue;
				// System.out.println(ny+" "+nx);
				visit[ny][nx][cur.kcnt] = true;
				q.add(new Point(ny, nx, cur.cnt + 1, cur.kcnt));
			}
		}

	}

	static class Point {
		int y, x, cnt, kcnt;

		public Point(int y, int x, int cnt, int kcnt) {
			super();
			this.y = y;
			this.x = x;
			this.cnt = cnt;
			this.kcnt = kcnt;
		}

	}

}
