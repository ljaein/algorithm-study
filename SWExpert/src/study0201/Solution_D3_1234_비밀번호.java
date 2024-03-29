package study0201;

import java.util.LinkedList;
import java.util.Scanner;

public class Solution_D3_1234_비밀번호 {

	static int N;
	static String[] s;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for (int t = 1; t <= 10; t++) {
			N = sc.nextInt();
			s = sc.next().split("");
			LinkedList<Integer> list = new LinkedList<>();
			for (int i = 0; i < N; i++) {
				list.add(Integer.parseInt(s[i]));
			}
			boolean in = false;
			while (true) {
				for (int i = 0; i < list.size() - 1; i++) {
					if (list.get(i) == list.get(i + 1)) {
						in = true;
						list.remove(i);
						list.remove(i);
					}
				}
				if (!in)
					break;
				in = false;
			}
			System.out.print("#" + t + " ");
			for (int i = 0; i < list.size(); i++) {
				System.out.print(list.get(i));
			}
			System.out.println();
		}
	}

}
