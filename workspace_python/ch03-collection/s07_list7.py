# 문자열과 리스트
string1 = 'Python is fun!'
print(string1)
print('-'*3)

# find(): string1에서 'fun'이 처음으로 등장하는 위치(=인덱스)를 반환
x = string1.find('fun')
print(x)
print('-'*3)

string2 = '사과는 맛있다. 나는 사과를 제일 좋아한다.'
print(string2)
print('-'*3)

x = string2.replace('사과', '딸기')
print(x)
print('-'*3)

hello = 'have a nice day'
print(hello)
print('-'*3)

list1 = hello.split(' ')
print(type(list1))
for i in range(0,len(list1)):
    print('list1[%d]: %s' % (i,list1[i]))