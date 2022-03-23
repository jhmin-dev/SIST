# 파일로부터 데이터 읽기
# readlines(): 전체 내용을 읽어서 행들의 리스트로 반환
f = open('new_file.txt','r',encoding='UTF-8')
lines = f.readlines()
print(lines)
print('-'*3)
for line in lines:
    temp = line.replace('\n','') # print()가 기본적으로 줄바꿈처리하므로 불필요한 \n 제거
    print(temp)
f.close()
print('-'*3)

# 영역 내에서 작업
with open('new_file.txt','r',encoding='UTF-8') as f:
    for line in f.readlines():
        print(line.replace('\n',''))
f.close()
print('-'*3)

# read(): 파일의 전체 내용을 읽어서 문자열로 반환
f = open('new_file.txt','r',encoding='UTF-8')
lines = f.read()
print(lines)
f.close()