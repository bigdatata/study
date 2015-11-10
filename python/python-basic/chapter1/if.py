#! /user/bin/env python
#coding:utf-8

print "please write a number:"

number = int(raw_input())

if number ==10:
	print "you are smart"
elif number > 10:
	print "this number is more than 10."
elif number < 10:
	print "this number is less than 10."
else:
	print "Are you human?"
print "your input number is %d"%number