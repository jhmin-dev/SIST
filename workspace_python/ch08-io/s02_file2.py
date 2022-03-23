# 기존 파일에 데이터를 추가
f = open('new_file.txt','a',encoding='UTF-8')

names = ['불켜미', '샹델라']
for name in names:
    f.write(name+'\n')
print('파일에 데이터 추가 완료')

f.close()