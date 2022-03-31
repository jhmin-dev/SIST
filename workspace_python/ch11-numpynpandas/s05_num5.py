import numpy as np

a = np.arange(10) # 0~9를 요소로 하는 배열 객체 생성
print(a)
print('-'*3)

# 배열 a의 인덱스 3의 요소에 10의 값을 삽입
b = np.insert(a,3,10)
print(a)
print(b)
print('-'*3)

x = np.array([[1,1,1],[2,2,2],[3,3,3]])
print(x)
print('-'*3)

# 배열 x의 열 방향으로 인덱스 1의 요소에 모든 요소 값이 10인 행을 하나 삽입
y = np.insert(x,1,10,axis=0)
print(y)
print('-'*3)

# 배열 x의 행 방향으로 인덱스 1의 요소에 모든 요소 값이 10인 행을 하나 삽입
z = np.insert(x,1,10,axis=1)
print(z)
print('-'*3)