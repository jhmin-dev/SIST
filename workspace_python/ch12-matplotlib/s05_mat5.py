import matplotlib.pyplot as plt
from matplotlib import rc

# 한글이 표시될 수 있도록 폰트 지정
rc('font',family='Malgun Gothic')

# 데이터
xdata = ['학생용','실험용','테스트']
ydata1 = [90,85,88]
ydata2 = [83,88,91]
ydata3 = [85,97,78]
ydata4 = [92,88,82]

# 선 스타일

# 선의 종류
# - 실선(solid line)
# -- 파선(dashed line)
# -. 일점쇄선(dashed-dotted line)
# : 점선(dotted line)

# 마커의 값
# o 색이 채워진 원
# x x
# s 색이 채워진 사각형
# d 색이 채워진 다이아몬드
# * *

# color, linestyle, marker 지정
plt.plot(xdata,ydata1,label='국어',color='red',linestyle='-',marker='o')
plt.plot(xdata,ydata2,label='영어',color='#00ffff',linestyle='--',marker='x')
plt.plot(xdata,ydata3,label='수학',color='magenta',linestyle='-.',marker='s')
plt.plot(xdata,ydata4,label='사회',color='#444444',linestyle=':',marker='d')
# 범례를 가장 적합한 위치에 표시
plt.legend(loc='best') # 우측 상단에 표시됨
# 제목 표시
plt.title('세 학생의 네 과목 성적')
# 화면 출력
plt.show()