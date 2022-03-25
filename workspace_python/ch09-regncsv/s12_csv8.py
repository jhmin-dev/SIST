# 기상청에서 다운로드받은 기온 데이터 이용
import usecsv,re

print(usecsv.opencsv('month_temp.csv', 'UTF-8'))
print('-'*3)

lines = usecsv.opencsv('month_temp.csv', 'UTF-8')
# 개별 데이터를 모두 출력
for line in lines:
    for x in range(len(line)):
        print(line[x])
print('-'*3)

# 특정 일자 기온 출력
for line in lines:
    if '2019-10-20' in line:
        print(line)

# 일교차 구하기
newLines = usecsv.switch(lines)
print(newLines)
print('-'*3)
for line in newLines[1:]: # 헤더를 제외한 나머지 정보 읽기
    # 최고 기온 - 최저 기온
    diff = line[4]-line[3]
    # 일시, 최저 기온, 최고 기온, 일교차
    print('%s %.1f %.1f %.1f' % (line[1],line[3],line[4],diff))

# 가공된 정보를 csv 파일에 저장
lineSaved = [['일자','최저 기온', '최고 기온', '일교차']]
for line in newLines[1:]:
    diff = format(line[4]-line[3],'.1f')
    lineSaved.append([line[1],line[3],line[4],diff])
usecsv.writecsv('month_temp2.csv', 'UTF-8', lineSaved)
print('csv 파일이 생성되었습니다')