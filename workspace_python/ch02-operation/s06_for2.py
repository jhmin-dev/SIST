total = 0

# 100부터 200까지 5씩 증가
for i in range(100,201,5):
    total += i

print('100부터 200까지 5의 배수의 합계: %d' % total)
print('-'*3)

total = 0

for i in range(100,201):
    if i%5 == 0:
        total += i

print('100부터 200까지 5의 배수의 합계: %d' % total)