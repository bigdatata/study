__author__ = 'luotao'

#Accessing arguments by position:
print("{},{},{}".format('a','b','c'))
print("{2},{1},{0}".format('a','b','c'))
# unpacking argument sequence
print("{2},{1},{0}".format(*'abc'))
# arguments' indices can be repeated
print("{0},{1},{0}".format('abra', 'cad'))

# Accessing arguments by attributes:
print('Coordinates: {latitude}, {longitude}'.format(latitude='37.24N', longitude='-115.81W'))
coord = {'latitude': '37.24N', 'longitude': '-115.81W'}
print('Coordinates: {latitude}, {longitude}'.format(**coord))

# Accessing arguments' attributes:
c = 3-5j
print(('The complex number {0} is formed from the real part {0.real} '
       + 'and the imaginary part {0.imag}.').format(c))

class Point(object):
    def __init__(self, x, y):
        self.x,self.y=x,y
    def __str__(self):
        return 'Point({self.x},{self.y})'.format(self=self)

print(str(Point(1, 2)))

# Accessing arguments' items:
coord = (3,5)
print('X: {0[0]}; Y: {0[1]}'.format(coord))

# Replacing %s and %r:
print("repr() shows quotes: {!r}; str() doesn't: {!s}".format('test1', 'test2'))

# Aligning the text and specifying a width:
print('{:<30}'.format('left aligned'))
print('{:>30}'.format('right aligned'))
print('{:^30}'.format('center'))
# use '*' as a fill char
print('{:*^30}'.format('center'))

# Replacing %+f, %-f, and % f and specifying a sign:
# show it always
print('{:+f}; {:+f}'.format(3.14, -3.14))
# show a space for positive numbers
print('{: f}; {: f}'.format(3.14, -3.14))
print('{:f}; {:f}'.format(3.14, -3.14))
# show only the minus -- same as '{:f}; {:f}'
print('{:-f}; {:-f}'.format(3.14, -3.14))

# Replacing %x and %o and converting the value to different bases:
print('int: {0:d};  hex: {0:x};  oct: {0:o};  bin: {0:b}'.format(42))
# with 0x, 0o, or 0b as prefix:
print("int: {0:d};  hex: {0:#x};  oct: {0:#o};  bin: {0:#b}".format(42))

# Using the comma as a thousands separator:
print('{:,}'.format(1234567890))

# Expressing a percentage:
print('{:%}'.format(19.5/22))
print('{:.2%}'.format(19.5/22))

# Using type-specific formatting:
import datetime
date = datetime.datetime(2010,7,4,12,15,58)
print('{:%Y-%m-%d %H:%M:%S}'.format(date))

# Nesting arguments and more complex examples:
for align,text in zip('<^>',['left','center','right']):
    print('{0:{fill}{align}16}'.format(text,fill=align,align=align))

width = 5
for num in range(5,12):
    for base in 'dXob':
        print('{0:#{width}{base}}'.format(num,base=base,width=width)),
    print


