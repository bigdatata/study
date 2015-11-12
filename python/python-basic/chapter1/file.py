#coding:utf-8
__author__ = 'luotao'
# r	以读方式打开文件，可读取文件信息。
# w	以写方式打开文件，可向文件写入信息。如文件存在，则清空该文件，再写入新内容
# a	以追加模式打开文件（即一打开文件，文件指针自动移到文件末尾），如果文件不存在则创建
# r+	以读写方式打开文件，可对文件进行读和写操作。
# w+	消除文件内容，然后以读写方式打开文件。
# a+	以读写方式打开文件，并把文件指针移到文件尾。
# b	以二进制模式打开文件，而不是以文本模式。该模式只对Windows或Dos有效，类Unix的文件是用二进制模式进行操作的。
import os
import time
f =open('130.txt','w')
f.write("print hello world\n")
f.close()
nf = open('130.txt','a')
nf.write("append to file")
nf.close()
readFile = open('130.txt')

for line in readFile:
    print line,
readFile.close()

f = open('131.txt','a')
print(f.name)
print(f.mode)
file_stat= os.stat('131.txt')
print(file_stat)
print time.localtime(file_stat.st_ctime)
# file.read() file.readLine file.readLines