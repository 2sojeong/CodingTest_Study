def solution(my_string):
    a=list(my_string)
    print(a)
    answer = 0
    for i in a:
        if i=="1" or i=="2" or i=="3" or i=="4" or i=="5" or i=="6" or i=="7" or i=="8" or i=="9":
            answer+=int(i)
    
    return answer