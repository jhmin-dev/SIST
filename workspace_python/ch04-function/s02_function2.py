def even_odd(n):
    if n%2 == 0:
        print('%d은(는) 짝수입니다' % n)
    else:
        print('%d은(는) 홀수입니다' % n)

x = int(input('정수를 입력하세요:'))
even_odd(x)