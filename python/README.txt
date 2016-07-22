idea python 插件
http://plugins.jetbrains.com/plugin/631

python-basic
https://www.gitbook.com/book/looly/python-basic/details

python-one-to-million
https://www.gitbook.com/book/kxxoling/python-one-to-million/details

pip install tornado


豆瓣的pip源真的很快!
    1. 创建一个配置文件 (文本文件).
　　linux/mac用户将它命名为pip.conf, windows用户将它命名为pip.ini. 文件中写如下内容:
　　[global]
　　timeout = 60
　　index-url = http://pypi.douban.com/simple
　　2. 将该文件放置在指定位置.
　　linux下指定位置为
　　$HOME/.config/pip/pip.conf
　　mac下指定位置为
　　$HOME/Library/Application Support/pip/pip.conf
　　windows下指定位置为
　　%APPDATA%\pip\pip.ini
　　其中$HOME指的是用户主目录
　　3.如果你使用了virtualenv, 那么配置文件应该放置在virtualenv生成的文件夹中.
pip install scipy --trusted-host pypi.douban.com

http://aka.ms/vcpython27

使用豆瓣的pypi源
pip install -i http://pypi.douban.com/simple/ scrapyd --trusted-host pypi.douban.com
pip install -i http://pypi.douban.com/simple/ pytesser --trusted-host pypi.douban.com

pip install -i http://pypi.douban.com/simple/  youtube-dl --trusted-host pypi.douban.com
pip upgrade -i http://pypi.douban.com/simple/  pyspider --trusted-host pypi.douban.com
http://sourceforge.net/projects/scipy/files/scipy/

