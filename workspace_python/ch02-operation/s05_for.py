# for문
# range(끝); 지정한 값 직전까지 출력
for i in range(10):
    print(i,end=' ')

print() # 줄바꿈
print('-'*3)

# range(시작, 끝)
for i in range(1,11):
    print(i,end=' ')

print() # 줄바꿈
print('-'*3)

# range(시작,끝,간격); 간격 양수로 입력시 시작 값에서 간격 값만큼 증가하면서 반복
for i in range(1,10,2):
    print(i, end=' ')

print() # 줄바꿈
print('-'*3)

# range(시작,끝,간격); 간격 음수로 입력시 시작 값에서 간격 값만큼 감소하면서 반복
for i in range(20,0,-2):
    print(i, end=' ')

print() # 줄바꿈
print('-'*3)

# 간격 값 지정하지 않으면 기본값 1이라 시작 값이 끝 값보다 큰 경우에는 반복이 수행되지 않음
for i in range(20,0):
    print(i, end=' ')