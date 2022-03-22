# 클래스 정의
class Service: # Java와 달리 접근 제한자가 없음
    name = '도로롱' # 클래스 변수

# 객체 생성
test = Service()
print(test)
print('-'*3)

print(test.name) # .으로 하위 요소 접근
print('-'*3)

test.name = 'sleepy' # 값 변경
print(test.name)