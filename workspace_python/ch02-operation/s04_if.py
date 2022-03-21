score = int(input('Input Score:'))

# 다중 if문
'''
if score >= 90 and score <= 100:
    grade = 'A'
elif score >= 80 and score < 90:
    grade = 'B'
elif score >= 70 and score < 80:
    grade = 'C'
elif score >= 60 and score < 70:
    grade = 'D'
else:
    grade= 'F'

print('성적은 ' + grade);
'''

# 논리 연산자 생략하고 비교 연산자만으로 축약하여 비교 가능
if 90 <= score <= 100:
    grade = 'A'
elif 80 <= score < 90:
    grade = 'B'
elif 70 <= score < 80:
    grade = 'C'
elif 60 <= score < 70:
    grade = 'D'
else:
    grade = 'F'

print('성적은 ' + grade)