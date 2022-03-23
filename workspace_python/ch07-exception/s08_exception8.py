# 사용자 정의 예외 클래스
class NegativeDivisionError(Exception): # Exception을 상속
    # 생성자
    def __init__(self,value):
        self.value = value

def PositiveDivide(a,b):
    if b<0: # b가 0보다 작은 경우 사용자 정의 예외를 발생시킴
        raise NegativeDivisionError(b)
    return a/b

try:
    a = int(input('첫 번째 수: '))
    b = int(input('두 번째 수: '))
    result = PositiveDivide(a,b)
    print('{1} / {2} = {0}'.format(result,a,b))
except NegativeDivisionError as e:
    print('Error: 두 번째 인자',e.value)
except ZeroDivisionError as e:
    print('Error:',e.args[0])
except: # 그 외의 모든 예외
    print('Error 발생')