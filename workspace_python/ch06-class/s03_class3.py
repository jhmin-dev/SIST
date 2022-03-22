# 클래스 정의
class Person:
    name = 'Default Name' # 클래스 변수
    def printName(self): # 메서드
        print('My Name is {0}'.format(self.name)) # name은 지역 변수 또는 전역 변수를 의미하며, 객체 자신의 변수 name은 self를 통해 접근해야 함

# 객체 생성
p = Person()

print(p.name)
p.printName()
print('-'*3)

p.name = '도로롱'
p.printName()