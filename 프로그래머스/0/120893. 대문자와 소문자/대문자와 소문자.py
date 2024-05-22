def solution(my_string):
    a=list(my_string)
    result=''
    for i in a:
        if i.isupper():
            result+=i.lower()
            print(result)
        if i.islower():
            result+=i.upper() 
    return result