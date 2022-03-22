# 클래스 정의
class Service:
    # 파이썬은 객체의 생성과 변수의 초기화를 동시에 진행할 수 있는 생성자를 제공
    def __init__(self,name):
        self.name = name
    def sum(self,a,b):
        result = a + b
        print('%s님 %s + %s = %s입니다' % (self.name,a,b,result))

# 객체 생성
s = Service('도로롱')

# 객체의 메서드 호출
s.sum(1,2)
print('-'*3)

s.name = 'sleepy'
s.sum(10,20)