package study0303;

import java.util.Arrays;
import java.util.Scanner;

public class Main_11053_가장긴증가하는부분수열 {

	static int N;
	static int[] arr, len;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		for (int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		len = new int[N];
		for(int i=0;i<N;i++)
			len[i]=1;
		for (int i = 1; i < N; i++) {
			for (int j = 0; j < i; j++) {
				if (arr[j] < arr[i])
					len[i] = Math.max(len[i], len[j] + 1);
			}
		}
		Arrays.sort(len);
		System.out.println(len[N - 1]);
	}

}
