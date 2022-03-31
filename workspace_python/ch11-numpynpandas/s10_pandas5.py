import pandas as pd

data = {"아이디":["test","admin","dororong","pika"],
        "구매 상품":["다이어리","스티커","중성펜","지우개"],
        "가격":[15000,4900,3300,900],
        "수량":[3,5,1,10],
        "구매일":['0101','0210','0303','0330']}

frame = pd.DataFrame(data)
print(frame)
print('-'*3)

# iloc[행 인덱스 번호, 열 인덱스 번호]
# frame 객체에서 행 인덱스 2이고 열 인덱스 0인 요소의 값
print(frame.iloc[2,0])
print('-'*3)

# frame 객체에서 행 인덱스는 3이고 열 인덱스가 0(='아이디')과 1(='구매 상품')인 DataFrame 객체 반환
print(frame.iloc[3,:2])
print('-'*3)

# frame 객체에서 행 인덱스는 전체, 열 인덱스가 0(='아이디')과 4(='구매일')로 구성된 DataFrame 객체 반환
print(frame.iloc[:,[0,4]])