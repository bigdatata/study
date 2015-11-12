#coding:utf-8
__author__ = 'luotao'
import math
import datetime
print help(eval)
print 3+4
print "2+4"
print eval("2+4+3")
print eval('"hello "+"world"')

#exec
exec "print 'hello, qiwsir'"

#print

name = 'qiwsir'
room=703
website="qiwsir.github.com"
#%s %d %f
print ("My name is:%s\nMy room is:%d\nMy website is:%s"%(name,room,website))

print "PI=%f"%math.pi #默认，将圆周率打印成这个样子
print "PI=%10.3f"%math.pi #约束一下，这个的含义是整数部分加上小数点和小数部分共计10位，并且右对齐
print "PI=%-10.3f"%math.pi #要求显示的左对齐，其余跟上面一样
print "PI=%06d"%int(math.pi) #整数部分的显示，要求共6位,这样前面用0补足了。

print "%.3s"%website
print "%.*s"%(3,website)
print "%7.3s"%website
print "%-7.3s"%website

#%r
print "Pi=%r"%int(math.pi)
print "PI=%r"%math.pi
#TypeError: %d format: a number is required, not str
#print "Pi=%s"%int(math.pi)

today = datetime.date.today()
print("today:%s,today:%r"%(today,today))
