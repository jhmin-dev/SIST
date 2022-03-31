# 지정한 동네의 인구 구조를 막대 그래프로 표현
import matplotlib.pyplot as plt
from usecsv import opencsv

data = opencsv('age.csv', 'cp949')
result = []
name = '대흥동'

for row in data:
    if name in row[0]:
        if len(result)>0:
            break
        else:
            for i in row[3:]:
                result.append(int(i.replace(',','')))
        name = row[0].split('(')[0]
print(name)

if result:
    # 0세부터 100세 이상까지 101개의 구간
    # plt.bar(range(101),result) # 수직 막대 그래프
    plt.barh(range(101),result) # 수평 막대 그래프
    plt.show() # 화면에 출력
else:
    print('데이터가 없습니다.')