package study0403;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_2917_늑대사냥꾼 {

	static int N, M, ey, ex, ans;
	static int[][] map, dis;
	static boolean[][] visit, tvisit;
	static Queue<Point> q = new LinkedList<>();
	static PriorityQueue<Point> pq = new PriorityQueue<>();
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		ans = Integer.MAX_VALUE;
		map = new int[N][M];
		dis = new int[N][M];
		tvisit = new boolean[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == '+') {
					tvisit[i][j] = true;
					q.add(new Point(i, j, 0));
				} else if (c[j] == 'V') {
					visit[i][j] = true;
					pq.add(new Point(i, j, 0));
				} else if (c[j] == 'J') {
					ey = i;
					ex = j;
				}
			}
		}
		treeDis();
		go();
		System.out.println(ans);
	}

	static void go() {
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
					continue;
				visit[ny][nx]=true;
				//map[ny][nx] = Math.max(map[ny][nx], map[cur.y][cur.x] + map[ny][nx]);
				Point np = new Point(ny, nx, map[ny][nx]);
				np.prev = cur;
				if (ny == ey && nx == ex) {
					goPrev(np);
					return;
				}
				pq.add(np);
			}
		}
	}

	static void goPrev(Point ver) {
		while (ver != null) {
			ans = Math.min(ans, map[ver.y][ver.x]);
			ver = ver.prev;
		}
	}

	static void treeDis() {
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || tvisit[ny][nx])
					continue;
				tvisit[ny][nx] = true;
				map[ny][nx] = cur.v + 1;
				q.add(new Point(ny, nx, cur.v + 1));
			}
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, v;
		Point prev;

		public Point(int y, int x, int v) {
			super();
			this.y = y;
			this.x = x;
			this.v = v;
		}

		@Override
		public int compareTo(Point arg0) {
			return arg0.v - this.v;
		}

	}

}
