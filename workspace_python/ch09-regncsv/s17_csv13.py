import usecsv

lines = usecsv.opencsv('jeju_2019.csv', 'UTF-8')
newLines = usecsv.switch(lines)

# 연 강수량을 지역별로 저장할 수 있는 리스트 생성
region = ['제주', '고산', '성산', '서귀포']
total_rain = [0,0,0,0]

for line in newLines[1:]:
    # 강수량이 비어 있는 경우 0 대입
    if not line[5]:
        line[5] = 0
    for i in range(0,4):
        if line[1] == region[i]:
            total_rain[i] += line[5]

# 연 최대 강수량
max_year_rain = max(total_rain)
max_area = region[total_rain.index(max_year_rain)]

print('(1) 연 강수 최대 지역: %s' % max_area)
print('(2) 지역별 강수량')
for i in range(0,4):
    print('%s: %.1f mm' % (region[i], total_rain[i]))