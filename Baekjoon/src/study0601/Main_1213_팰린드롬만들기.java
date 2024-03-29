package study0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1213_팰린드롬만들기 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		char[] c = br.readLine().toCharArray();
		int[] alph = new int[26];
		String res = "";
		Arrays.sort(c);
		for (int i = 0; i < c.length; i++) {
			alph[c[i] - 'A']++;
		}
		String hol = "";
		int holcnt = 0;
		for (int i = 0; i < 26; i++) {
			if (alph[i] % 2 == 0) {
				int num = alph[i] / 2;
				for (int j = 0; j < num; j++) {
					res += (char) (i + 'A') + "";
				}
			} else {
				holcnt++;
				if (alph[i] != 1) {
					int num = alph[i]-1;
					hol += (char) (i + 'A') + "";
					for(int j=0;j<num/2;j++)
						res+=(char) (i + 'A') + "";
					
				} else {
					hol += (char) (i + 'A') + "";
				}
			}
		}
		if (holcnt != 0 &&  holcnt != 1) {
			System.out.println("I'm Sorry Hansoo");
			return;
		}

		String ans = "";
		if (hol.equals("")) {
			for (int i = 0; i < res.length(); i++) {
				ans += res.substring(i, i + 1);
			}
			for (int i = res.length() - 1; i >= 0; i--) {
				ans += res.substring(i, i + 1);
			}
		} else {
			for (int i = 0; i < res.length(); i++) {
				ans += res.substring(i, i + 1);
			}
			ans += hol;
			for (int i = res.length() - 1; i >= 0; i--) {
				ans += res.substring(i, i + 1);
			}
		}
		System.out.println(ans);

	}

}
