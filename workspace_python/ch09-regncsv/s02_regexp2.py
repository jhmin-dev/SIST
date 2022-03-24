import re

# findall(): 패턴을 문자열에서 모두 찾아서 리스트로 반환
number = 'My number is 1234-1*** and yours is 5678-2***'
p = re.findall(r'\d{4}', number)
print(p)
print('-'*3)

example = '17 정유년에 탄핵이 있었습니다. 20년에 총선이 있었습니다. 지금은 2022년입니다.'
# 숫자로 시작하고(\d), 어떤 문자든(.) 최소 1번 이상 반복되며(+), '년'으로 끝나는 문자열 반환
p = re.findall(r'\d.+년',example)
print("r'\d.+년':",p)
print('-'*3)

p = re.findall(r'\d.+?년',example) # 0~1번 사용되면 매치
print("r'\d.+?년':",p)
print('-'*3)

p = re.findall(r'\d+.년',example)
print("r'\d+.년':",p)
print('-'*3)

p = re.findall(r'\d+년',example)
print("r'\d+년':",p)
print('-'*3)

example = 'A는 다음과 같이 설명하였다(A, 2019). 이에 대해 B는 제시된 증거를 인과 관계로 해석하기 어렵다는 점을 지적하였다(B, 2019). 한편 다른 관점에서의 비판도 제기되었다(가나다, 2018).'
result = re.findall(r'\([A-Za-z가-힣]+, \d+\)',example)
print(result)