# 클래스 정의
class Person:
    name = 'Default Name'

# 객체 생성
p1 = Person()
p2 = Person()

print('p1.name: ',p1.name)
print('p2.name: ',p2.name)
print('-'*3)

p1.name = '도로롱' # 객체가 생성되면 변수 값은 객체 단위로 관리됨
print('p1.name: ',p1.name)
print('p2.name: ',p2.name)
print('-'*3)

p2.name = 'sleepy'
print('p1.name: ',p1.name)
print('p2.name: ',p2.name)
print('-'*3)