def solution(hp):
    answer=0
    a=hp
    a=a//5
    answer+=a
    hp=hp%5
    print(answer)
    a=hp//3
    answer+=a
    hp=hp%3
    print(answer)
    answer+=hp
    hp=hp%1
    print(answer)
    return answer