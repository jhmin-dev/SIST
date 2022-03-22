# 클래스 정의
class MyClass:
    # 생성자
    def __init__(self,value):
        self.vale = value
        print('Class is created! Value = ', value)
    # 메서드
    def play(self):
        print('play 메서드')
    # 소멸자
    def __del__(self):
        print('Class is deleted!')

# 객체 생성
a = MyClass(100)
a.play()
a.play()