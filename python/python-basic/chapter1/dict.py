#! /usr/bin/env python
#coding:utf-8

#empty dict
mydict = {}
print mydict

#create with element
person = {"name":"qiwsir","site":"qiwsir.github.io","language":"python"}
print person

# add element to dict
mydict["site"] = "qiwsir.github.io"
mydict[1] = 80
mydict["name"] = ["zhangsan","lisi","wangwu"]
print mydict
mydict[1] = 90
print mydict

name = (["first","Google"],["second","Yahoo"]) 
website = dict(name)
print website

website = {}.fromkeys(("third","forth"),"facebook")
print website

# get dict value by key
print person['name']
for key in person:
	print person[key],
print 

a_dict = {1:{"name":"qiwsir"},2:"python","email":"qiwsir@gmail.com"}
print a_dict
print a_dict[1]["name"]

# keys values items
website = {1:"google","second":"baidu",3:"facebook","twitter":4}
print website.keys()
print website.values()
print website.items()

for k,v in website.items():
	print str(k)+":"+str(v)

# get len pop del updated
print website.get("second")
print len(website)

print website.pop('second')

cnweb = {'qq': 'first in cn', 'python': 'qiwsir.github.io', 'alibaba': 'Business'}
website = {1: 'google', 'second': 'baidu', 3: 'facebook', 'twitter': 4}
website.update(cnweb) 

print website
