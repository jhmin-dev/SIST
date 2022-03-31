import matplotlib.pyplot as plt

# 선 그래프; x,y축은 리스트형 데이터
plt.plot(['test','admin','pika'],[85,88,90])
# 상단 중앙에 제목 표시
plt.title('English Score of three students')
# x축 레이블의 이름 설정
plt.xlabel('Student Name')
# y축 레이블의 이름 설정
plt.ylabel('Score')
# 화면에 출력
plt.show()