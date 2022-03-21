# 매개변수의 수를 고정하지 않고 호출시 전달되는 인자의 수에 따라 가변적으로 지정하고 싶은 경우 *args 사용
def average(*args): # args는 튜플 자료형
    num_args = len(args)
    sum = 0
    for i in range(num_args): # 반복문을 이용하여 연산
        sum += args[i] # 총점
    avg = sum/num_args # 평균
    print('%d과목 평균: %.1f' % (num_args,avg))

average(85,96,87)
average(77,93,85,97,72)