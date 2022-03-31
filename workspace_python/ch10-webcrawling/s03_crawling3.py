import urllib.request as ur
from bs4 import BeautifulSoup as bs

# 데이터를 읽어들일 URL
news = 'https://news.daum.net'
soup = bs(ur.urlopen(news).read(), 'html.parser')
print(soup)
print('-'*3)

# 머리 기사 제목 추출하기
print(soup.find_all('div',{'class':'item_issue'}))
print('-'*3)

# 반복문으로 기사 제목 모두 추출하기
for i in soup.find_all('div',{'class':'item_issue'}):
    print(i.text)
print('-'*3)

# <img> 태그에 접근
for i in soup.find_all('img')[:5]:
    # get(): 지정한 속성의 값 반환
    print(i.get('src'))
print('-'*3)

# <a> 태그만 추출
for i in soup.find_all('a')[:5]:
    print(i.get('href'))

# 웹에서 읽어온 정보를 파일에 저장
f = open('links.txt','w')
# 이슈 기사의 링크만 추출
for i in soup.find_all('div',{'class':'item_issue'}):
    f.write(i.find_all('a')[0].get('href') + '\n')
print('작업을 완료했습니다')
f.close()