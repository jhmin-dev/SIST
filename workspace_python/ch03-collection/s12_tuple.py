# 튜플에서는 리스트의 대괄호 대신에 소괄호를 사용
# 튜플에서는 리스트와 달리 요소의 수정과 추가가 불가능
animals = ('토끼', '햄스터', '강아지', '사슴')
print(animals)
print(type(animals))

for i in range(len(animals)): # 튜플의 길이
    print(animals[i])
print('-'*3)

# 인덱스 0번 요소의 값 출력
print(animals[0])
print('-'*3)

# 요소 수정시 에러
# animals[2] = '호랑이'

# tuple() 함수를 이용하여 튜플 생성
# range() 함수를 이용하여 0부터 9(=10 직전)까지의 수 생성 
numbers = tuple(range(10))
print(numbers)
print('-'*3)

print('numbers[0]',numbers[0])
print('numbers[2:5]',numbers[2:5]) # 2부터 4(=5 직전)까지
print('numbers[2:]',numbers[2:]) # 끝 인덱스를 명시하지 않으면 지정한 인덱스부터 튜플의 마지막 요소까지 출력됨
print('numbers[:5]',numbers[:5]) # 시작 인덱스를 명시하지 않으면 튜플의 첫 요소부터 지정한 인덱스 직전까지 출력됨
print('numbers[-2]',numbers[-2]) # 끝에서부터 2번째 요소

# 튜플 합치기
tup1 = (10,20,30)
tup2 = (40,50,60)
tup3 = tup1 + tup2
print(tup3)