package study0502;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_9328_열쇠 {

	static int T, h, w, ans;
	static char[][] map;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static boolean[] keys;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			h = sc.nextInt();
			w = sc.nextInt();
			ans = 0;
			map = new char[h + 2][w + 2];
			for (int i = 0; i < h + 2; i++) {
				String s = null;
				if (i != 0 && i != h + 1)
					s = '.' + sc.next() + '.';
				for (int j = 0; j < w + 2; j++) {
					if (i == 0 || i == h + 1)
						map[i][j] = '.';
					else
						map[i][j] = s.charAt(j);
				}
			}
			String key = sc.next();
			keys = new boolean[26];
			if (!key.equals("0")) {
				for (int i = 0; i < key.length(); i++) {
					keys[key.charAt(i) - 'a'] = true;
				}
			}
			bfs();
			System.out.println(ans);

		}

	}

	static void bfs() {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[h + 2][w + 2];
		LinkedList<Point> door = new LinkedList<>();
		visit[0][0] = true;
		q.add(new Point(0, 0));
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 | ny >= h + 2 || nx >= w + 2 || map[ny][nx] == '*' || visit[ny][nx])
					continue;
				if (map[ny][nx] == '.') {
					visit[ny][nx] = true;
					q.add(new Point(ny, nx));
				} else if (map[ny][nx] == '$') {
					ans++;
					visit[ny][nx] = true;
					q.add(new Point(ny, nx));
				} else if (map[ny][nx] - 'a' >= 0 && map[ny][nx] - 'z' <= 0) {
					// 소문자
					visit[ny][nx] = true;
					q.add(new Point(ny, nx));
					if (!keys[map[ny][nx] - 'a']) {
						keys[map[ny][nx] - 'a'] = true;
						for (Point p : door) {
							if (keys[map[p.y][p.x] - 'A'] && !visit[p.y][p.x]) {
								visit[p.y][p.x] = true;
								q.add(new Point(p.y, p.x));
							}
						}
					}
				} else if (map[ny][nx] - 'A' >= 0 && map[ny][nx] - 'Z' <= 0) {
					// 대문자
					if (keys[map[ny][nx] - 'A']) {
						map[ny][nx] = '.';
						visit[ny][nx] = true;
						q.add(new Point(ny, nx));
					} else {
						door.add(new Point(ny, nx));
					}
				}

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
