# 전역 변수
from pip._vendor.typing_extensions import Self
str = 'NOT Class Member'

# 클래스 정의
class GString:
    str = '' # 클래스 변수
    def setStr(self,msg):
        self.str = msg # 클래스 변수의 값을 변경
    def print(self):
        print(self.str) # 클래스 변수를 출력
        print(str) # 전역 변수를 출력

# 객체 생성
g = GString()
g.setStr('First Message')
g.print()