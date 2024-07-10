def solution(numbers):
    answer = []
    a=len(numbers)
    for i in range(a):
        for j in range(i+1,a):
            answer.append(numbers[i]+numbers[j])
    return sorted(list(set(answer)))