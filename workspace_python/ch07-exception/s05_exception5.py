# 예외에 대한 정보 전달 받기
def divide(a,b):
    return a/b

try:
    c = divide(5, 'string')
    print(c)
except TypeError as e: # 전달되는 예외 객체를 e로 받아서 사용
    print(type(e.args))
    print('에러:',e.args[0])
except Exception:
    print('error 발생')