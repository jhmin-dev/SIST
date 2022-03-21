i = 'string'
print(i,type(i))
print('---')

print("This is 'string'")
print('---')

print('py' + 'thon')
print('---')

# 문자열끼리는 + 연산자 생략 가능하며, 문자열 사이 공백도 생략 가능
print('py' 'thon')
print('py''thon')
print('---')

# 문자열에 숫자를 곱하면 문자열을 반복
print('py'*10)
print('-'*3)
"""
여러 줄
주석
"""
# print() 내에 """ 사용시 줄바꿈이나 탭도 그대로 적용되며, 이스케이프 문자 사용 가능
print("""
    하늘        바다
    우주
""")
print('\t탭\n다음 줄')
print('-'*3)

# 이스케이프 문자 무력화
# 파이썬에서는 문자열 앞에 r을 붙여서 이스케이프 문자가 적용되지 않도록 처리
print(r'\t탭\n다음 줄')