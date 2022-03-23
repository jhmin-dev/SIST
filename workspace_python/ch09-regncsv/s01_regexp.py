# 정규표현식 사용
import re

sentence = 'I have a lovely cat, really. I am not telling a lie. What a pretty cat! I love this cat.'

# re.split(): 특정한 패턴이 등장할 때 문자열을 나눔
# r'[.?!]'에서 r을 쓰면 역슬래시를 붙이지 않아도 마침표, 느낌표, 물음표를 특수문자가 아닌 일반 문자로 인식
result = re.split(r'[.?!]', sentence)
print(result)