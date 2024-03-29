package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1541_잃어버린괄호 {

	static String s;
	static int ans;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		String[] s = br.readLine().split("-");
		for (int i = 0; i < s.length; i++) {
			String[] s2 = s[i].split("[+]");
			int sum = 0;
			for (String num : s2) {
				sum += Integer.parseInt(num);
			}
			if (i == 0) {
				ans = sum;
			} else
				ans -= sum;
		}
		System.out.println(ans);
	}

}
