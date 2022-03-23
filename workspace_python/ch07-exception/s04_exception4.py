def divide(a,b):
	return a/b

try:
	c = divide(5,2)
except ZeroDivisionError:
	print('0으로 나눌 수 없습니다')
except TypeError:
	print('숫자만 나눌 수 있습니다')
except:
	print('ZeroDivisionError, TypeError를 제외한 다른 에러')
else: # 예외가 발생하지 않는 경우
	print('Result: {0}'.format(c))
finally: # 예외가 발생하건 발생하지 않건 항상 수행
	print('항상 수행됩니다')