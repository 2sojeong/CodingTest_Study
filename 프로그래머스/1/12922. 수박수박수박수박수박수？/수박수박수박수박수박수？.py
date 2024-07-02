def solution(n):
    if n%2==0:
        n=n//2
        answer="수박"*n
    else:
        n=n//2
        answer="수박"*n+"수"
    return answer
