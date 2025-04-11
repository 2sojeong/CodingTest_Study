import java.util.*;
import java.io.*;


public class Main {
	
	private static int time = 0;
	private static int eat = 0;
	private static int sharkSize = 2;
	private static int fishCnt = 0;
	private static int[][] map;
	private static int N;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static boolean[][] visit;
	private static PriorityQueue<Fish> fishIdx = new PriorityQueue<>();
	private static class Shark{
		int x;
		int y;
		int size;
		int time;
		public Shark(int x, int y, int size, int time) {
			this.x = x;
			this.y =y;
			this.size = size;
			this.time = time;
		}
	}
	
	private static class Fish implements Comparable<Fish>{
		int x;
		int y;
		int dist;
		
		public Fish(int x, int y, int dist){
			this.x = x;
			this.y = y;
			this.dist = dist;
		}
		
		@Override
		public int compareTo(Fish o) {
			if(this.dist == o.dist) {
				if(this.x == o.x) return this.y - o.y;
				return this.x - o.x;
			}
			return this.dist - o.dist;
		}
		
	}
	private static Shark shark;
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		N = Integer.parseInt(br.readLine());
		
		map = new int[N][N];
		visit = new boolean[N][N];
		
		StringTokenizer st;
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				if(temp != 0 && temp != 9) {
					fishCnt ++;
				}
				if(temp == 9) {
					shark = new Shark(i,j,2,0);
					map[i][j] = 0;
				}
			}
		}
		
		while(true) {
			countFish(shark.x, shark.y);
			if(fishIdx.isEmpty()) break;
			moveShark();
		}
		
		
	System.out.print(shark.time);
	}
	

	
	/*
	 * 	인접한 상어 수 세는 함수  
	 */
	private static void countFish(int x, int y) {
	
		Queue<int[]> queue = new LinkedList<>();
		queue.add(new int[] {x,y,0});
		visit = new boolean[N][N];
		visit[x][y] = true;
		
		while(!queue.isEmpty()) {
			int[] temp = queue.poll();
			
			for(int i = 0; i < 4; i++) {
				int nx = temp[0] + dx[i];
				int ny = temp[1] + dy[i];
				
				if(nx >= 0 && ny >= 0 && nx < N && ny < N && !visit[nx][ny] && map[nx][ny] <= shark.size) {
				
						visit[nx][ny] = true;
						queue.add(new int[] {nx,ny,temp[2]+1});

	                    if (map[nx][ny] < shark.size && map[nx][ny] != 0) {
	                        fishIdx.add(new Fish(nx, ny, temp[2] + 1));
	                    }
					
					
				}
			}
		}
		
		
	}
	
	private static void moveShark() {
			Fish temp = fishIdx.poll();
			map[shark.x][shark.y] = 0;
			shark.x = temp.x;
			shark.y = temp.y;
			map[shark.x][shark.y] = 9;
			eat ++;
			
			if(eat == shark.size) {
				shark.size ++;
				eat = 0;
			}

			shark.time += temp.dist;

			fishIdx.clear();
	}
}
