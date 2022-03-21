value = 10
# 단일 if문
if value > 5:
    print('value is greater than 5')

print('-'*3)

money = 10
# if~else문
if money > 100:
    item = 'apple'
else:
    item = 'chocolate'

print(item)
print('-'*3)

# 삼항 연산자
# 참인 경우의 값 if 조건 else 거짓인 경우의 값
item2 = '사과' if money > 100 else '초코'
print(item2)