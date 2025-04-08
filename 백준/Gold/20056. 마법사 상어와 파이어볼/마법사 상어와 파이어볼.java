import java.util.*;
import java.io.*;


/*
  1. 이동하는 함수 (d,s)
  2. 이동 후 합쳐지는 함수 
 ----------------------
 	int N = 격자크기
 	int M = 정보
 	int K = 이동수
 	ArrayList<int[]> ballinfo = 볼 정보 [x,y,m,s,d] 
 	int dx[] = 방향 정보
 	int dy[] = 방향 정보
 */

public class Main {
	private static class meteor{
		int x,y,m,s,d;
		public meteor(int x, int y, int m, int s, int d) {
			this.x = x;
			this.y = y;
			this.m = m;
			this.s = s;
			this.d = d;
		}
	}
	private static ArrayList<meteor> ballinfo = new ArrayList<>();
	private static ArrayList<meteor>[][] map;
	private static int N, M, K;
	private static int totalM = 0;
	private static int[] dx = {-1,-1,0,1,1,1,0,-1};
	private static int[] dy = {0,1,1,1,0,-1,-1,-1};
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		map = new ArrayList[N][N];
		
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				map[i][j] = new ArrayList<>();
			}
		}
		
		for(int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(st.nextToken()) - 1;
			int y = Integer.parseInt(st.nextToken()) - 1;
			int m = Integer.parseInt(st.nextToken());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken());
			
			ballinfo.add(new meteor(x,y,m,s,d));

		}
		solve();
	}
	
	
	private static void solve() {
		for(int i = 0; i < K; i++) {
			
				move();
				getSum();
			
		}
		
		
		Total();
	}
	
	/*
	 * 모든 파이어볼은 자신의 방향으로 속력칸 만큼 이동 
	 * int[] ball = 볼 정보 [x,y,m,s,d] 
	 */
	private static void move() {
		for(meteor temp : ballinfo) {
			int nx = (temp.x + N + dx[temp.d] * (temp.s % N)) % N;
			int ny = (temp.y + N + dy[temp.d] * (temp.s % N)) % N;
			
			temp.x = nx;
			temp.y = ny;
			
			map[temp.x][temp.y].add(temp);
		}
	}
	
	/*
	 * 계산하는함수
	 * 
	 */

	private static void getSum() {
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j].size() < 2) {
                    map[i][j].clear();
					continue;
				}
				
				int mSum = 0, sSum = 0, odd = 0, even = 0;
				int size = map[i][j].size();
				
				for(meteor temp : map[i][j]) {
					mSum += temp.m;
					sSum += temp.s;
					
					if(temp.d % 2 == 0) even ++;
					else odd++;
					
					ballinfo.remove(temp);
				}
				
				map[i][j].clear();
				mSum/=5;
				if(mSum == 0) continue;
				sSum/=size;
				if(odd == size || even == size) {
					for(int a = 0; a < 8 ; a+=2) {
						ballinfo.add(new meteor(i,j,mSum,sSum,a));
					}
				}
				else {
					for(int a = 1; a < 8; a+=2) {
						ballinfo.add(new meteor(i,j,mSum,sSum,a));
					}
				}
				
			}
		}
	}
	
	
	private static void Total() {
		int result = 0;
		for(meteor temp : ballinfo) {
			result += temp.m;
		}
		System.out.print(result);
	}
}
