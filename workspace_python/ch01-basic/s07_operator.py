a = 5 + 3 * 2
print(a)
print('-'*3)

# / 연산의 경우 정수 간 나눗셈이라도 결과값으로 실수 가능
d = 15/4
print(d)
print(type(d))
print('-'*3)

# 소수점 이하 절사 연산자
e = 15//4
print(e,type(e))
print('-'*3)

# 나머지 연산자
f = 10%3
print(f,type(f))
print('-'*3)

# 대입 연산자
a = 3
print(a)
print('-'*3)

# 복합 대입 연산자; 증감 연산자는 지원하지 않음
a += 1
print(a)
print('-'*3)

a -= 2
print(a)