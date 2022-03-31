import matplotlib.pyplot as plt

# range()를 이용하여 0~29까지의 수를 지정하고 list()를 이용하여 리스트 생성
xdata = list(range(30))

# ydata는 xdata의 각 요소에 2를 곱한 값을 갖도록 연산
ydata = []
for x in xdata:
    y = 2*x
    ydata.append(y)
# ydata2 = (2*numpy.array(xdata)).tolist()

# 선 그래프
plt.plot(xdata,ydata,label='y=2x')

# 범례의 위치 지정
plt.legend(loc='best')

# x축의 범위를 0~35로 지정
plt.xlim(0,35)

# y축의 범위를 0~70으로 지정
plt.ylim(0,70)

# x축과 y축 눈금 값 표시
plt.xticks(list(range(0,35,2)))
plt.yticks(list(range(0,70,5)))

# 그리드 표시
plt.grid(True)

# 화면에 출력
plt.show()