import usecsv,re

apt = usecsv.switch(usecsv.opencsv('apt_202109.csv', 'UTF-8'))
print(apt[:3])
print('-'*3)

# 9월 한 달간 아파트 거래 건수
print(len(apt))
print('-'*3)

# 처음 5개 데이터의 시군구만 출력
for i in apt[:6]:
    print(i[0])
print('-'*3)

# 처음 5개 데이터의 시군구, 단지명, 거래금액 출력
for i in apt[:6]:
    print(i[0],i[4],i[-5])
print('-'*3)

# 강원도에서 전용면적 120 이상, 거래금액 3억 원 이하 검색
for i in apt:
    try:
        if re.match('강원',i[0]) and i[5]>=120 and i[-5]<=30000:
            print(i[0],i[4],i[-5])
    except:
        pass
print('-'*3)

# 검색 결과를 csv 파일로 저장
new_list = []
for i in apt:
    try:
        if re.match('강원',i[0]) and i[5]>=120 and i[-5]<=30000:
            new_list.append([i[0],i[4],i[-5]])
    except:
        pass
usecsv.writecsv('apt.csv', 'UTF-8', new_list)