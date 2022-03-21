age = int(input('나이는?'))
# 기본 입장료
ticket = 2000

# 단일 if문
# 65세 이상이면 무료
if age >= 65:
    ticket = 0

print('나이: %d세' % age)
print('입장료: %d원' % ticket)