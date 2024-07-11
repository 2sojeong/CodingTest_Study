def solution(n):
    answer = 0
    a=[]
    while n>=3:
        a.append(n%3)
        n=n//3 
    if n<3:
        a.append(n%3)
    
    print(a)
    a.reverse()
    b=len(a)
    print(a)

    for i in range(b):
        answer=answer+((3**i)*int(a[i]))

    return answer