# 상속: 기존 클래스를 확장하여 멤버를 추가하거나 동작을 변경하는 방법
class Human:
    # 생성자
    def __init__(self,age,name):
        self.age = age
        self.name = name
    # 메서드
    def intro(self):
        print(str(self.age) + '세, ' + self.name + '입니다')

class Student(Human): # 클래스 정의시 인자로 전달한 클래스를 상속받음
    def __init__(self,age,name,num):
        super().__init__(age, name)
        self.num = num
    def intro(self): # 메서드 재정의
        super().intro()
        print('학번: ' + str(self.num))
    def study(self):
        print('오늘은 수요일')

a = Human(20,'도로롱')
a.intro()
print('-'*3)

b = Student(22, '도로롱', 1234)
b.intro()
b.study()