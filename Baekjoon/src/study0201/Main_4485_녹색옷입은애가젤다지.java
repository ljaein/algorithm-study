package study0201;

import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class Main_4485_녹색옷입은애가젤다지 {

	static int N, T;
	static int[][] map, min;
	static boolean[][] visited;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		while (true) {
			N = sc.nextInt();
			if (N == 0)
				break;
			map = new int[N][N];
			min = new int[N][N];
			for(int i=0;i<N;i++){
				for(int j=0;j<N;j++){
					min[i][j]=Integer.MAX_VALUE;
				}
			}
			for (int i = 0; i < N; i++) {
				for (int j = 0; j < N; j++) {
					map[i][j] = sc.nextInt();
				}
			}
			visited = new boolean[N][N];

			int cy = 0;
			int cx = 0;

			int[] dy = { -1, 0, 1, 0 };
			int[] dx = { 0, 1, 0, -1 };
			
			Queue<Point> pq = new LinkedList<>();
			min[cy][cx]=map[cy][cx];
			pq.add(new Point(cy,cx,min[cy][cx]));
			visited[cy][cx]=true;
			while(!pq.isEmpty()){
				Point cur = pq.poll();
				for(int i=0;i<4;i++){
					int ny = cur.y+dy[i];
					int nx = cur.x+dx[i];
					if(ny<0 || nx<0 || ny>=N ||nx>=N)
						continue;
					if(visited[ny][nx])
						continue;
					min[ny][nx]=Math.min(min[ny][nx], cur.n+map[ny][nx]);
					pq.add(new Point(ny,nx,min[ny][nx]));
					visited[ny][nx]=true;
				}
			}
			System.out.println("Problem "+(++T)+": "+min[N-1][N-1]);
			
		}
	}

	static class Point implements Comparable<Point> {
		int y, x, n;

		public Point(int y, int x, int n) {
			this.y = y;
			this.x = x;
			this.n = n;
		}

		@Override
		public int compareTo(Point p) {
			// TODO Auto-generated method stub
			if(this.n>p.n)
				return 1;
			else if(this.n<p.n)
				return -1;
			return 0;
		}
	}

}
