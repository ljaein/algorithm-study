package study0204;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Main_3055_탈출 {

	static int R, C;
	static int fy, fx, time;
	static char[][] map;
	static boolean[][] visited;
	static Queue<Point> wq, q;
	static int[] dy = { -1, 0, 1, 0 };
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		R = sc.nextInt();
		C = sc.nextInt();
		map = new char[R][C];
		visited = new boolean[R][C];
		wq = new LinkedList<>();
		q = new LinkedList<>();
		for (int i = 0; i < R; i++) {
			map[i] = sc.next().toCharArray();
			for (int j = 0; j < C; j++) {
				if (map[i][j] == 'S') {
					map[i][j] = '.';
					visited[i][j] = true;
					q.add(new Point(i, j, 0));
				} else if (map[i][j] == 'D') {
					fy = i;
					fx = j;
				} else if (map[i][j] == '*') {
					wq.add(new Point(i, j, 0));
				}
			}
		}
		go();
		System.out.println(time == 0 ? "KAKTUS" : time);

	}

	public static void go() {
		while (!wq.isEmpty() || !q.isEmpty()) {
			int size = wq.size();
			for (int s = 0; s < size; s++) {
				Point wcur = wq.poll();
				for (int d = 0; d < 4; d++) {
					int wy = wcur.y + dy[d];
					int wx = wcur.x + dx[d];
					if (wy < 0 || wx < 0 || wy >= R || wx >= C || map[wy][wx] == 'X' || map[wy][wx] == 'D')
						continue;
					if (map[wy][wx] == '.') {
						map[wy][wx] = '*';
						wq.add(new Point(wy, wx, 0));
					}

				}
			}
			int qsize = q.size();
			for (int s = 0; s < qsize; s++) {
				Point cur = q.poll();
				for (int d = 0; d < 4; d++) {
					int ny = cur.y + dy[d];
					int nx = cur.x + dx[d];
					if (ny < 0 || nx < 0 || ny >= R || nx >= C || visited[ny][nx])
						continue;
					if (map[ny][nx] == 'D') {
						time = cur.t + 1;
						return;
					}
					if (map[ny][nx] == '.') {
						visited[ny][nx] = true;
						q.add(new Point(ny, nx, cur.t + 1));
					}
				}
			}

		}
	}

	static class Point {
		int y, x, t;

		public Point(int y, int x, int t) {
			this.y = y;
			this.x = x;
			this.t = t;
		}
	}

}
