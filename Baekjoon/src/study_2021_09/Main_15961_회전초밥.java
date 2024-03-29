package study_2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_15961_회전초밥 {
	static int N, d, k, c;
	static int[] arr, num;

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		d = Integer.parseInt(st.nextToken());
		k = Integer.parseInt(st.nextToken());
		c = Integer.parseInt(st.nextToken());

		int window = k;
		arr = new int[N + window - 1];
		num = new int[d + 1];
		for (int i = 0; i < N; i++) {
			arr[i] = Integer.parseInt(br.readLine());
		}
		for (int i = N; i < N + window - 1; i++) {
			arr[i] = arr[i - N];
		}
		int cnt = 0;
		int max = 0;
		for (int i = 0; i < N + window - 1; i++) {
			if (++num[arr[i]] == 1) {
				cnt++;
			}
			if (i < window - 1)
				continue;
			if (i > window - 1) {
				if (--num[arr[i - window]] == 0) {
					cnt--;
				}
			}
			max = Math.max(max, cnt);
			if (num[c] == 0) {
				max = Math.max(max, cnt + 1);
			}
			if (max >= k + 1)
				break;
		}
		System.out.println(max);
	}

}
