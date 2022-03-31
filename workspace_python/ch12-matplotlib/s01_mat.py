# Matplotlib은 분석한 데이터를 그래프나 차트로 시각화해주는 파이썬의 패키지 라이브러리
import matplotlib.pyplot as plt

# y축에 사용될 변수
data = [20,30,40]
# x축에 사용될 변수
x = [1,2,3]

# matplotlib.pyplot.plot(): 선 그래프; x,y축 데이터는 리스트 자료형
plt.plot(x,data)
# matplotlib.pyplot.show(): plot()으로 그린 그래프를 화면에 출력
plt.show()