def solution(num_list):
    sum=0
    mul=1
    for i in num_list:
        sum+=i
        mul*=i

    sum=sum**2
    if sum>mul:
        return 1
    else:
        return 0
