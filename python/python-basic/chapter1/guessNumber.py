#coding:utf-8
__author__ = 'luotao'

import  random
print dir(random)
#随机整数
print random.randint(0,99)
# 随机选取0到100间的偶数
print random.randrange(0,99,2)
#随机浮点数
print(random.random())
print(random.uniform(1,10))
help(random.uniform)
# 随机字符
print(random.choice("welcome to china"))
# 多个字符中选取特定数量的字符
print(random.sample("welcome you",3))
# 洗牌：把原有的顺序打乱，按照随机顺序排列
items = range(1,7)
random.shuffle(items)
print(items)

number = random.randint(1,10)
for i in range(1,10):
    inputNumber = int(raw_input("please input a number:\n"))
    if inputNumber==number:
        print("you are right,the number is ",number)
        break
    elif inputNumber>number:
        print("you are inputNumber is big")
    else:
        print("you are inputNumber is small")
