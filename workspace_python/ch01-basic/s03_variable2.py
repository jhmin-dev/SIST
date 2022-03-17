# 변수명은 대소문자를 구분하고 숫자로 시작 불가
# 특수문자와 공백은 변수명에 사용할 수 없음
friend = 5
Friend = 6
print(friend,Friend)
print('---')

# 출력시 공백이 아닌 다른 문자를 구분자로 사용하고 싶은 경우 sep 인수에 원하는 문자를 지정
print(friend,Friend,sep=",")