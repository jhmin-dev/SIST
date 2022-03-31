import usecsv

lines = usecsv.opencsv('jeju_2019.csv', 'UTF-8')
newLines = usecsv.switch(lines)

# 가장 비가 많이 오는 월을 산출하기 위해 월별 강수량 누적할 리스트 생성
sum_rain = []
for i in range(0,12):
    sum_rain.append(0)

# newLines[0] 항목 제외
for line in newLines[1:]:
    # 강수량이 비어 있는 경우 0으로 대입
    if not line[5]:
        line[5] = 0
    # 월별로 강수량 누적
    for i in range(0,12):
        if int(line[2][5:7]) == i+1:
            sum_rain[i] += line[5]
print(sum_rain)
print('-'*3)

# 최대 강수량
max_month_rain = max(sum_rain)
# 월: 인덱스 + 1로 산출
max_month = sum_rain.index(max_month_rain) + 1
print('(1) 최대 강수 월과 강수량: %d월, %.1f mm' % (max_month, max_month_rain))
print('-'*3)

print('(2) 월별 강수량')
for i in range(0,len(sum_rain)):
    print('%d월: %.1f mm' % (i+1,sum_rain[i]))