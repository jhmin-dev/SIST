import usecsv

lines = usecsv.opencsv('jeju_2019.csv', 'UTF-8')
newLines = usecsv.switch(lines)

# 고산 지역의 7월 최저/최고 습도

month = 7 # 기준 월
min_humidity = 1000 # 실제 값으로 대체 가능하도록 확실히 범위 바깥에 있는 값을 지정 
max_humidity = -1000

for line in newLines[1:]:
    if line[1] == '고산' and int(line[2][5:7]) == month:
        # 최저 습도
        if line[6] < min_humidity:
            min_humidity = line[6]
        # 최고 습도
        if line[6] > max_humidity:
            max_humidity = line[6]

# 고산 지역의 7월 최저, 최고 습도 출력
print('%d월 최저 습도: %.1f' % (month,min_humidity))
print('%d월 최고 습도: %.1f' % (month,max_humidity))