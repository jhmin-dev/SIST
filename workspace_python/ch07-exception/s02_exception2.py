def divide(a,b):
    return a/b

# try~except
try:
    c = divide(5,'string')
    print(c)
except ZeroDivisionError:
    print('두 번째 인자는 0이면 안 됩니다')
except TypeError:
    print('모든 인자는 숫자여야 합니다')
except:
    print('error 발생')