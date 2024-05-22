def solution(my_string, n):
    answer = ''
    a=len(my_string)
    b=a-n
    for i in range(b,a):
        answer+=my_string[i]
    return answer