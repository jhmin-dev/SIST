# 클래스 정의
class Account:
    # 생성자
    def __init__(self,balance):
        self.balance = balance
    # 메서드
    def deposit(self,money):
        self.balance += money
        if money>0:
            print('{0:,}원을 예금하였습니다'.format(money))
        elif money<0:
            print('{0:,}원을 출금하였습니다'.format(abs(money)))
    def inquire(self):
        print('잔액: {0:,}원입니다'.format(self.balance)) # {0:,}는 세 자리씩 ,로 끊어 표현

# 객체 생성
a = Account(8000)
a.inquire()
a.deposit(-3000)
a.inquire()
print('-'*3)

b = Account(12000)
b.inquire()