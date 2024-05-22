def solution(rsp):
    answer = list(rsp)
    print(answer)
    result=''
    for i in answer:
        if i=='2':
            result=result+'0'
        elif i=='0':
            result=result+'5'
        elif i=='5':
            result=result+'2'
    
    return result