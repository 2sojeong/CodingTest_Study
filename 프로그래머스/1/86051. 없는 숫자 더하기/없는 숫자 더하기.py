def solution(numbers):
    answer = -1
    
    a=[1,2,3,4,5,6,7,8,9]
    b=[]
    for i in a:
        if i in numbers:
            continue
        else:
            b.append(i)
    return sum(b)