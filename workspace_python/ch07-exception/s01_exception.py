# 예외 처리 try~except
try:
    a = 'hello'
    print(a)
    print(a[10]) # 없는 인덱스를 호출하여 인위적으로 예외 발생
    print(a)
except:
    print('error 발생')
print('-'*3)

try:
    a = 'hello'
    print(a)
    print(a[10])
    print(a)
except IndexError: # 발생하는 예외 객체를 명시 가능
    print('error 발생')
print('-'*3)

try:
    a = 'hello'
    print(a)
    print(a[10])
    print(a)
except Exception: # 발생하는 예외 객체의 상위 예외 객체를 명시 가능
    print('error 발생')