class Car:
    cnt = 0
    count = 0 # 특정 객체에 소속되지 않으며 이 클래스로부터 생성되는 모든 객체가 공유
    def __init__(self,name):
        self.name = name
        self.cnt += 1 # 객체 생성시마다 0으로 초기화되는 객체 자신의 변수를 호출
        Car.count += 1 # 모든 객체가 공유하는 클래스 변수를 호출
    def printcnt(self):
        print(self.cnt)
    @classmethod # 클래스 메서드는 특정 객체에 대한 작업을 처리하는 것이 아니라 클래스 전체가 공유; 메서드 앞에 @classmethod 데코레이터를 붙이고 첫 번째 인자로 클래스에 해당하는 cls를 받음
    def outcount(cls):
        print(cls.count)

# 객체 생성
pride = Car('프라이드')
pride.printcnt()
Car.outcount()
print('-'*3)

korando = Car('코란도')
korando.printcnt()
Car.outcount()
print('-'*3)

sonata = Car('소나타')
sonata.printcnt()
Car.outcount()
print('-'*3)