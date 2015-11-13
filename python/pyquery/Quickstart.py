from pyquery import PyQuery as pq
from lxml import etree
import  urllib
d = pq("<html></html>")
d = pq(etree.fromstring("<html></html>"))
d = pq(url='http://jd.com/')
# d = pq(url='http://google.com/', opener=lambda url, **kw: urllib.urlopen(url).read())
d = pq(filename="F:\github\study\python\pyquery\Quickstart.py")


