import re

# match(): 문자열의 처음부터 정규식과 매치되는지를 조사하고, 매치되지 않으면 None 반환
script = 'life'

p = re.match(r'life',script)
print(p)
print('-'*3)

# group(): 매치된 내용을 반환; 매치되지 않으면 오류 발생
p2 = re.match(r'life',script).group()
print(p2)
print('-'*3)

# span(): 매치된 문자열의 시작과 끝 직후 인덱스를 튜플로 반환
p2 = re.match(r'life',script).span()
print(p2)