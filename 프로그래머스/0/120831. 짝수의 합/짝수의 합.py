def solution(n):
    answer=0
    n=n+1
    for i in range(n):
        if i%2==0:
            print(i)
            answer=answer+i
    return answer