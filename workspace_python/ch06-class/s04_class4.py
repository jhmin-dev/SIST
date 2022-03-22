# 클래스 정의
class Service:
    def sum(self,a,b): # 메서드 정의시 첫 번째 인자는 반드시 self여야 함
        result = a + b # result와 인자는 지역 변수
        print('%s + %s = %s입니다' % (a,b,result)) # 실수, 정수 구분하지 않고 %s로 처리 가능

# 객체 생성
s = Service()
s.sum(1,2)
print('-'*3)

# 클래스 정의
class Lunch:
    name = '도로롱'
    def eat(self,food):
        print('%s님이 %s을(를) 먹습니다' % (self.name,food))

# 객체 생성
a = Lunch()
a.eat('샌드위치')
print('-'*3)