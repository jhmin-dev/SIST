# pandas는 파이썬에서 데이터 분석을 하는 데 가장 많이 사용되는 패키지
# NumPy는 배열 연산에 특화되어 있다면, pandas는 열과 행으로 구성된 테이블 형태의 데이터를 다루는 데 초점
import pandas as pd

# Series 객체는 1차원 배열의 인덱스와 값으로 구성
obj = pd.Series([5,-4,7,0,10])
print(obj)
print('-'*3)

obj = pd.Series([8,-20,-3,13,2])
# obj 객체의 값 얻기
print(obj.values)
# obj 객체의 인덱스 얻기
print(obj.index)

# 인덱스 2에 해당되는 요소 값 호출
print(obj[2])
print('-'*3)

# 0부터 시작하는 숫자 인덱스 외에 문자열 인덱스를 설정
obj = pd.Series([10,20,30,40,50],index=['a','b','c','d','e'])
print(obj)
print(obj.index)

print(obj['c'])
print('-'*3)

print(obj[['d','a']])
print('-'*3)

print(obj[1:4]) # 내부적으로 숫자 인덱스가 있어서 숫자로도 호출 가능