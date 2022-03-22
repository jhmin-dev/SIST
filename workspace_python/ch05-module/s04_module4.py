# 현재의 날짜와 시간 구하기
# datetime 모듈의 datetime 객체를 불러오기
from datetime import datetime

today = datetime.now()
print('%s년' % today.year)
print('%s월' % today.month)
print('%s일' % today.day)
print('%s시' % today.hour)
print('%s분' % today.minute)
print('%s초' % today.second)

string = today.strftime('%Y/%m/%d %H:%M:%S')
print(string)