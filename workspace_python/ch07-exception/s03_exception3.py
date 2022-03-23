def divide(a,b):
    return a/b

try:
    c = divide(5, 'apple')
    print(c)
except Exception: # 모든 예외를 여기서 처리하게 됨; Java와 달리 상위 예외 객체를 먼저 명시해도 동작은 하지만 이후의 except 블럭이 무의미해짐
    print('무슨 에러인지 모르겠어요')
except ZeroDivisionError:
    print('0으로 나누면 안 돼요')
except TypeError:
    print('숫자만 나눌 수 있어요')