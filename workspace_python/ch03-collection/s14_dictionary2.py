user = {'id':'test','name':'실험','level':2,'point':100}
print(user)
print(user['id'])
print(user['name'])
print(user['level'])
print(user['point'])
print('-'*3)

score = {'kor':90,'eng':89,'math':98}
print(score)

# 추가
score['music'] = 100 # 없는 키에 값을 대입하면 딕셔너리에 해당 키와 값의 쌍이 추가됨
print(score)
print('-'*3)

# 수정
score['kor'] = 100 # 있는 키에 값을 대입하면 딕셔너리에서 해당 키의 값이 수정됨
print(score)
print('-'*3)

# 삭제
x = score.pop('eng') # pop()에 키를 전달하면 해당 키의 값을 반환하고 딕셔너리에서 해당 키와 값의 쌍을 삭제함
print(x)
print(score)
print('-'*3)

# clear(): 딕셔너리의 전체 요소 삭제
score.clear()
print(score)
print('-'*3)

area_code = {'서울':'02','인천':'032','경기':'031','광주':'062'}
# 반복문을 이용해서 key를 구하고 value 호출하기
for key in area_code:
    print('%s 지역 번호: %s' % (key,area_code[key]))