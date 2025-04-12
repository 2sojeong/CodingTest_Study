import java.util.*;
import java.io.*;

public class Main {
	
	private static int N, M, K;
	private static long[] arr, tree;
	private static class Node{
		int left;
		int right;
		int sum;
		public Node(int left,int right,int sum) {
			this.left = left;
			this.right = right;
			this.sum = sum;
		}
	}
	
	public static void main(String[] args) throws IOException{
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());
		
		arr = new long[N+1];
		tree = new long[N*4];
		StringBuilder sb = new StringBuilder();
		
		for(int i = 1; i <= N; i++) {
			arr[i] = Long.parseLong(br.readLine());
		}
		
		makeTree(1,N,1);
		for(int i = 0; i < M+K; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			long c = Long.parseLong(st.nextToken());
			
			if(a == 1) {
				long dif = c - arr[b];
				arr[b] = c;
				changeNum(1,N,1,b,dif);
			}
			else if(a == 2) {
				sb.append(getSum(1,N,1,b,(int)c)).append("\n");
			}
			
		}
		
		System.out.print(sb);
	}
	
	
	private static long makeTree(int left, int right, int node) {
		if(left == right) {
			return tree[node] = arr[left];
		}
		int mid = (left+right)/2;
		
		return tree[node] = makeTree(left,mid,node*2) + makeTree(mid+1, right, node * 2+1);
	}
	
	private static long getSum(int start, int end, int node, int left, int right) {
		if(left > end || right < start) {
			return 0;
		}
		
		if(left <= start && end <= right) {
			return tree[node];
		}
		
		int mid = (start+end)/2;
		
		return getSum(start,mid,node*2,left,right) + getSum(mid+1, end, node*2+1,left,right);
		
	}
	
	private static void changeNum(int start, int end, int node, int idx, long dir) {
		if(idx < start || idx > end) {
			return;
		}
		
		tree[node] += dir;
		
		if(start == end) {
			return;
		}
		
		int mid = (start + end) /2;
		
		changeNum(start,mid,node*2,idx, dir);
		changeNum(mid+1, end, node*2+1, idx, dir);
	}
	
	
}
