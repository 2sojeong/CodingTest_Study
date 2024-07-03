def solution(arr):
    a=min(arr)
    if len(arr)==1:
        return [-1]
    arr.remove(a)
    return arr