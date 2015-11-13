from pyquery import  PyQuery as pyQuery

p = pyQuery('<p id="hello" class="hello"></p>')('p')
p.addClass("todo")
print(repr(p))
p.toggleClass("titi toto")
print(repr(p))
p.removeClass("titi")
print(repr(p))

p.css("front-size","15px")
print(repr(p))
print(p.attr('style'))
p.css({"front-size":"17px"})
print(repr(p))
print(p.attr('style'))

# same the python way
p.css.front_size="15px"
print(p.attr.style)
p.css["front-size"] = "15px"
print(p.attr.style)
p.css(front_size="16px")
p.css = {"front-size":"15px"}
print(p.attr.style)


