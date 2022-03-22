'''
random 모듈의 함수
random.random(): 0에서 1 사이의 임의의 실수를 반환함
random.uniform(): 주어진 두 수 사이의 임의의 실수를 반환함
random.randint(): 주어진 영역 사이의 임의의 정수를 반환함
random.choice(): 리스트, 튜플, 문자열 등에서 임의로 선택한 요소를 반환함
random.shuffle(): 리스트를 임의의 순서로 섞음
'''
import random

print('random.random(): ',random.random()) # 0부터 1 전까지의 랜덤 수
print('random.random(): ',random.random())
print('-'*3)

print('random.uniform(1,10): ',random.uniform(1,10)) # 1부터 10 직전까지의 랜덤 수
print('random.uniform(1,10): ',random.uniform(1,10))
print('-'*3)

print('random.randint(1,6): ',random.randint(1,6)) # 1부터 6까지의 랜덤 수
print('random.randint(1,6): ',random.randint(1,6))
print('-'*3)

print('random.choice([1,2,3,4,5,6]): ',random.choice([1,2,3,4,5,6]))
print('random.choice("python"): ',random.choice('python'))
print('-'*3)

list1 = [15,23,4,88,7]
print('원래의 리스트: ',list1)
random.shuffle(list1) # list1의 순서를 섞음
print('순서가 변경된 리스트:',list1)
print('-'*3)