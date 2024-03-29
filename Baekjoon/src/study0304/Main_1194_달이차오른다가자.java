package study0304;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_1194_달이차오른다가자 {

	static int N, M, ans;
	static char[][] map;
	static boolean[][][] visited;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static Queue<Point> q = new LinkedList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = -1;
		map = new char[N][M];
		visited = new boolean[N][M][64];
		for (int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (map[i][j] == '0') {
					q.add(new Point(i, j, 0, 0));
					visited[i][j][0] = true;
					map[i][j] = '.';
				}

			}
		}
		bfs();
		System.out.println(ans);
	}

	static void bfs() {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (map[cur.y][cur.x] == '1') {
				ans = cur.cnt;
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx][cur.key] || map[ny][nx] == '#')
					continue;
				if (map[ny][nx] >= 'a' && map[ny][nx] <= 'f') {
					int key = cur.key | (1 << (map[ny][nx] - 'a'));
					if (!visited[ny][nx][key]) {
						visited[ny][nx][key] = true;
						q.add(new Point(ny, nx, key, cur.cnt + 1));
					}
				} else if (map[ny][nx] >= 'A' && map[ny][nx] <= 'F') {
					if ((cur.key & (1 << (map[ny][nx] - 'A'))) != 0) {
						visited[ny][nx][cur.key] = true;
						q.add(new Point(ny, nx, cur.key, cur.cnt + 1));
					}
				} else {
					visited[ny][nx][cur.key] = true;
					q.add(new Point(ny, nx, cur.key, cur.cnt + 1));
				}
			}
		}
	}

	static class Point {
		int y, x, key, cnt;

		public Point(int y, int x, int key, int cnt) {
			this.y = y;
			this.x = x;
			this.key = key;
			this.cnt = cnt;
		}

	}

}
