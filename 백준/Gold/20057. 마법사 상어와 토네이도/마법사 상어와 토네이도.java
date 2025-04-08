import java.io.*;
import java.util.*;


public class Main {
	private static int[] dx = {0,1,0,-1};
	private static int[] dy = {-1,0,1,0};
	
	private static int[] per = {1,1,2,2,5,7,7,10,10,0};
	static int[][] sdx = {
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{1,1,0,0,-2,0,0,-1,-1,-1}
	};

	static int[][] sdy = {
			{1,1,0,0,-2,0,0,-1,-1,-1},
			{-1,1,-2,2,0,-1,1,-1,1,0},
			{-1,-1,0,0,2,0,0,1,1,1},
			{-1,1,-2,2,0,-1,1,-1,1,0}
	};
	
	private static int[][] map;
	private static int N;
	private static int ans = 0;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}
		
		solve();
		System.out.print(ans);

	}
	
	private static void solve() {
		int[] changeDir = {1,1,2,2};
		int x = N/2;
		int y = N/2;
		double ySand;
		while(true) {
			for(int i = 0; i < 4; i++) {
				for(int j = 0; j < changeDir[i]; j++) {
					x += dx[i];
					y += dy[i];
					
					 ySand = map[x][y];
					
					if(ySand > 0) {
						spread(x,y,i,ySand);
						
					}
					if(x == 0 && y ==0) {
						return;
					}
				}
			}
			
			for(int i = 0; i < 4; i++) {
				changeDir[i] += 2;
			}
		}
	}
	
	
	private static void spread(int x, int y, int dir, double ysand) {
		int nx, ny;
		double spreadSands = 0;
		
		map[x][y] = 0;
		for(int i = 0; i < 10; i++) {
			nx = x + sdx[dir][i];
			ny = y + sdy[dir][i];
			
			int sand = (int)Math.floor(ysand / 100 * per[i]);
			
			if(i==9) {
				double aSand = ysand - spreadSands;
				
				if(!check(nx,ny)) {
					ans += aSand;
				}
				else {
					map[nx][ny] += aSand;
				}
			}
			else {
				if(!check(nx,ny)) {
					ans += sand;
				}
				else {
					map[nx][ny] += sand;
				}
				spreadSands += sand;
			}
		}
	}
	
	private static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N;
	}

}
	