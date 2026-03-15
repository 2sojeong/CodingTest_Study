n = int(input())

# 상담 기간, 금액 저장
t = [0] * (n + 1)
p = [0] * (n + 1)

# dp[i] = i번째 날부터 퇴사일까지 벌 수 있는 최대 금액
dp = [0] * (n + 2)

# 입력 받기
for i in range(1, n + 1):
    t[i], p[i] = map(int, input().split())

# 뒤에서부터 계산
for i in range(n, 0, -1):
    # i번째 날 상담을 시작했을 때 끝나는 날
    next_day = i + t[i]

    # 퇴사 전에 상담이 끝나는 경우
    if next_day <= n + 1:
        # 1) 상담을 안 하는 경우: 다음 날로 넘어감
        # 2) 상담을 하는 경우: 현재 금액 + 상담 끝난 다음 날부터의 최대 금액
        dp[i] = max(dp[i + 1], p[i] + dp[next_day])
    else:
        # 퇴사일까지 못 끝나면 이 상담은 못 함
        dp[i] = dp[i + 1]

# 1일차부터 시작했을 때의 최대 금액
print(dp[1])