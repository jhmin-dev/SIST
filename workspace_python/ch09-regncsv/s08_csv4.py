from usecsv import writecsv

a = [['구','전체','내국인','외국인'],
     ['관악구','519864','502089','17775'],
     ['강남구','547602','542498','5104'],
     ['송파구','686181','679247','6934'],
     ['강동구','428547','424235','4312']]

writecsv('abc2.csv', 'UTF-8', a)
print('csv 파일이 생성되었습니다')