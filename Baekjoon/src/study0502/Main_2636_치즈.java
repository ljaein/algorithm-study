package study0502;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636_치즈 {

	static int N, M, cnt, ans, time;
	static int[][] map;
	static int[] dy = {-1,0,1,0};
	static int[] dx = {0,1,0,-1};
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		map = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
				if(map[i][j]==1)
					cnt++;
			}
		}
		while(cnt!=0){
			time ++;
			ans = cnt;
			bfs();
			if(cnt==0)
				break;
		}
		System.out.println(time);
		System.out.println(ans);
		
	}
	
	static void bfs(){
		Queue<Point> q = new LinkedList<>();
		boolean visit[][] = new boolean[N][M];
		visit[0][0]=true;
		q.add(new Point(0,0));
		while(!q.isEmpty()){
			Point cur=q.poll();
			for(int d=0;d<4;d++){
				int ny = cur.y+dy[d];
				int nx = cur.x+dx[d];
				if(ny<0||nx<0||ny>=N||nx>=M||visit[ny][nx])
					continue;
				if(map[ny][nx]==0){
					visit[ny][nx]=true;
					q.add(new Point(ny,nx));
				}else if(map[ny][nx]==1){
					cnt--;
					visit[ny][nx]=true;
					map[ny][nx]=0;
				}
			}
		}
	}
	
	static class Point{
		int y, x;

		public Point(int y, int x) {
			this.y = y;
			this.x = x;
		}
		
	}
}
