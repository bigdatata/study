from pyquery import  PyQuery as pyQuery

p = pyQuery('<p id="hello" class="hello"></p>')('p')
print(p.attr('id'))
print(p.attr("id", "plop"))
print(p.attr("id", "hello"))

# more python way
p.attr.id ="plop"
print(p.attr.id)
p.attr['id']="ola"
print(p.attr['id'])
p.attr(id="hello",class_="hello2")
print(repr(p))
p.attr.class_ ="hello"
print(repr(p))
