#!/usr/bin/env python
#coding:utf-8

class Person:
    def __init__(self,name,lang="golang", website="www.google.com"):
        self.name = name
        self.lang = lang
        self.website = website
        self.email = "qiwsir@gmail.com"
        print(self)
        print(type(self))

    def author(self):
        return self.name
    def author1(self, address):
        return self.name+" in "+address

class Programmer(Person):       #继承父类Person
    def __init__(self, name, lang, email, system, website):
        Person.__init__(self,name,lang,email)   #将Person.__init__()的功能继承到这里
        #self.name = name                       #这三句是Person中已经搞定的，就不用重复
        #self.lang = lang                       #通过继承已经实现了这三句的功能
        #self.email = email
        self.system = system                    #子类中不同于Person父类部分
        self.website = website

    def pythoner(self):
        pythoner_list = [ self.name, self.lang, self.email, self.system, self.website ]
        return pythoner_list
#
# laoqi = Person("LaoQi")
# info = Person("qiwsir","python","qiwsir.github.com")
# print(info.name,info.lang,info.website)
# print(info.author())
#
# print(info.author1("suzhou"))
if __name__=="__main__":
    writer = Person("qiwsir","Chinese","qiwsir@gmail.com")
    python = Programmer("qiwsir","Python","qiwsir@gmail.com","Ubutun","qiwsir.github.io")
    print "My name is:%s"%writer.author()
    print "I write program by:%s"%python.pythoner()[1]