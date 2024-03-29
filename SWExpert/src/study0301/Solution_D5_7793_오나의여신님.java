package study0301;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Solution_D5_7793_오나의여신님 {

	static int N, M, ans;
	static boolean isfind;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> dev;
	static Queue<Point> q;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			ans = 0;
			isfind = false;
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N][M];
			visited = new boolean[N][M];
			dev = new LinkedList<>();
			q = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				map[i] = sc.next().toCharArray();
				for (int j = 0; j < M; j++) {
					if (map[i][j] == '*') {
						dev.add(new Point(i, j));
					} else if (map[i][j] == 'S') {
						map[i][j] = '.';
						visited[i][j] = true;
						q.add(new Point(i, j));
					}
				}
			}
			bfs();
			System.out.println("#" + t + " " + (isfind ? ans : "GAME OVER"));
		}

	}

	static void bfs() {
		while (!dev.isEmpty() || !q.isEmpty()) {
			int dsize = dev.size();
			for (int s = 0; s < dsize; s++) {
				Point dcur = dev.poll();
				for (int d = 0; d < 4; d++) {
					int ny = dcur.y + dy[d];
					int nx = dcur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M)
						continue;
					if (map[ny][nx] == '.') {
						map[ny][nx] = '*';
						dev.add(new Point(ny, nx));
					}
				}
			}
			int size = q.size();
			for (int s = 0; s < size; s++) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
						continue;
					if (map[ny][nx] == 'D') {
						ans++;
						isfind = true;
						return;
					} else if (map[ny][nx] == '.') {
						visited[ny][nx] = true;
						q.add(new Point(ny, nx));
					}
				}
			}
			ans++;

		}
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

	}

}
