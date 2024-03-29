package study0404;

import java.util.Scanner;

public class Solution_D4_6109_추억의2048게임 {

	static int T, N;
	static String D;
	static int[][] map;
	static int[] dy = { 1, 0, -1, 0 }; // 하, 우, 상, 좌
	static int[] dx = { 0, 1, 0, -1 };

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			D = sc.next();
			map = new int[N][N];
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			move();
			System.out.println("#" + t);
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					System.out.print(map[i][j] + " ");
				}
				System.out.println();
			}
		}
	}

	static void move() {
		if (D.equals("left")) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) 
					push(i, j, 1, i, j);
			}
		} else if (D.equals("right")) {
			for (int i = 0; i < N; i++) {
				for (int j = N - 1; j >= 0; j--) 
					push(i, j, 3, i, j);
			}
		} else if (D.equals("up")) {
			for (int j = 0; j < N; j++) {
				for (int i = 0; i < N; i++) 
					push(i, j, 0, i, j);
			}
		} else {
			for (int j = 0; j < N; j++) {
				for (int i = N - 1; i >= 0; i--) 
					push(i, j, 2, i, j);
			}
		}
	}

	static void push(int y, int x, int d, int cy, int cx) {
		int ny = y + dy[d];
		int nx = x + dx[d];
		if (ny < 0 || nx < 0 || ny >= N || nx >= N)
			return;
		if (map[ny][nx] == 0) {
			push(ny, nx, d, cy, cx);
		} else if (map[cy][cx] != map[ny][nx]) {
			if (map[cy][cx] == 0) {
				map[cy][cx] = map[ny][nx];
				map[ny][nx] = 0;
				push(cy, cx, d, cy, cx);
			}
			return;
		} else if (map[ny][nx] == map[cy][cx]) {
			map[cy][cx] *= 2;
			map[ny][nx] = 0;
			return;
		}
	}
}
