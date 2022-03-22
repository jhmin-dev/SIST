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

a = Student(20,'도로롱',1234)
a.intro()