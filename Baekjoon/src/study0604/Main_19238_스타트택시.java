package study0604;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_19238_스타트택시 {

	static int N, M, power, ty, tx;
	static int[][] map;
	static Point[] start, end;
	static int[] dy = { 0, 1, 0, -1 };
	static int[] dx = { 1, 0, -1, 0 };
	static boolean ans = true;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		power = Integer.parseInt(st.nextToken());
		map = new int[N][N];
		start = new Point[M];
		end = new Point[M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		st = new StringTokenizer(br.readLine());
		ty = Integer.parseInt(st.nextToken()) - 1;
		tx = Integer.parseInt(st.nextToken()) - 1;
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sy = Integer.parseInt(st.nextToken()) - 1;
			int sx = Integer.parseInt(st.nextToken()) - 1;
			int ey = Integer.parseInt(st.nextToken()) - 1;
			int ex = Integer.parseInt(st.nextToken()) - 1;
			start[i] = new Point(sy, sx);
			end[i] = new Point(ey, ex);
		} // 입력
		for (int i = 0; i < M; i++) {
			select();
			if (!ans) {
				System.out.println(-1);
				return;
			}
		}
		System.out.println(power);
	}

	static void select() {
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for (int i = 0; i < M; i++) {
			if (start[i] == null)
				continue;
			Point cur = start[i];
			cur.dis = bfs(cur.y, cur.x);
			if (cur.dis == -1) {
				ans = false;
				return;
			}
			cur.n = i;
			pq.add(cur);
		}
		Point sel = pq.poll();
		ty = sel.y;
		tx = sel.x;
		power -= sel.dis;
		if (power <= 0) {
			ans = false;
			return;
		}
		int edis = bfs(end[sel.n].y, end[sel.n].x);
		if (edis == -1) {
			ans = false;
			return;
		}
		power -= edis;
		if (power < 0) {
			ans = false;
			return;
		}
		power += edis * 2;
		ty = end[sel.n].y;
		tx = end[sel.n].x;
		start[sel.n] = null;
	}

	static int bfs(int sy, int sx) {
		Queue<Point> q = new LinkedList<>();
		boolean[][] visit = new boolean[N][N];
		q.add(new Point(ty, tx, 0));
		visit[ty][tx] = true;
		while (!q.isEmpty()) {
			Point cur = q.poll();
			if (cur.y == sy && cur.x == sx) {
				return cur.dis;
			}
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= N || visit[ny][nx] || map[ny][nx] == 1)
					continue;
				visit[ny][nx] = true;
				q.add(new Point(ny, nx, cur.dis + 1));
			}
		}
		return -1;
	}

	static class Point implements Comparable<Point> {
		int y, x, dis, n;

		public Point(int y, int x, int dis) {
			super();
			this.y = y;
			this.x = x;
			this.dis = dis;
		}

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}

		@Override
		public int compareTo(Point p) {
			if (this.dis < p.dis)
				return -1;
			else if (this.dis > p.dis)
				return 1;
			else {
				if (this.y < p.y)
					return -1;
				else if (this.y > p.y)
					return 1;
				else {
					if (this.x < p.x)
						return -1;
					else
						return 1;
				}
			}
		}

	}

}
