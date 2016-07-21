__author__ = 'luotao'

import re

def display_match(match):
    result = None
    if match is not None:
        result = '<Match: %r, groups=%r>'%(match.group(),match.groups())
    print(result)

# (...)
# Matches whatever regular expression is inside the parentheses, and indicates the start and end of a group;
m = re.match('(\w+),(\w+)',"hello,world,welcome")
display_match(m)

# (?P<name>...)
# Similar to regular parentheses, but the substring matched by the group is accessible via the symbolic group name name.
# (?P=name)
# A backreference to a named group; it matches whatever text was matched by the earlier group named name.
m = re.search('(?P<quote>[\'"]).*?(?P=quote)',"'hello world'")
print(m.group('quote'))
display_match(m)

# (?#...)
# A comment; the contents of the parentheses are simply ignored.
m = re.search('Isaac(?#find Isaac)', 'Isaac Asimov')
display_match(m)

# (?=...)
# Matches if ... matches next, but doesn't consume any of the string.
m = re.search('Isaac (?=Asimov)', 'Isaac Asimov')
display_match(m)
# (?!...)
# Matches if ... doesn't match next
m = re.search('Isaac(?!Asimov)', 'Isaac Asimov')
display_match(m)

# (?<=...)
# Matches if the current position in the string is preceded by a match for ... that ends at the current position.
m = re.search('(?<=-)\w+', 'spam-egg')
display_match(m)

# (?<!...)
# Matches if the current position in the string is not preceded by a match for ...
m = re.search('(?<!-)\w+', 'spam-egg')
display_match(m)
# valid = re.
