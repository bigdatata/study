http://doc.scrapy.org/en/latest/intro/install.html

pip install Scrapy

scrapy 报错 no module named win32api 的解决方案
解决方案：
原因是缺少win32,到 http://sourceforge.net/projects/pywin32/files/

找到对应的版本进行下载，直接安装即可

2.Trying Selectors in the Shell
scrapy shell "http://www.dmoz.org/Computers/Programming/Languages/Python/Books/"
Remember to always enclose urls in quotes when running Scrapy shell from command-line, otherwise urls containing arguments (ie. & character) will not work.

3. http://scrapy-chs.readthedocs.org/zh_CN/latest/intro/tutorial.html
