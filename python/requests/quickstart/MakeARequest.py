#-- #coding:utf-8 --#

import requests

# # get post put delete head options
# response = requests.post("http://httpbin.org/post",data={"key":"value"})
# response = requests.put("http://httpbin.org/put",data={"key":"value"})
# response = requests.delete("http://httpbin.org/delete")
# response = requests.head("http://httpbin.org/get")
# response = requests.options("http://httpbin.org/get")
#
# #Passing Parameters In URLs
# payload = {'key1': 'value1', 'key2': 'value2','key3': ['value3', 'value4']}
# response = requests.get("http://httpbin.org/get",params=payload)
# print(response.url)

# Response Content
response = requests.get("https://api.github.com/events")
print(response.url)
print(response.text)
print(response.encoding)
response.encoding = 'ISO-8859-1'




