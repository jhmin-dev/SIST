colors = ['red', 'black', 'green', 'red', 'blue', 'white', 'gray']
# 인덱스 검색
print(colors.index('red'))
# 지정한 요소가 검색되지 않으면 에러 발생
# print(colors.index('reds'))
# 검색 시작 위치 지정
print(colors.index('red',1))
# 검색 시작 위치와 끝 위치 지정; 검색 범위는 지정한 끝 위치 직전까지
# print(colors.index('red',1,3))
print(colors.index('red',1,4))