# 제주도 기상 데이터 분석
# 제주, 고산, 성산, 서귀포 네 지역에서 관측된 자료
# 2019년 1월 1일에서 12월 31일까지 각 지역의 일별 최저 기온, 최고 기온, 강수량, 상대 습도 등이 포함
import usecsv

lines = usecsv.opencsv('jeju_2019.csv', 'UTF-8')
newLines = usecsv.switch(lines)

for line in newLines[:5]:
    print(line)
print('-'*3)

# 서귀포시의 1월달의 지점, 일시, 최저 기온 데이터 출력
print(newLines[0][1:4])
for line in newLines:
    # 지점명, 일시 2019-01-01에서 월 정보 추출
    if line[1] == '서귀포' and line[2][5:7] == '01':
        # 지점, 일시, 최저 기온
        print(line[1], line[2], line[3])
print('-'*3)

# 서귀포시의 최저 기온 평균
month = 1
sum = 0
num_day = 0

for line in newLines:
    # 지점명, 일시, 2019-01-01에서 월 정보 추출; '01'을 1로
    if line[1] == '서귀포' and int(line[2][5:7]) == month:
        # 최저 기온 누적
        sum += line[3]
        num_day += 1
avg = sum/num_day
print('%d월의 일 수: %d' % (month,num_day))
print('%d월의 최저 기온 평균: %.1f' % (month,avg))
print('-'*3)

# 8월 지역별 최고 기온
month = 8 # 기준 월
max_jeju = -1000 # 실제 기온 데이터로 대체될 수 있어야하니 확실한 범위 밖 값을 지정
max_sungsan = -1000
max_gosan = -1000
max_suguipo = -1000

for line in newLines:
    # 지점명, 일시
    if line[1] == '제주' and int(line[2][5:7]) == month:
        # 최고 기온
        if line[4] > max_jeju:
            max_jeju = line[4]
    if line[1] == '고산' and int(line[2][5:7]) == month:
        if line[4] > max_gosan:
            max_gosan = line[4]
    if line[1] == '성산' and int(line[2][5:7]) == month:
        if line[4] > max_sungsan:
            max_sungsan = line[4]
    if line[1] == '서귀포' and int(line[2][5:7]) == month:
        if line[4] > max_suguipo:
            max_suguipo = line[4]

print('%d월 제주 최고 기온: %.1f' % (month, max_jeju))
print('%d월 고산 최고 기온: %.1f' % (month, max_gosan))
print('%d월 성산 최고 기온: %.1f' % (month, max_sungsan))
print('%d월 서귀포 최고 기온: %.1f' % (month, max_suguipo))