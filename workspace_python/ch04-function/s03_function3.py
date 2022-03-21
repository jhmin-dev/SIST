# 반환하는 값이 있는 경우
def say():
    return 'Hi'

a = say()
print(a)
print('-'*3)

# 반환하는 값이 없는 경우
def sum(a,b):
    print('%d, %d의 합은 %d입니다' % (a,b,a+b)) # 인자로 실수를 전달하더라도 정수로 출력
    print('{0}, {1}의 합은 {2}입니다'.format(a,b,a+b))

sum(3.5,4.3)
# sum(3) # missing argument 에러