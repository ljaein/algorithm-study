package study0601;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;

public class Main_1599_민식어 {

	public static void main(String[] args) throws NumberFormatException, IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int N = Integer.parseInt(br.readLine());
		String[] word = new String[N];
		PriorityQueue<Point> pq = new PriorityQueue<>();
		for(int i=0;i<N;i++){
			String s = br.readLine();
			word[i]=s;
            s = change(s);
			pq.add(new Point(s,i));
		}
        while(!pq.isEmpty()){
            int idx = pq.poll().n;
            System.out.println(word[idx]);
        }

	}
    static String change(String s){
        s = s.replace("ng","0");
        String res = "";
        for(int i=0;i<s.length();i++){
            if(s.charAt(i)=='k'){
                res += "c";
            }else if(s.charAt(i)>='o'){
            	res += (char)(s.charAt(i)+1)+"";
            }
            else
                res+=s.substring(i,i+1);
        }
        res = res.replace("0","o");
        return res;
    }
	
	static class Point implements Comparable<Point>{
		String w;
		int n;
		public Point(String w, int n){
			this.w=w;
			this.n=n;
		}
        public int compareTo(Point p){
            return this.w.compareTo(p.w);
        }
	}

}