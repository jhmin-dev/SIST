import urllib.request as ur
from bs4 import BeautifulSoup as bs

url = 'https://news.daum.net'
soup = bs(ur.urlopen(url).read(), 'html.parser')

# 기사 제목, 본문, 하이퍼 링크를 파일로 저장하기
f = open('article_total.txt', 'w', encoding='UTF-8')
for i in soup.find_all('div',{'class':'item_issue'}):
    try:
        # 제목을 추출해서 파일을 씀
        f.write(i.text + '\n')
        # URL 주소를 추출해서 파일에 씀
        link = i.find_all('a')[0].get('href')
        f.write(link + '\n')
        # URL 주소에 해당하는 웹 문서를 열어 새 BeautifulSoup 객체로 저장
        soup2 = bs(ur.urlopen(link).read(), 'html.parser')
        # p 태그에서 본문만 추출
        for j in soup2.find_all('p'):
            f.write(j.text)
    except:
        pass
print('작업을 완료했습니다')
f.close()