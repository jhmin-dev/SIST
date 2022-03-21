colors = ['빨강', '주황', '노랑', '초록', '파랑']

# 반복문을 이용한 출력
for color in colors:
    print('나는 %s색을 좋아한다' % color)
print('-'*3)

# range() 함수 이용하기
n = len(colors) # len() 함수 : 리스트의 길이 반환
for i in range(0,n):
    print('나는 %s색을 좋아한다' % colors[i])
print('-'*3)

# while문에서 리스트 사용
animals = ['토끼', '강아지', '호랑이', '사슴', '곰', '독수리', '햄스터']
i = 0
while i < len(animals):
    print(animals[i])
    i += 1