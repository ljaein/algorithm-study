package study0404;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_13460_구슬탈출2 {

	static int N, M, ans;
	static boolean find;
	static char[][] map;
	static boolean[][][][] visit;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static int ry, rx, by, bx;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		visit = new boolean[N][M][N][M];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 'R') {
					ry = i;
					rx = j;
				} else if (map[i][j] == 'B') {
					by = i;
					bx = j;
				}
			}
		}
		bfs();
		System.out.println(find ? ans : -1);
	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		q.add(new Point(ry, rx));
		q.add(new Point(by, bx));
		while (!q.isEmpty()) {
			int qsize = q.size();
			for (int s = 0; s < qsize / 2; s++) {
				Point rcur = q.poll();
				Point bcur = q.poll();
				visit[rcur.y][rcur.x][bcur.y][bcur.x] = true;
				f: for (int d = 0; d < 4; d++) {
					int rny = rcur.y;
					int rnx = rcur.x;
					int bny = bcur.y;
					int bnx = bcur.x;
					while (map[bny + dy[d]][bnx + dx[d]] != '#') {
						bny += dy[d];
						bnx += dx[d];
						if (map[bny][bnx] == 'O')
							continue f;
					}
					while (map[rny + dy[d]][rnx + dx[d]] != '#') {
						rny += dy[d];
						rnx += dx[d];
						if (map[rny][rnx] == 'O') {
							ans++;
							find = true;
							return;
						}
					}

					if (bny == rny && bnx == rnx) {
						if (d == 0) {
							if (bcur.y > rcur.y)
								bny++;
							else
								rny++;
						} else if (d == 1) {
							if (bcur.x > rcur.x)
								rnx--;
							else
								bnx--;
						} else if (d == 2) {
							if (bcur.y > rcur.y)
								rny--;
							else
								bny--;
						} else {
							if (bcur.x > rcur.x)
								bnx++;
							else
								rnx++;
						}
					}

					if (!visit[rny][rnx][bny][bnx]) {
						q.add(new Point(rny, rnx));
						q.add(new Point(bny, bnx));
					}
				}
			}
			ans++;
			if (ans > 9){
				find = false;
				return;
			}
		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			super();
			this.y = y;
			this.x = x;
		}

	}
}
