import urllib.request as ur
from bs4 import BeautifulSoup as bs

soup = bs(ur.urlopen('http://quotes.toscrape.com/').read(), 'html.parser')
print(soup)
print('-'*3)

# find_all()로 원하는 태그만 모아서 리스트 반환
print(soup.find_all('span'))
print('-'*3)

quote = soup.find_all('span')
print(quote[0])
print('-'*3)

# 모든 원소에서 텍스트만 추출
for i in quote:
    print(i.text)
print('-'*3)

# 클래스가 quote인 <div>만 모아서 리스트로 반환
print(soup.find_all('div', {'class':'quote'}))
print('-'*3)

print(soup.find_all('div', attrs={'class':'quote'}))
print('-'*3)

# find()는 조건에 일치하는 첫 번째 태그를 반환
print(soup.find('span', {'itemprop':'text'}))