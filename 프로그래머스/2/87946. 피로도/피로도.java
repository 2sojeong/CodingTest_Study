import java.util.*;
import java.io.*;

class Solution {
    static boolean[] check = new boolean[5000];
    static int[] route;
    static int[] arr;
    static int answer = -1;
    public int solution(int k, int[][] dungeons) {
        
        route = new int[dungeons.length];
        arr = new int[dungeons.length];
        
        for(int i = 0; i < route.length; i++){
            route[i] = i;
        }
        
        dfs(route,0,arr,k,dungeons);
        return answer;
    }
    
    static void dfs(int[] route, int n, int[] arr, int k, int[][] dungeons){
        if(n == route.length){
            // for(int i = 0; i < arr.length; i++){
            //     System.out.print(arr[i]+" ");
            // }
            
            int res = count(arr,dungeons,k);
            // System.out.println(" count = "+res);
            answer = Math.max(answer,res);
            return;
        }
        
        for(int i = 0; i < route.length; i++){

            if(!check[i]){
                check[i] = true;
                arr[n] = i;
                dfs(route,n+1,arr,k,dungeons);
                check[i] = false;
                arr[n] = 0;
            }
        }
    }
    
    static int count(int[] arr, int[][] dungeons, int k){
        int cnt = 0;
        for(int i = 0; i < arr.length; i++){
            if(k >= dungeons[arr[i]][0]){
                k -= dungeons[arr[i]][1];
                cnt ++;
            }
        }
        return cnt;
    }
}