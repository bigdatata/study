#coding:utf-8
__author__ = 'luotao'

import math
import sys

# string formatting
myInfo = {'website': 'qiwsir.github.io', 'name': 'qiwsir', 'room': 703}
print("qiwsir is in %(room)d" % myInfo)

print("My name is {0} and I am in {1}".format("qiwsir", 703))  # 将format后面的内容以此填充
print("My website is {website}".format(website="qiwsir.github.io"))  # {}里面那个相当于一个变量了吧

print("{number} is in {all}. {0} are my number.".format("seven", number=7, all=range(11)))

# 序列对象的偏移量

template = "The word is {0}, Its first is {0[0]}. Another word is {1}, Its second is {1[1]}."
print(template.format("python","learn"))

print("{name}\'s first is {name[0]}".format(name="qiwsir"))    #指定关键词的值的偏移量

print("my website is {info[website]}, and I like {0}".format("python",info=myInfo))   #关键词info引用的是一个字典)

# 模板中添加属性
print("PI is {PI.pi}".format(PI=math))
print('PI is {0.pi}. My lptop runs {1.platform}'.format(math,sys))

# 其它进制
print("{0:x},{0:o},{0:b}".format(255))