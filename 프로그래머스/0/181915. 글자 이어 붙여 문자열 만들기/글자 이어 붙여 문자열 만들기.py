def solution(my_string, index_list):
    a=list(my_string)
    answer=[]
    for i in index_list:
        answer.append(my_string[i])

    return ''.join(answer)