import pandas as pd

obj = pd.Series([10,20,30,40,50])
print(obj)
print('-'*3)

print(obj*10)
print('-'*3)

print(obj[obj>25])
print('-'*3)

print(obj>25)
print('-'*3)

pop = pd.Series([9765623,3441453,2948375],index=["서울","부산","인천"])
print(pop)
print('-'*3)

# items(): Series 객체에 있는 요소를 튜플 형태의 (index,value)로 반환
for i,v in pop.items():
    print('%s: %d명' % (i,v))
print('-'*3)

# Series 객체와 딕셔너리
pop = pd.Series({"서울":9765623,"부산":3441453,"인천":2948375},index=["서울","부산","인천","경기","광주"]) # 딕셔너리의 크기보다 인덱스를 더 많이 지정
print(pop) # 딕셔너리에 값이 없는 인덱스는 NaN이 됨

pop['광주'] = 149336 # NaN인 인덱스에 값 대입
print(pop)
print('-'*3)

print('광주시 인구: %.0f명' % pop['광주'])