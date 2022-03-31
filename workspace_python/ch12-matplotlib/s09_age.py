# www.mois.go.kr
# 정책 자료>통계>주민등록 인구 통계>연령별 인구 현황
# 인구 정보를 지역별로 0세부터 100세 이상까지 제공
import matplotlib.pyplot as plt
from usecsv import opencsv

data = opencsv('age.csv', 'cp949')
result = []
name = input('인구 구조를 조회할 지역의 이름(읍면동 단위)을 입력하세요: ')
full_name = name

for row in data:
    if name in row[0]: # 입력한 지역과 일치하는 행에 대해서만
        if len(result)>0: # 신촌동처럼 동 이름이 같은 행정구역이 여럿인 경우 처음으로 등장하는 지역에 대해서만 처리
            break
        else:
            for i in row[3:]: # 행정구역과 총계 열들을 제외하고
                result.append(int(i.replace(',',''))) # 쉼표를 제거하고 정수로 변환
        full_name = row[0].split('(')[0]
print(full_name,result[:5]) # 제대로 변환되었는지 미리보기

if result:
    plt.style.use('ggplot')
    plt.rc('font', family='Malgun Gothic') # 한글 지원 폰트 설정
    plt.title(full_name + ' 지역의 인구 구조') # 제목 표시
    plt.plot(result) # 선 그래프
    plt.show() # 화면에 출력
else:
    print('데이터가 없습니다.')