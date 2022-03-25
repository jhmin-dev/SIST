import usecsv

total = usecsv.opencsv('popSeoul.csv', 'UTF-8')
newPop = usecsv.switch(total)
for i in newPop[:4]:
    print(i)
print('-'*3)

i = newPop[1]
print(i)
print('-'*3)

print(i[2]/(i[1]+i[2])*100) # 전체 인구 대비 외국인 비율 계산
foreign = round(i[2]/(i[1]+i[2])*100,1) # 소수점 이하 둘째 자리에서 반올림
print(foreign)
print('-'*3)

# 각 구의 외국인 비율 구하기
for i in newPop:
    foreign = 0
    try:
        foreign = round(i[2]/(i[1]+i[2])*100,1)
    except:
        pass
    print(i[0],foreign)

# 첫 행 지정하기
new = [['구', '한국인', '외국인', '외국인 비율']]
print(new)
print('-'*3)

# 외국인 비율이 3%를 초과하는 구 정보만 csv 파일로 저장
for i in newPop:
    foreign = 0
    try:
        foreign = round(i[2]/(i[1]+i[2])*100,1) # 외국인 비율을 소수점 이하 첫째 자리까지 구하기
        if foreign>3:
            new.append(i[:3]+[foreign])
    except:
        pass
print(new)
print('-'*3)
usecsv.writecsv('foreignrate.csv', 'UTF-8', new)