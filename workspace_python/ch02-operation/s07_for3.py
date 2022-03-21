a = 2 # 단

for b in range(1,10): # 곱해지는 수
    print('%d * %d = %d' %(a,b,a*b))

print('-'*3)

print('2단 ~ 9단')
for a in range(2,10): # 단
    for b in range(1,10): # 곱해지는 수
        print('%d * %d = %d' %(a,b,a*b))
    print('-'*3)