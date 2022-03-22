# 아스키 코드 구하기
x = '1'
print('아스키 코드:',ord(x))
print('-'*3)

# 반올림값 구하기
x = round(7.65676)
print(x)
x = round(7.65676,2) # 특정 소수점 자리에서 반올림
print(x)
print('-'*3)

# 절대값 구하기
print(abs(3))
print(abs(-3))
print('-'*3)

# 첫 번째 인자를 두 번째 인자로 나눈 몫과 나머지를 튜플 자료형으로 반환
print(divmod(7,3))
print(divmod(1.3,0.2))
print('-'*3)

# 순서가 있는 자료형(리스트, 튜플, 문자열)을 인자로 받아 인덱스와 값을 추출
for i,name in enumerate(['html','css','js']):
    print(i,name)
print('-'*3)

# 실행 가능한 문자열(1+2, 'hi'+'world' 등)을 인자로 받아 실행한 결과를 반환
print(eval('1+2'))
print(eval("'hi'+'world'"))
print(eval('divmod(4,3)'))
print('-'*3)

# 최댓값
print(max(1,2,3))
print(max([10,20,30]))
print(max('python'))
print('-'*3)

# 최솟값
print(min(1,2,3))
print(min([10,20,30]))
print(min('python'))
print('-'*3)

# sorted(): 리스트, 튜플, 문자열 등 Iterable을 인자로 받아 정렬한 후 그 결과를 리스트로 반환
print(sorted([3,2,4])) # 오름차순
print(sorted((3,2,4), reverse=True)) # 내림차순
print(sorted(['a','c','b']))
print(sorted('zero'))