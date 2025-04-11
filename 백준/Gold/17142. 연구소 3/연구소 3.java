import java.util.*;
import java.io.*;



public class Main {
	private static int N, M;
	private static int[][] map;
	private static boolean[][] visit;
	private static int answer = Integer.MAX_VALUE;
	private static int[] dx = {0,0,1,-1};
	private static int[] dy = {1,-1,0,0};
	private static boolean[] virusvisit;

	private static ArrayList<int[]> virus = new ArrayList<>();
	private static class Node{
		int x;
		int y;
		int temp;
		
		public Node(int x, int y, int temp) {
			this.x = x;
			this.y = y;
			this.temp = temp;
		}
	}
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		
		map = new int[N][N];

		
		for(int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for(int j = 0; j < N; j++) {
				int temp = Integer.parseInt(st.nextToken());
				map[i][j] = temp;
				
				if(temp == 2) {
					virus.add(new int[] {i,j});
				}
			}
		}
		virusvisit = new boolean[virus.size()];
		bt(0,0);
		if(answer == Integer.MAX_VALUE) {
			answer = -1;
		}
		System.out.print(answer);
	}
	
	
	private static void bt(int cnt, int start) {
		
		if(cnt == M) {
			visit = new boolean[N][N];
			answer = Math.min(answer,bfs());
			return;
		}
		
		for(int i = start; i < virus.size(); i++) {
			if(!virusvisit[i]) {
				virusvisit[i] = true;
				bt(cnt + 1,i+1);
				virusvisit[i] = false;			
			}
		}
	}
	
	
	private static int bfs() {
		
		Queue<Node> queue = new LinkedList<>();
		
		for(int i = 0; i < virus.size(); i++) {
			if(virusvisit[i]) {
				int[] v = virus.get(i);
				queue.add(new Node(v[0],v[1],0));
			}
		}
	
		int max = 0;
			while(!queue.isEmpty()) {
				Node temp = queue.poll();

				for(int d = 0; d < 4; d++) {
					int nx = temp.x + dx[d];
					int ny = temp.y + dy[d];
					
					
					if(check(nx,ny)) {
						visit[nx][ny] = true;
						queue.add(new Node(nx,ny,temp.temp + 1));
						if(map[nx][ny] == 0) {
							max = Math.max(max, temp.temp+1);
						}
					}
				}
			}
	
					
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				if(map[i][j] == 0 && !visit[i][j]) {
					return Integer.MAX_VALUE;
				}
			}
		}
		return max;

	}
	
	
	private static boolean check(int x, int y) {
		return x >= 0 && x < N && y >= 0 && y < N && !visit[x][y] && map[x][y] != 1;
	}
}
