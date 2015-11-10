#list-str

#same 
welcome_str = "Welcome you"
print welcome_str[0]
print welcome_str[:4] 
a = "python"
print a*3
print 3*a
print len(welcome_str)
print "hello world"+","+welcome_str

git_list = ["qiwsir","github","io"]
print git_list[0]
print git_list[0:2]
b = ['qiwsir']
print b*7
print len(git_list)
print ['python']+git_list

#diff
#list can change,while str can not

#multi list
matrix = [[1,2,3],[4,5,6],[7,8,9]]
print matrix
print matrix[0][1]
print matrix[1]

# str to list
#str.split()
#split(...) S.split([sep [,maxsplit]]) -> list of strings
#Return a list of the words in the string S, using sep as the delimiter string.
#If maxsplit is given, at most maxsplit splits are done. If sep is not specified or is None,
#any whitespace string is a separator and empty strings are removed from the result.
line = "Hello.I am qiwsir.Welcome you."
print line.split(".") 
line.split(".",1)

#list to str
#"[sep]".join(list)
print "".join(['Albert', 'Ainstain'])  
print ".".join(['Albert', 'Ainstain'])  
print " ".join(['Albert', 'Ainstain'])  

s = "I am, writing\npython\tbook on line"
print s
print " ".join(s.split())
