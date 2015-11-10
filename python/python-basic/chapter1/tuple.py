#tuple readonly list

t = 123,'abc',["come","here"]
print t
one_list = ["python","qiwsir","github","io"]
print one_list[0]
print len(one_list)

for one in one_list:
	print one,
print 

print t[1:]
print t[2][0]

#tuple-->list
tls = list(t)
print tls
tls.append("hello")
#list-->tuple
t_tuple = tuple(tls)
print t_tuple 