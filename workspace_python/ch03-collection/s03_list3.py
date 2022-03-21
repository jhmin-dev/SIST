colors = ['red', 'green', 'gold']
print(colors)
print('-'*3)

# 요소 값의 수정
colors[1] = 'orange'
print(colors)
print('-'*3)

# 없는 인덱스 호출시 에러
# JavaScript와 달리 없는 인덱스에 값을 대입하여 리스트에 요소를 추가하는 방식은 불가능
# colors[3] = 'pink'

# append(요소): 리스트에 요소 추가
colors.append('pink')
print(colors)
print('-'*3)

# insert(인덱스, 요소): 원하는 위치에 요소 삽입
colors.insert(1, 'silver')
print(colors)
print('-'*3)

# extend(반복 가능한 요소): 튜플이나 리스트 등에서 여러 값을 한 번에 추가
colors.extend(['white', 'midnight blue'])
print(colors)