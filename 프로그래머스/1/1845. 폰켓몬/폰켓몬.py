def solution(nums):
    answer = 0
    a=len(nums)/2
    b=len(set(nums))
    if b>a:
        return a
    else:
        return len(set(nums))