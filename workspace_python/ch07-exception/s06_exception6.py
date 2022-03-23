def divide(a,b):
    return a/b

try:
    c = divide(5, 0)
    print(c)
except (ZeroDivisionError,OverflowError): # 명시된 에러를 모두 처리
    print('수치 연산 관련 에러입니다')
except TypeError:
    print('숫자만 나눌 수 있습니다')
except Exception:
    print('error 발생')