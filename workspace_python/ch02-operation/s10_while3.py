coffee = 10
while True:
    money = int(input('돈을 넣어주세요:'))
    if money == 300:
        print('커피를 줍니다.')
        coffee -= 1
    elif money > 300:
        print('거스름돈 %d원을 주고, 커피를 줍니다.' % (money-300))
        coffee -= 1
    else:
        print('돈을 다시 돌려주고, 커피를 주지 않습니다.')

    # coffee가 0이면 False로 인식
    if not coffee:
        print('커피가 다 떨어졌습니다. 판매를 중지합니다.')
        break