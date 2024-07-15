import collections
def solution(answers):
    answer = []
    a=[1,2,3,4,5]
    b=[2,1,2,3,2,4,2,5]
    c=[3,3,1,1,2,2,4,4,5,5]
    arr=len(answers)
    c1,c2,c3=0,0,0
    for i in range(arr):
        s1=i%5
        s2=i%8
        s3=i%10
        print(s1,s2,s3)
        
        if a[s1]==answers[i]:
            c1+=1
        if b[s2]==answers[i]:
            c2+=1
        if c[s3]==answers[i]:
            c3+=1
    k=max(c1,c2,c3)
    if k==c1:
        answer.append(1)
    if k==c2:
        answer.append(2)
    if k==c3:
        answer.append(3)
    return answer