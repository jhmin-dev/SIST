import numpy as np

data = np.array([[80,78,90,93],[65,87,88,75],[98,100,68,80]])
# 배열의 합계
print(data.sum())
# 배열의 모든 요소의 평균 값
print(data.mean())
# 최댓값
print(data.max())
# 최솟값
print(data.min())
print('-'*3)

# 각 열(axis=0)의 요소 값 중 최댓값을 구해서 얻은 배열을 반환
print(data.max(axis=0))
# 각 행(axis=1)의 요소 값 중 최댓값을 구해서 얻은 배열을 반환
print(data.max(axis=1))
print('-'*3)

# 배열 객체 data에서 각 열에 대해 요소가 최댓값을 가지는 인덱스 배열 반환
index1 = np.argmax(data,axis=0)
print(index1)
# 배열 객체 data에서 각 행에 대해 요소가 최솟값을 가지는 인덱스 배열 반환
index2 = np.argmin(data,axis=1)
print(index2)