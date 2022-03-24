import csv

# 읽기 모드로 a.csv 파일 열기
f = open('a.csv','r',encoding='UTF-8')

new = csv.reader(f)
print(new)
print('-'*3)

# csv 파일 정보(객체)로부터 데이터 추출
for i in new:
    print(i) # 리스트 반환
print('-'*3)

# 파일의 내용을 읽으면 커서가 마지막으로 이동해 있기 때문에 다시 파일을 읽으려면 커서를 처음으로 되돌려야 함
f.seek(0)

a_list = []
for i in new:
    a_list.append(i)
print(a_list)

f.close()