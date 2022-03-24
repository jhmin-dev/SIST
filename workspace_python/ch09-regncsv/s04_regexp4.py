import re

def refinder(pattern,script):
    if re.match(pattern, script):
        print('Matched')
    else:
        print('Not Found')

refinder(r'Life','Life is so cool') # Matched
refinder(r'life','Life is so cool') # Not Found; 대소문자 불일치
refinder(r'is','Life is so cool') # Not Found; 중간에 있는 패턴은 찾지 못함
print('-'*3)

#search(): 문자열 전체를 검색하여 정규식과 매치되는지 조사하고, 매치되지 않으면 None 반환
p = re.search(r'is', 'Life is so cool')
print(p)
p2 = re.search(r'is', 'Life is so cool').group()
print(p2)
p3 = re.search(r'is', 'Life is so cool').span()
print(p3)