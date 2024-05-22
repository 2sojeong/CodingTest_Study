def solution(price):
    if 300000>price>=100000:
        price=price*0.95
    if 300000<=price<500000:
        price=price*0.9
    if 500000<=price:
        price*=0.8
    return int(price)