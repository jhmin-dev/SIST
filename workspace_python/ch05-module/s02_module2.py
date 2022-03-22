import math

# 올림
print('math.ceil(12.3): ',math.ceil(12.3))
print('-'*3)

# 버림
print('math.floor(12.7): ',math.floor(12.7))
print('-'*3)

# round()는 math 모듈이 아니라 파이썬 내장 함수
print('round(15.679): ',round(15.679))
print('round(15.679): ',round(15.679,2))
print('-'*3)

# 합계 데이터를 실수형으로 반환
print(math.fsum([1,2,3,4,5]))
print('-'*3)