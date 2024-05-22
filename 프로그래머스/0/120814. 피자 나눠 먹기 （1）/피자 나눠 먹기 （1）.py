def solution(n):
    answer=0
    c=0
    if n<=7:
        c=1
    if n>7:
        while answer<n:
            answer+=7
            c+=1
    return c