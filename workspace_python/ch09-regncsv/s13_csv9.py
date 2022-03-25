# 건강보험 심사평가원에서 제공하는 데이터
# 약국명, 지역, 주소, 개설일자, 경도, 위도
import usecsv

lines = usecsv.opencsv('pharm_2019.csv', 'UTF-8')

for line in lines[:5]: # 5개 표시
    print(line)
print('-'*3)

# 특정 도시의 특정 약국 검색
for line in lines:
    # 지역, 약국명
    if line[1]=='경주시' and line[0]=='신대원약국':
        # 약국명, 지역, 주소
        print(line[0],line[1],line[2],sep='/')
print('-'*3)

# 최근 5년 이내(2019년 9월 1일 기준) 개설 약국 수
city = '원주시'
recent = 0
count = 0
for line in lines:
    if line[1]==city:
        count += 1 # 원주시의 총 약국 수
        if int(line[3])>20140901:
            recent += 1 # 원주시에서 최근 5년 이내에 개설된 약국 수
print('%s의 약국 수: %d개' % (city,count))
print('2019년 9월 1일 기준 5년 이내 개설된 약국 수 : %d개' % recent)

# 특정 지역 1년간(20100101~20101231) 개설된 약국 목록
# 번호/지역/약국명/경도/위도
print('번호','지역','약국명','경도','위도',sep='/')
number = 1
for line in lines[1:]:
    if('경상북도' in line[2]) and (int(line[3])>=20100101) and (int(line[3])<=20101231):
        print(number,'.',sep='',end='')
        # 지역, 약국명, 경도, 위도
        print(line[1],line[0],line[-2],line[-1],sep='/')
        number += 1
print('-'*3)

# 추출된 약국 목록 정렬하기
# 경기도 용인시 수지구의 약국 목록을 약국명의 오름차순으로 정렬
data = []
# 번호,약국명,주소
print('번호',lines[0][0],lines[0][2],sep=',')
for line in lines[1:]:
    if line[1]=='용인수지구':
        # 약국명,주소
        tmp = '%s/%s' % (line[0],line[2])
        data.append(tmp)
#오름차순 정렬
data.sort()
number = 1
for x in data:
    print('%d. %s' % (number,x))
    number += 1 