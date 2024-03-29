package study0203;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_14502_연구소 {

	static int N, M, max;
	static int[][] fix_map, map;
	static boolean[][] visited;
	static int[] sel;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };
	static ArrayList<Point> blank = new ArrayList<>();
	static ArrayList<Point> virus = new ArrayList<>();

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		sel = new int[3];
		fix_map = new int[N][M];
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				fix_map[i][j] = sc.nextInt();
				if (fix_map[i][j] == 0)
					blank.add(new Point(i, j));
				else if (fix_map[i][j] == 2)
					virus.add(new Point(i, j));
			}
		}

		combi(0, 0);
		System.out.println(max);

	}

	public static void combi(int start, int cnt) {
		if (cnt == 3) {
			for (int i = 0; i < N; i++)
				System.arraycopy(fix_map[i], 0, map[i], 0, M);
			for (int i = 0; i < 3; i++) {
				Point p = blank.get(sel[i]);
				map[p.y][p.x] = 1;
			}
			visited = new boolean[N][M];
			bfs();
			return;
		}
		for (int i = start; i < blank.size(); i++) {
			sel[cnt] = i;
			combi(i + 1, cnt + 1);
		}
	}

	public static void bfs() {
		Queue<Point> q = new LinkedList<>();
		for (int i = 0; i < virus.size(); i++) {
			Point v = virus.get(i);
			visited[v.y][v.x] = true;
			q.add(v);
		}
		while (!q.isEmpty()) {
			Point cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int ny = cur.y + dy[d];
				int nx = cur.x + dx[d];
				if (ny < 0 || nx < 0 || ny >= N || nx >= M || visited[ny][nx])
					continue;
				if (map[ny][nx] == 0) {
					visited[ny][nx] = true;
					map[ny][nx] = 1;
					q.add(new Point(ny, nx));
				}
			}
		}
		int cnt = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0)
					cnt++;
			}
		}
		max = Math.max(max, cnt);
	}

	static class Point {
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
	}
}
