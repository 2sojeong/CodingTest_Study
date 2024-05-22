def solution(array):
    array.sort()
    a=int(len(array)/2)
    print(a)
    return array[a]