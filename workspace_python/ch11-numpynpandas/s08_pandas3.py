import pandas as pd

data = {"이름":["도로롱","실험용","관리자","테스트"],
        "아이디":["dororong","user","admin","test"],
        "비밀번호":["sleepy","1234","abcd","0000"]}

# DataFrame은 테이블 형태로 되어 있는 2차원 자료 구조
frame = pd.DataFrame(data)
print(frame)
print('-'*3)

member = {"이름":["바닐리치","바닐프티"],
          "나이":[10,13],
          "전화번호":["010-1234-5678","010-0000-0000"]}

# DataFrame 생성시 columns로 열 인덱스를 설정하고, index로 행 인덱스를 설정
frame = pd.DataFrame(member,columns=["이름2","전화번호","나이","주소"],index=["01","02"])
print(frame) # 값이 없는 인덱스는 NaN