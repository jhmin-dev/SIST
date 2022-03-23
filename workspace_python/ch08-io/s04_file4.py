# 파일 생성
f = open('text2.txt','w',encoding='UTF-8')
# write(): 작성한 문자 수를 반환
print(f.write('오늘은 수요일\n도로롱 도로롱'))
f.close()

# 파일 모드를 지정하지 않으면 읽기 모드
f = open('text2.txt',encoding='UTF-8')
print(f.read())
f.close()