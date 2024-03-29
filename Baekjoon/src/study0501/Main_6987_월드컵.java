package study0501;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_6987_월드컵 {

	static int[][] sco;
	static int ans;
	static boolean fin;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		for (int t = 0; t < 4; t++) {
			StringTokenizer st = new StringTokenizer(br.readLine());
			ans = 0;
			fin = false;
			sco = new int[6][3];
			int sum = 0;
			for (int i = 0; i < 6; i++) {
				for (int j = 0; j < 3; j++) {
					sco[i][j] = Integer.parseInt(st.nextToken());
					sum += sco[i][j];
				}
			}

			if (sum != 30)
				fin = false;
			else
				game(0, 1, 0);
			System.out.println(!fin ? 0 : 1);
		}

	}

	static void game(int a, int b, int cnt) {
		if (cnt == 15) {
			fin = true;
			return;
		}
		
		if (sco[a][0] > 0 && sco[b][2] > 0) {
			sco[a][0]--;
			sco[b][2]--;
			if (b < 5) {
				game(a, b + 1, cnt + 1);
			} else {
				game(a + 1, a + 2, cnt + 1);
			}
			sco[a][0]++;
			sco[b][2]++;
		}
		if (sco[a][1] > 0 && sco[b][1] > 0) {
			sco[a][1]--;
			sco[b][1]--;
			if (b < 5) {
				game(a, b + 1, cnt + 1);
			} else {
				game(a + 1, a + 2, cnt + 1);
			}
			sco[a][1]++;
			sco[b][1]++;
		}
		if (sco[a][2] > 0 && sco[b][0] > 0) {
			sco[a][2]--;
			sco[b][0]--;
			if (b < 5) {
				game(a, b + 1, cnt + 1);
			} else {
				game(a + 1, a + 2, cnt + 1);
			}
			sco[a][2]++;
			sco[b][0]++;
		}
	}

}
