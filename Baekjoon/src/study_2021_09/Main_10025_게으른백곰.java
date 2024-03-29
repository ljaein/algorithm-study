package study_2021_09;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_10025_게으른백곰 {
	static int N, K;
	static int[] arr = new int[1000001];

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		for(int i=0;i<N;i++){
			st = new StringTokenizer(br.readLine());
			int g = Integer.parseInt(st.nextToken());
			int x = Integer.parseInt(st.nextToken());
			arr[x] = g;
		}
		int sum = 0;
		int max = 0;
		int window = 2*K +1;
		int p = 0;
		for(int i=0;i<1000001;i++){
			if(i >= window){
				sum -= arr[i-window];
			}
			sum += arr[i];
			if(sum>max){
				max = sum;
			}
		}
		System.out.println(max);
	}

}
