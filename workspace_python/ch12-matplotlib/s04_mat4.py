import matplotlib.pyplot as plt
from matplotlib import rc

# 한글이 표시될 수 있도록 폰트 지정
rc('font',family='Malgun Gothic')

# 데이터
xdata = ['학생용','실험용','테스트']
ydata1 = [90,85,88]
ydata2 = [83,88,91]

# 선 그래프
# label 옵션으로 그래프의 범례 지정
plt.plot(xdata,ydata1,label='국어')
plt.plot(xdata,ydata2,label='영어')
# 범례를 화면에 표시할 위치 지정
plt.legend(loc='upper center')
# 상단 중앙에 제목을 표시
plt.title('세 학생의 성적')
# 화면에 출력
plt.show()