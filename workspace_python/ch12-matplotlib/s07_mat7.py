# 파이 차트(=파이 그래프)는 원과 피자 파이 조각 형태
import matplotlib.pyplot as plt
from matplotlib import rc

# 한글이 표시될 수 있도록 폰트 지정
rc('font',family='Malgun Gothic')

# 레이블
pets = ['개','고양이','기타','기르지 않음']
# 데이터
portion = [18,3.4,3.1,75.5]

# 파이 그래프
# explode(0,0.1,0,0)는 두 번째 조각을 원에서 0.1만큼 분리시킴
# labels는 조각들의 레이블을 지정
# autopct는 값 표시 형식을 지정
# shadow는 그림자 여부를 지정
# startangle은 원을 그리기 시작하는 각도를 지정
plt.pie(portion,explode=(0,0.1,0,0),labels=pets,autopct='%.1f%%',shadow=True,startangle=90)
# 제목 표시
plt.title('총 가구 대비 반려동물을 기르는 비율(2018)')
# 화면에 출력
plt.show()