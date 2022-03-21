# global 명령어를 이용하여 함수 안에서 함수 밖의 a 변수를 직접 사용
a = 1 # 전역 변수

def vartest():
    global a # 전역 변수
    a = a + 1
    print(a)

vartest()
print(a) # 전역 변수 값 변화
print('-'*3)

def func():
    global x # 전역 변수 x가 있으면 x를 읽어옴
    x = 200
    print(x)

x = 100 # 전역 변수
print(x)
func() # 함수 호출
print(x) # 전역 변수 값 변화