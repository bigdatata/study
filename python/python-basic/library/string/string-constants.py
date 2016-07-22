#coding:utf-8
__author__ = 'luotao'

import string

# http://python.usyiyi.cn/python_278/library/string.html
# string.ascii_letters
# ascii_lowercase和ascii_uppercase常量的连接串，如下所述。此值不是依赖于区域设置的。
#
# string.ascii_lowercase
# 小写字母'abcdefghijklmnopqrstuvwxyz'。此值不是依赖于区域设置的并且不会改变。
#
# string.ascii_uppercase
# 大写的字母'ABCDEFGHIJKLMNOPQRSTUVWXYZ'。此值不是依赖于区域设置的并且不会改变。
#
# string.digits
# 字符串'0123456789'。
#
# string.hexdigits
# 字符串'0123456789abcdefABCDEF'。
#
# string.letters
# 串联的字符串的小写和大写形式如下所述。特定的值依赖于区域设置，并调用locale.setlocale()时将更新。
#
# string.lowercase
# 一个字符串，包含所有被认为是小写字母的字符。在大多数系统上，这是字符串'abcdefghijklmnopqrstuvwxyz'。特定的值依赖于区域设置，并调用locale.setlocale()时将更新。
#
# string.octdigits
# 字符串'01234567'。
#
# string.punctuation
# 在C语言中的标点字符的 ASCII 字符的字符串。
#
# string.printable
# 可打印的字符的字符串。这是一个组合的数字、字母、标点符号和空格。
#
# string.uppercase
# 一个字符串，包含所有被认为是大写字母的字符。在大多数系统上，这是'ABCDEFGHIJKLMNOPQRSTUVWXYZ'的字符串。特定的值依赖于区域设置，并调用locale.setlocale()时将更新。
#
# string.whitespace
# 包含的所有字符都被视为空格的字符串。在大多数系统上，这包括空格符、 制表符、 换行符、 回车符、 换页符和垂直制表符。
#
print(string.ascii_letters)
print(string.ascii_lowercase)
print(string.ascii_uppercase)
print(string.digits)
print(string.hexdigits)
print(string.letters)
print(string.lowercase)
print(string.octdigits)
print(string.punctuation)
print(string.printable)
print(string.whitespace)
print(string.uppercase)
