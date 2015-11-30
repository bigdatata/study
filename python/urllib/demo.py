# -*- coding:utf-8 -*-
__author__ = 'luotao'
import urllib
import urllib2

response = urllib2.urlopen("http://www.baidu.com")
print(response.read())

# with request
request = urllib2.Request("http://www.baidu.com")
response = urllib2.urlopen(request)
print(response.read())
# post method
values = {"username":"1016903103@qq.com","password":"XXXX"}
data = urllib.urlencode(values)
url = "https://passport.csdn.net/account/login?from=http://my.csdn.net/my/mycsdn"
request = urllib2.Request(url,data)
response = urllib2.urlopen(request)
print response.read()

# get method
values={}
values['username'] = "1016903103@qq.com"
values['password']="XXXX"
data = urllib.urlencode(values)
url = "http://passport.csdn.net/account/login"
geturl = url + "?"+data
request = urllib2.Request(geturl)
response = urllib2.urlopen(request)
print response.read()
