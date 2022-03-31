import urllib.request as ur
from bs4 import BeautifulSoup as bs

article1 = 'https://v.daum.net/v/20220329101906471'
soup = bs(ur.urlopen(article1).read(),'html.parser')

# 기사 본문을 파일로 저장하기
f = open('article_1.txt', 'w', encoding='UTF-8')
for i in soup.find_all('p'):
    f.write(i.text)
print('작업을 완료했습니다')
f.close()