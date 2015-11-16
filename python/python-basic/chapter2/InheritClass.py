#!/usr/bin/env python
#coding:utf-8

class A:
    def __init__(self):
        print "aaa"

class B(A):
    def __init__(self):
        A.__init__(self)    #运行继承的父类
        print "bbb"

if __name__=="__main__":
    a = A()
    b = B()
