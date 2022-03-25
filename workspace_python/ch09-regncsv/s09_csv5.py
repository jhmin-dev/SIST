import usecsv,re

# 2차원 리스트 형태의 csv 정보
total = usecsv.opencsv('popSeoul.csv', 'UTF-8')

for i in total[:5]: # 인덱스 0부터 4까지만
    print(i)
print('-'*3)

i = total[2]
print(i)
print('-'*3)

k = []
for j in i:
    if re.search(r'\d',j): # 문자열의 처음뿐만 아니라 중간부터라도 패턴과 일치하는 부분이 있는지 검색
        k.append(float(re.sub(',','',j))) # re.sub(정규표현식,치환 문자,문자열)
    else:
        k.append(j)
print('숫자 검색',k)
print('-'*3)

k = []
for j in i:
    if re.search('[a-z가-힣!]',j): # 알파벳 소문자, 한글, 특수문자 ! 검색
        k.append(j)
    else:
        k.append(float(re.sub(',','',j)))
print('문자 검색',k)
print('-'*3)

# 예외 처리로 오류를 넘겨서 조건을 단순화함
i = ['123!!','151,767','11,093','27394','','!!!$%']
for j in i: # j는 값 자체이므로 인덱스를 따로 계산해야 함
    try:
        i[i.index(j)] = float(re.sub(',','',j))
    except:
        pass # 일부 코드가 구문상 필요하지만 어떤 작업도 하고 싶지 않은 경우
print(i) # 숫자로 변환 실패한 값들은 그대로 유지됨
print('-'*3)