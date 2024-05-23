def solution(my_string, is_suffix):

    a=len(is_suffix)
    b=list(my_string)
    c=list(is_suffix)
    d=my_string[-a:]
    if d==is_suffix:
        return 1
    else:
        return 0
