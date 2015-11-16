#coding:utf-8
__author__ = 'luotao'

#lambda

def add(x):
    x += 3
    return x
numbers = range(10)

print(numbers)

new_numbers = []
for i in numbers:
    new_numbers.append(add(i))

print(new_numbers)

new_numbers = [x+3 for x in numbers]
print(new_numbers)

# lambda arg1, arg2, ...argN : expression using arguments
# lambda 函数不能包含命令，包含的表达式不能超过一个。
# 不要试图向 lambda 函数中塞入太多的东西；
# 如果你需要更复杂的东西，应该定义一个普通函数，然后想让它多长就多长。
lam = lambda x:x+3
n2 = []
for i in numbers:
    n2.append(lam(i))
print(n2)

lam = lambda x,y:x+y
print(lam(2,4))
print((lambda x:x**2)(4))

# map
print(map(add,numbers))
print(map(lambda x:x+3,numbers))
print([x**2 for i in numbers])

list1  = [1,2,3,4,5]
list2 = [6,7,8,9,0]
map(lambda x,y:x+y,list1,list2)

list3 = [7,8,9,2,1]
map(lambda x,y,z:x+y+z,list1,list2,list3)

# reduce
print(reduce(lambda x,y:x+y,numbers))
list1 = [1,2,3,4,5,6,7,8,9]
list2 = [9,8,7,6,5,4,3,2,1]
print(map(lambda x,y: x+y, list1,list2))

print(zip(list1,list2))

print(sum(x*y for x,y in zip(list1,list2)))

print(reduce(lambda sum,(x,y):sum+x*y,zip(list1,list2),0))

from operator import add,mul

print(reduce(add,map(mul,list1,list2)))
##map,reduce,lambda都齐全了，更酷吗？
print(reduce(lambda x,y:x+y,map(lambda x,y:x*y,list1,list2)))

#filter

numbers = range(-5,5)
print(numbers)

print(filter(lambda x:x>0,numbers))
print([x for x in numbers if x>0])
#“If iterable is a string or a tuple, the result also has that type;”
print(filter(lambda c:c!='i',"qiwsir"))


