#! /usr/bin/env python
#coding:utf-8

hello = "world"
for i in hello:
	print i
for i in hello:
	print i,
for i in hello:
	print i+",",
	
ls_line = ['Hello', 'I am qiwsir', 'Welcome you', '']
print
for word in ls_line:
	print word,
print 

aliquot = []

for n in range(1,100):
    if n%3 == 0:
        aliquot.append(n)
print aliquot

power2 = []
for i in range(1,10):
	power2.append(i*i)
print power2
squares = [x**2 for x in range(1,10)]
print squares
aliquot = [n for n in range(1,100) if n%3==0]
print aliquot
print range(3,100,3)

mybag = [' glass',' apple','green leaf ']
print [one.strip() for one in mybag]

week = ["monday","sunday","friday"]
for i in range(len(week)):
	print week[i]+' is '+str(i)
for (i,day) in enumerate(week):
	 print day+' is '+str(i)
	 
print list(enumerate(week))
print list(enumerate(week,start=1))

def treatment(pos,element):
	return "%d:%s"%(pos,element)
	
seq = ["qiwsir","qiwsir.github.io","python"]
print [treatment(pos,element) for pos,element in enumerate(seq)]

#lambda
foo = lambda i,ele:"%d:%s"%(i,ele) 
print [foo(pos,element) for pos,element in enumerate(seq)]


