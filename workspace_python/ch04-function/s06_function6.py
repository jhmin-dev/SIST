# 지역 변수와 전역 변수
# 지역 변수(Local Variable): 변수가 정의된 함수 내에서 사용되는 변수

def func():
    x = 100 # 지역 변수
    print(x)

func()
# 함수 밖에서 지역 변수 호출시 오류
# print(x)
print('-'*3)

# 전역 변수
def func2():
    print(x)

x = 200 # 전역 변수; 함수 호출 전에 선언되어야 함
func2()
print(x)