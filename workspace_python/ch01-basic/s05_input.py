# 사용자로부터 값을 입력받을 때는 input 명령을 사용
age = input('몇 살이세요?')
print(age)
print('-'*3)

price = input('가격을 입력하세요:')
num = input('수량을 입력하세요:')
# input으로 입력된 데이터는 문자열로 인식
print(type(price),type(num))

total = int(price)*int(num)
print('총액은',total,'원입니다.')