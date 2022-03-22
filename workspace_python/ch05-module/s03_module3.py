import time

seconds = time.time() # 1970년 1월 1일 자정 이후 경과한 시간을 초 단위로 반환
print(seconds)
print('-'*3)

tm = time.localtime(seconds) # 현지 시간(Local Time)
print('년: ',tm.tm_year)
print('월: ',tm.tm_mon)
print('일: ',tm.tm_mday)
print('시: ',tm.tm_hour)
print('분: ',tm.tm_min)
print('초: ',tm.tm_sec)

# epoch time을 문자열로 변환
string = time.ctime(seconds)
print(string)
print('-'*3)

'''
포맷 기호    의미
%Y    네 자리 연도
%y    두 자리 연도
%m    월
%d    일
%A    요일; Sunday
%a    간략 요일; Sun
%H    24시; 0~23
%I    12시; 1~12
%p    AM 또는 PM
%M    분
%S    초
'''
string2 = time.strftime('%Y년 %m월 %d일 %I:%M:%S %p',tm)
print(string2)