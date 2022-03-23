# scores.txt 파일 읽기
f = open('scores.txt',encoding='UTF-8')
lines = f.readlines()
print(lines)
print('-'*3)

for line in lines:
    data = line.split()
    # print(data)
    i=0
    sum=0
    
    while i<len(data):
        if i==0: # 인덱스 0은 이름
            print(data[i],end=': ') # 줄바꿈하지 않음
        else:
            sum+=int(data[i])
        i+=1
    
    avg=sum/(len(data)-1) # 길이에서 이름을 제외해야 과목 수
    print('%.2f점' % avg)

f.close()