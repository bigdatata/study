#list

#empty list
list = [] #define a list 
print type(list)
print bool(list)
#list with elements
list = ['2',3,'qiwsir.github.io']
print type(list)
print bool(list)

# list element
print list[2]
# list append
list.append("like")
list.append(100)
print list

#list.append(x)
#Add an item to the end of the list; equivalent to a[len(a):] = [x].
list[len(list):]=[3]
print list

#list.extend(L)
#Extend the list by appending all the items in the given list; equivalent to a[len(a):] = L.
la=[1,2,3]
lb=["1212","1212121"]
la.extend(lb)
print la

la=[1,2,3]
b ="adc"
la.extend(b)
#[1, 2, 3, 'a', 'd', 'c']
print la
#  TypeError: 'int' object is not iterable
#la.extend(5)

la[len(la):]=lb
print la

#extend vs append
lst = [1,2,3]
lst.append(["qiwsir","github"])
print lst

lst = [1,2,3]
lst.extend(["121","wad"])
print lst

#list.count(x)
#Return the number of times x appears in the list.
la = [1,2,1,1,3]
print la.count(1)
la.append('a')
la.append('a')
print la.count('a')

#list.index(x)
#Return the index in the list of the first item whose value is x. 
#It is an error if there is no such item.

print la.index(3)
#ValueError: 4 is not in list
#print la.index(4)

#list.insert(i, x)
#Insert an item at a given position. 
#The first argument is the index of the element before which to insert, 
#so a.insert(0, x) inserts at the front of the list, 
#and a.insert(len(a), x) is equivalent to a.append(x).

all_users = ['qiwsir', 'github', 'io']
all_users.insert(0,"python")
all_users.insert(1,"http://")
all_users.insert(len(all_users),"algorithm")
print all_users

#list.remove(x)
#Remove the first item from the list whose value is x. 
#It is an error if there is no such item.
all_users.remove("http://")
print all_users
#ValueError: list.remove(x): x not in list
#all_users.remove("tianchao")


#list.pop([i])
#Remove the item at the given position in the list, and return it. 
#If no index is specified, a.pop() removes and returns the last item in the list.

print  all_users.pop()
print all_users

#range(start, stop[, step])
print range(9)
print range(0,9)
print range(0,9,1)
print range(0,9,2)
print range(-9)
print range(0,-9)
print range(0,100,2)

#list.sort(cmp=None, key=None, reverse=False)
#sorted(iterable[, cmp[, key[, reverse]]])

number = [1,4,6,2,9,7,3]
number.sort()
print number

number = [1,4,6,2,9,7,3]
print sorted(number)
print number

number = [1,4,6,2,9,7,3]
number.sort(reverse=True)
print number

number = [1,4,6,2,9,7,3]
print sorted(number,reverse=True)
print number























