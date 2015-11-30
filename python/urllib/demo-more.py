# -*- coding:utf-8 -*-
__author__ = 'luotao'
import urllib
import urllib2
# 5.使用DebugLog
httpHandler = urllib2.HTTPHandler(debuglevel=1)
httpsHandler = urllib2.HTTPSHandler(debuglevel=1)
opener = urllib2.build_opener(httpHandler, httpsHandler)
urllib2.install_opener(opener)

# 1.设置Headers
user_agent = 'Mozilla/4.0 (compatible; MSIE 5.5; Windows NT)'
values = {'q' : 'cqc' }
#对付”反盗链”的方式，对付防盗链，服务器会识别headers中的referer是不是它自己
headers = { 'User-Agent' : user_agent,'Referer':'http://www.zhihu.com/articles' }
data = urllib.urlencode(values)
request = urllib2.Request("http://www.baidu.com", data, headers)
response = urllib2.urlopen(request)
print(response.read())

# 2. Proxy（代理）的设置
import urllib2
enable_proxy = True
proxy_handler = urllib2.ProxyHandler({"http" : 'http://127.0.0.1:8087'})
null_proxy_handler = urllib2.ProxyHandler({})
if enable_proxy:
    opener = urllib2.build_opener(proxy_handler)
else:
    opener = urllib2.build_opener(null_proxy_handler)
urllib2.install_opener(opener)

# 3.Timeout 设置
response = urllib2.urlopen('http://www.baidu.com', timeout=10)
response = urllib2.urlopen('http://www.baidu.com',data, 10)

# 4.使用 HTTP 的 PUT 和 DELETE 方法
request = urllib2.Request('http://www.baidu.com', data=data)
request.get_method = lambda: 'PUT' # or 'DELETE'
response = urllib2.urlopen(request)
