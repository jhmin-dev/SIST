import matplotlib.pyplot as plt
from matplotlib import rc

# 한글이 표시될 수 있도록 폰트 지정
rc('font',family='Malgun Gothic')

# 데이터
x = ['월','화','수','목','금','토','일']
y = [6.5,5.7,5.5,6.7,6.3,7.5,8.3]

# 제목 표시
plt.title('연간 요일별 평균 수면 시간')
# 산포 그래프
plt.scatter(x,y)
# 레이블 표시
plt.ylabel('수면 시간')
# 화면에 출력
plt.show()