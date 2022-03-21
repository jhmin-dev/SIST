# 함수 정의
def hello():
    print('안녕, 파이썬!')

# 함수 호출
hello() # JavaScript와 달리 호이스팅을 지원하지 않기 때문에 함수를 먼저 정의하고 호출해야 함
print('-'*3)

# 매개변수
def say_hello(name):
    print('안녕, %s!' % name)

say_hello('파이썬')
print('-'*3)

'''
def say_hello(name): # 같은 이름의 함수를 다시 선언하는 경우 오동작 위험이 있음
    print('Hello, %s!' % name)

say_hello('Python')
'''

def sum(a,b):
    return a + b

a = 3
b = 4
c = sum(a, b)
print(c)