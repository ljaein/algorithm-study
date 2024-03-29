package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_1920_수찾기 {
	static int N, M;
	static int[] narr, marr;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuffer sb = new StringBuffer();
		N = Integer.parseInt(br.readLine());
		StringTokenizer st = new StringTokenizer(br.readLine());
		narr = new int[N];
		for (int i = 0; i < N; i++) {
			narr[i] = Integer.parseInt(st.nextToken());
		}
		M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		marr = new int[M];
		for (int i = 0; i < M; i++) {
			marr[i] = Integer.parseInt(st.nextToken());
		}
		Arrays.sort(narr);
		for (int i = 0; i < M; i++) {
			int ans = search(marr[i]);
			sb.append(ans).append("\n");
		}
		System.out.println(sb);
	}

	static int search(int num) {
		int fir = 0;
		int end = N - 1;
		while (true) {
			if (fir > end)
				return 0;// 수정하기
			int mid = (fir + end) / 2;
			if (narr[mid] == num) {
				return 1;
			} else if (num < narr[mid]) {
				end = mid - 1;
			} else {
				fir = mid + 1;
			}
		}

	}

}
