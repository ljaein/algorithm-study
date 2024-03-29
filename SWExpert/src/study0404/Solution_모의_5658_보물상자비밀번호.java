package study0404;

import java.util.Iterator;
import java.util.Scanner;
import java.util.TreeSet;

public class Solution_모의_5658_보물상자비밀번호 {

	static int T, N, K;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		T = sc.nextInt();
		for (int t = 1; t <= T; t++) {
			N = sc.nextInt();
			K = sc.nextInt();
			String s = sc.next();
			TreeSet<String> set = new TreeSet<>();
			for (int i = 0; i < N / 4; i++) {
				for (int j = 0; j < N; j += (N/4)) {
					set.add(s.substring(j, j + N/4));
				}
				s = s.substring(N - 1, N) + s.substring(0, N - 1);
			}
			Iterator<String> it = set.iterator();
			int cnt = 1;
			while (cnt < set.size() - K + 1) {
				it.next();
				cnt++;
			}
			System.out.println("#" + t + " " + Integer.parseInt(it.next(), 16));
		}
	}

}
