package study1003;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_1300_K번째수 {

	static int N,k;
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		k = Integer.parseInt(br.readLine());
		System.out.println(search());
	}
	
	static int search(){
		int s = 1;
		int e = k;
		while(s<=e){
			int mid = (s+e)/2;
			int sum = 0;
			for(int i=1;i<=N;i++){
				sum += Math.min(mid/i, N);
			}
			if(sum == k){
				e = mid-1;
			}else if(sum > k){
				e = mid-1;
			}else{
				s = mid+1;
			}
		}
		return e+1;
	}

}
