#coding:utf-8
name = u'老齐'
print name.encode("GBK")
print u"你好".encode("GBK")
unicode_str = unicode('中文', encoding='utf-8')
print unicode_str.encode('utf-8')