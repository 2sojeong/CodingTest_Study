def solution(cipher, code):
    a=list(cipher)
    answer = ''
    for i in range(code-1,len(a),code):
        print(a[i])
        answer+=a[i]
    return answer