package study0403;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_2917_늑대사냥꾼2 {

	static int N, M, ey, ex, sy, sx;
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
		map = new int[N][M];
		dis = new int[N][M];
		tvisit = new boolean[N][M];
		visit = new boolean[N][M];
		for (int i = 0; i < N; i++) {
			char[] c = sc.next().toCharArray();
			for (int j = 0; j < M; j++) {
				if (c[j] == '+') {
					tvisit[i][j] = true;
					q.add(new Point(i, j, 0, 0));
				} else if (c[j] == 'V') {
					sy = i;
					sx = j;
				} else if (c[j] == 'J') {
					ey = i;
					ex = j;
				}
			}
		}
		treeDis();
		for (int i = 0; i < N; i++)
			System.arraycopy(map[i], 0, dis[i], 0, M);
		go();
	}

//	static void Print() {
//		for (int i = 0; i < N; i++) {
//			for (int j = 0; j < M; j++) {
//				System.out.print(map[i][j] + " ");
//			}
//			// System.out.print("\t");
//			// for (int j = 0; j < M; j++) {
//			// if (visit[i][j])
//			// System.out.print("1");
//			// else
//			// System.out.print("0");
//			// }
//			System.out.println();
//		}
//	}

	static void go() {
		pq.add(new Point(sy, sx, 0, dis[sy][sx]));
		while (!pq.isEmpty()) {
			Point cur = pq.poll();
			if (visit[cur.y][cur.x])
				continue;
			visit[cur.y][cur.x] = true;
			if (cur.y == ey && cur.x == ex) {
				System.out.println(cur.min);
				return;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visit[ny][nx])
					continue;
				//map[ny][nx] = Math.max(map[ny][nx], map[cur.y][cur.x] + map[ny][nx]);
				pq.add(new Point(ny, nx, map[ny][nx], Math.min(dis[ny][nx], cur.min)));
			}
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
				q.add(new Point(ny, nx, cur.v + 1, 0));
			}
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, v, min;

		public Point(int y, int x, int v, int min) {
			super();
			this.y = y;
			this.x = x;
			this.v = v;
			this.min = min;
		}

		@Override
		public int compareTo(Point arg0) {
			return arg0.v - this.v;
		}

	}

}
