# 함수 안에서 선언된 변수의 효력 범위
a = 1 # 전역 변수

def vartest(a): # a는 함수 내에서만 호출할 수 있는 지역 변수
    a = a + 1
    print(a)

vartest(a) # 전역 변수 a의 값 1을 지역 변수 a에 전달하여 지역 변수 a의 값을 가공
print(a) # 전역 변수 a의 값은 변화하지 않음