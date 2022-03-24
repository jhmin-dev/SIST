import csv

a = [['구','전체','내국인','외국인'],
     ['관악구','519864','502089','17775'],
     ['강남구','547602','542498','5104'],
     ['송파구','686181','679247','6934'],
     ['강동구','428547','424235','4312']]

# newline을 빈 문자열로 전달하지 않으면 줄바꿈이 2회 발생
f = open('abc.csv','w',encoding='UTF-8',newline='')
# csv 파일의 구분자 지정
csvobject = csv.writer(f,delimiter=',')

# writerows(): csv형 리스트가 저장된 객체를 파일에 쓸 때 사용
csvobject.writerows(a)
print('csv 파일을 생성하였습니다')
f.close()