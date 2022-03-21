member = ['바닐프티', '바닐리치', '배바닐라', '바닐리치', 0]
print(member)
print('-'*3)

# remove(요소): 리스트에서 지정한 요소와 일치하는 첫 번째 요소를 삭제
member.remove('바닐리치')
print(member)
print('-'*3)

# remove()는 인덱스 값으로 삭제하지 않으므로 주의; 지정한 요소가 리스트에 없으면 에러
# member.remove(1)
member.remove(0)
print(member)
print('-'*3)

data = [10,20,30,40,50,60,70,80]
print(data)

# pop(인덱스): 인덱스를 지정해서 삭제; 삭제하는 데이터를 반환
x = data.pop(2)
print(x)
print(data)
print('-'*3)

x = data.pop(3)
print(x)
print(data)
print('-'*3)

# pop() 메서드의 입력 인자를 생략하면 끝에서 값을 뽑아내고 삭제
print(data.pop())
print(data.pop())
print(data)
print('-'*3)

# clear(): 리스트의 모든 요소 삭제
data.clear()
print(data)

person1 = ['kim',24,'student']
person2 = ['lee',26,'teacher']
# 두 리스트 합치기
person = person1 + person2
print(person)