# set

s1= set("helloworld")
print s1
print set(['q', 'i', 's', 'r', 'w'])

s2 = set([123,"google","face","book","facebook","book"])
print s2

s3 = {"facebook",123}
print s3

#TypeError: unhashable type: 'dict'
#s3 = {"facebook",[1,2,'a'],{"name":"python","lang":"english"},123}
#TypeError: unhashable type: 'list'
#s3 = {"facebook",[1,2],123}
#TypeError: 'set' object does not support indexing
#print s1[1]
#TypeError: 'set' object does not support item assignment
#s1[1] = "I"

a_set = {}  
print type(a_set)
a_set = {'a','i'}
print type(a_set)
a_set.add("hiadfad")
print a_set
#update
s1 = {'12','b'}
s2 = {'github','ada'}
s1.update(s2)
print s1
print s2
help(set.pop)
help(set.remove)
help(set.discard)
help(set.clear)
s2.clear()
print s2

#can not change set
f_set = frozenset("qiwsir")
print f_set
#AttributeError: 'frozenset' object has no attribute 'add'
#f_set.add("python")

# in 
aset = {'h', 'o', 'n', 'p', 't', 'y'}
print 'a' in aset
print 'h' in aset

# equal 
a = {'q', 'i', 's', 'r', 'w'}
b = {'a', 'q', 'i', 'l', 'o'}
print a==b

c=set('qi')
#issubset issuperset
print c<a
print c.issubset(a)
print a.issuperset(c)
print a<b
print a.issubset(b)

#union
print a|b
print a.union(b)
print a
print b

#intersection
print a&b
print a.intersection(b)
print a
print b

#difference
print a - b
print a.difference(b)

#symmetric_difference
print a.symmetric_difference(b)
help(set.symmetric_difference)

