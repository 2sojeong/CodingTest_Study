#N : 동전 수, K : 동전의 합, A : 동전 가치 
def maxmoney(N,K,A):
    cnt=0
    for m in reversed(range(N)):
        cnt=cnt+K//A[m]
        K=K%A[m]
    return cnt

N,K=map(int,input().split())
A=[]
for i in range(N):
    val=int(input())
    A.append(val)

print(maxmoney(N,K,A))