__author__ = 'luotao'

from string import Template

s = Template('$who likes $what')
print(s.substitute(who='tim',what='book'))
d = dict(who='tim')
# print(s.substitute(d)) KeyError: 'what'

print(Template('$who likes $what').safe_substitute(d))