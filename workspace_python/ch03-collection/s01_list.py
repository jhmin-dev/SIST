# 리스트
# 값들의 나열 순서가 존재하며, 여러 종류의 값을 담을 수 있음
# 인덱스는 0부터 시작
# 값을 추가, 변경, 삭제 가능
colors = ['빨강', '주황', '노랑', '초록', '파랑', '남색', '보라']

print(colors[0])
print(colors[5])
# 인덱스 2부터 5(=6 직전)까지의 요소로 구성된 리스트
print(colors[2:6])
# 인덱스를 음수로 지정하면 역순으로 찾음
print(colors[-3])
# 끝에서 4번째부터 끝에서 2번째까지의 요소로 구성된 리스트
print(colors[-4:-1])
print('-'*3)

colors2 = ['red', 'green', 'gold']
print(colors2)
print(type(colors2))