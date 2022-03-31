'''
웹 크롤링이란 웹의 정보를 자동으로 수집하는 것을 의미하며,
이런 목적을 위해 만든 프로그램을 웹 크롤러라고 함
'''
# urllib는 웹에서 얻은 데이터를 다루는 파이썬 패키지
import urllib.request as ur

'''
BeautifulSoup
웹 문서를 구성하는 HTML과 XML 문서에서 원하는 정보를 쉽게 추출할 수 있는 모듈을 모아놓은 파이썬 패키지
'''
from bs4 import BeautifulSoup as bs

# http://quotes.toscrape.com/에서 명언 정보에 접근
url = 'http://quotes.toscrape.com/'
# 해당 주소의 웹 사이트에 원하는 정보를 요청하여 그 결과를 반환
html = ur.urlopen(url)
print(html)
print('-'*3)

# BeautifulSoup로 자료형 변환하기(html 문자열, html 파서)
soup = bs(ur.urlopen(url).read(), 'html.parser')
print(soup)