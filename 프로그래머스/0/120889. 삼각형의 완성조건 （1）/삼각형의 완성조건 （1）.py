def solution(sides):
    a=max(sides)
    print(a)
    sides.remove(a)
    if sum(sides) >a:
        return 1
    else :
        return 2
