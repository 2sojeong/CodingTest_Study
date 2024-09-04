def solution(a, b, n):
    answer = 0
    while n>=a:
        count= n//a *b
        left=n%a
        answer+=count
        n=left+count
    return answer