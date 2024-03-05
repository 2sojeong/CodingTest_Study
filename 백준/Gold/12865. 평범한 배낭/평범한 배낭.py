import sys


#k : 배낭 무게 한도,wt: 각 물건의 무게, val: 각 물건의 가치, N: 물건의 수
def knapsack(K, wt, val, N):
     result = [[0 for x in range(K+1)] for x in range(N+1)]
     for i in range(N+1): 
         for j in range(K+1):
             if i==0 or j==0: #0번째 행렬은 0
                 result[i][j]=0
             elif wt[i-1]<=j:
                 result[i][j]=max(val[i-1]+result[i-1][j-wt[i-1]],result[i-1][j])
             else:
                 result[i][j]=result[i-1][j]
     return result[N][K]

            
wt = []
val = []
N,K =map(int,input().split())
for i in range(N): 
    w,v=map(int,input().split())
    wt.append(w)
    val.append(v)

print(knapsack(K, wt, val, N))