import matplotlib.pyplot as plt
from matplotlib import rc

# 'font'에 'Malgun Gothic' 지정
rc('font',family='Malgun Gothic') # 생략시 한글 출력이 안 됨
# 딕셔너리 자료형으로 폰트 스타일 생성
font1 = {'size':18,'color':'green'}

# 데이터
xdata = ['테스트','실험용','관리자']
ydata = [90,85,88]

# 선 그래프
plt.plot(xdata,ydata)
# 상단 중앙에 제목을 표시, 폰트 스타일 적용
plt.title('세 명의 국어 성적', fontdict=font1)
# x축 레이블의 이름 설정
plt.xlabel('이름')
# y축 레이블의 이름 설정
plt.ylabel('성적')
# 화면에 출력
plt.show()