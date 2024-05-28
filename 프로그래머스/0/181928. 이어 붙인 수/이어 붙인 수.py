def solution(num_list):
    a=[]
    b=[]
    for i in num_list:
        if i%2==0:
            a.append(i)
        else:
            b.append(i)
    a=''.join(map(str, a))
    b=''.join(map(str,b))
    
    return int(a)+int(b)