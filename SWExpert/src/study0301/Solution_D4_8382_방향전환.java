package study0301;

import java.util.Scanner;

public class Solution_D4_8382_방향전환 {

	static int T;
	static int sx, sy, fx, fy;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			sx = sc.nextInt();
			sy = sc.nextInt();
			fx = sc.nextInt();
			fy = sc.nextInt();
			System.out.println("#" + t + " " + go());
		}

	}

	public static int go() {
		int cnt = 0;
		if (sx == fx && sy == fy)
			return cnt;
		boolean cury = false;
		if (Math.abs(sx - fx) < Math.abs(sy - fy))
			cury = true;
		while (sx != fx || sy != fy) {
			if (cury) {
				if (sy < fy)
					sy += 1;
				else
					sy -= 1;
				cury = false;
			} else {
				if (sx < fx)
					sx += 1;
				else
					sx -= 1;
				cury = true;
			}
			cnt++;
		}
		return cnt;
	}

}