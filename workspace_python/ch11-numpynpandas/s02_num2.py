import numpy as np

# 8개의 요소의 값이 모두 1인 일차원 실수형 ndarray 객체 생성
data1 = np.ones(8)
print(data1)
print(data1.dtype)
print('-'*3)

# np.arange(10,121,10): 시작, 끝(끝 직전 값까지만 증가), 증가 간격을 지정
data = np.arange(10,121,10) # 10부터 120까지, 10씩 증가
print(data)
print(data.dtype)
print(data[2])
print(data[5:8]) # 인덱스 5부터 7까지 출력
print('-'*3)

data[7:10] = 800 # 인덱스 7부터 9에 800을 저장
print(data)
print('-'*3)

# data.reshape(2,6): ndarray 객체 data를 2행 6열로 재구성
data2 = data.reshape(2,6)
print(data2)