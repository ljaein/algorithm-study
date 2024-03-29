package study0403;

import java.util.LinkedList;
import java.util.Scanner;

public class Main_2660_회장뽑기 {

	static int N;
	static int[][] adj;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		adj = new int[N][N];
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (i != j)
					adj[i][j] = 987654321;
			}
		}
		while (true) {
			int a = sc.nextInt() - 1;
			int b = sc.nextInt() - 1;
			if (a == -2 && b == -2)
				break;
			adj[a][b] = 1;
			adj[b][a] = 1;
		}
		for (int k = 0; k < N; k++) {
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					if (adj[i][j] > adj[i][k] + adj[k][j])
						adj[i][j] = adj[i][k] + adj[k][j];
				}
			}
		}

		int[] score = new int[N];
		int min = Integer.MAX_VALUE;
		for (int i = 0; i < N; i++) {
			int max = 0;
			for (int j = 0; j < N; j++) {
				if(i==j)
					continue;
				max = Math.max(max, adj[i][j]);
			}
			score[i]=max;
			min = Math.min(min, score[i]);
		}
		int cnt = 0;
		LinkedList<Integer> list = new LinkedList<>();
		for(int i=0;i<N;i++){
			if(score[i]==min){
				cnt++;
				list.add(i+1);
			}
		}
		System.out.println(min +" "+cnt);
		for(int i : list)
			System.out.print(i+" ");
	}

}
