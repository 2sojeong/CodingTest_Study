def solution(strings, n):
    answer = list(strings)
    answer.sort()
    return sorted(answer, key=lambda x : x[n])
    