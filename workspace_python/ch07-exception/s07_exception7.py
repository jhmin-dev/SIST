# 의도적으로 예외를 발생시킴
# raise [Exception]: 해당 예외를 발생
# raise [Exception(data)]: 예외 발생시 관련 데이터를 전달

def RaiseErrorFunction():
    raise NameError('NameError의 인자') # 내장 예외인 NameError를 발생

try:
    RaiseErrorFunction()
except NameError as e:
    print(e.args[0])
    print('NameError is caught')