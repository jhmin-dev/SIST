# 정규표현식 사용
import re

sentence = 'I have a lovely cat, really. I am not telling a lie. What a pretty cat! I love this cat.'

# re.split(): 특정한 패턴이 등장할 때 문자열을 나눔
# r'[.?!]'에서 r을 쓰면 역슬래시를 붙이지 않아도 마침표, 느낌표, 물음표를 특수문자가 아닌 일반 문자로 인식
result = re.split(r'[.?!]', sentence)
print(result)
print('-'*3)

data = 'a:3;b:4;c:5'
for i in re.split(r';',data):
    print(re.split(r':',i))
print('-'*3)

# sub(): 문자열 바꾸기
data2 = re.sub(r'cat',r'rabbit',sentence)
print(data2)
print('-'*3)

words = 'I am home now. \n\nI am with my cat.\n\n'
print(words)
print('-'*3)
data3 = re.sub(r'\n','',words)
print(data3)
print('-'*3)

# findall(): 패턴을 문자열에서 모두 찾아서 리스트로 반환
sentence = 'I have a lovely cat, really. I am not telling a lie'
# \w: 문자나 숫자가 몇 번 나와도 좋으니 반복하고(+), ly로 끝나는 패턴을 의미
words2 = re.findall(r'\w+ly', sentence)
print(words2)