# numpy는 Numerical Python의 약어로, 파이썬에서 데이터 분석과 산술 연산을 하는 데 사용하는 가장 기본적인 패키지 중 하나
import numpy as np

# 다차원을 지원하는 배열 객체(ndarray)를 반환
# np.array() 메서드는 리스트와 같은 배열 형태로부터 ndarray 객체를 생성하는 가장 기본적인 방법
data = np.array([10,20,30,40,50])
print(type(data))
print(data)
print('-'*3)

# .dtype(): 객체 data의 요소들의 데이터형을 반환
print(data.dtype) # int32는 32비트 정수형을 의미
print(data[1])
print('-'*3)

# random.randn() 메서드를 이용하여 2차원(2행 3열)의 실수형 랜덤 수를 생성
data = np.random.randn(2,3)
print(data)

# .shape(): ndarray 객체인 데이터가 몇 행 몇 열로 구성되어 있는지를 반환
print(data.shape)
print(data.dtype)

# zeros(): ndarray 객체 요소 값을 모두 0으로 초기화하여 ndarray 객체를 생성
data1 = np.zeros(10)
print(data1)
print(data1.dtype)
print('-'*3)

data2 = np.zeros((2,3))
print(data2)
print(data2.dtype)
print('-'*3)

data3 = np.zeros((2,3),dtype=np.int32)
print(data3)
print(data3.dtype)
print('-'*3)