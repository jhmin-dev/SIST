import numpy as np

# 2차원 배열 생성
data = np.array([[1,2,3,4,5],[6,7,8,9,10],[11,12,13,14,15]])
print(data)
print('-'*3)

print(data[2][3])
print('-'*3)

print(data[0][1:])
print('-'*3)

print(data[0])
print('-'*3)

# data[[1,2]]는 data에서 인덱스 1,2인 행의 데이터 값을 가짐
print(data[[1,2]])
print('-'*3)

# data[1]은 인덱스 1의 행 데이터를 의미
data[1] = 100
print(data)
print('-'*3)

# data[:]은 data의 모든 요소를 의미
data[:] = 200
print(data)