import csv,re

# .csv를 리스트로 바꾸기 위해 함수 정의
def opencsv(filename,enc):
    f = open(filename,'r',encoding=enc)
    reader = csv.reader(f)
    output = []
    for i in reader:
        output.append(i)
    f.close()
    return output

# csv형 리스트가 저장된 객체를 파일에 쓸 때
def writecsv(filename,enc,the_list):
    with open(filename,'w',encoding=enc,newline='') as f:
        writer = csv.writer(f,delimiter=',')
        writer.writerows(the_list)
    f.close()