a = 0
# print(10/a) # 0으로 나누면 에러 발생

# if~else문
if a!=0 and 10/a: # and 연산자에서 선건이 거짓이면 후건은 검사/실행되지 않음
    print('a가 %d입니다.' % a)
else:
    print('에러 없이 통과!')

print('-'*3)

# 단축 평가
if a and 10/a: # 값이 0이면 false로 인식
    print('a가 %d입니다.' % a)
else:
    print('에러 없이 통과!')