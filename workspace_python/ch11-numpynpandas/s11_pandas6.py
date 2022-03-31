import pandas as pd

scores = {'이름':['테스트','도로롱','실험용','불켜미','샹델라'],
          '국어':[95,97,90,94,87],
          '영어':[90,86,93,85,93],
          '수학':[85,88,89,88,99]}

frame = pd.DataFrame(scores)
print(frame)
print('-'*3)

frame2 = frame.iloc[:,[1,2,3]] # 연산을 위해 이름을 제외
print(frame2)
print('-'*3)

# 행 방향으로 요소 값의 합계
total = frame2.sum(axis=1)
# 행 방향으로 요소 값의 평균
avg = frame2.mean(axis=1)

print('이름 합계 평균')
for i in range(5):
    print('%s %d %.2f' % (frame.iloc[i,0],total.iloc[i],avg.iloc[i]))