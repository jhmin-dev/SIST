scores = [[75,83,90],[86,86,73],[76,95,83],[89,96,69],[89,76,93]]
for i in range(len(scores)): # 리스트의 행
    sum = 0;
    for j in range(len(scores[i])): # 리스트의 열
        sum += scores[i][j] # 총점
    avg = sum/len(scores[i]) # 평균
    print('%d번째 학생의 총점: %d, 평균: %.2f' % (i+1,sum,avg))