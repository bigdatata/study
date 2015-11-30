1.http://www.tornadoweb.org/en/stable/
Tornado is a Python web framework and asynchronous networking library, originally developed at FriendFeed.
By using non-blocking network I/O, Tornado can scale to tens of thousands of open connections, making it ideal for
long polling, WebSockets, and other applications that require a long-lived connection to each user.
2.https://github.com/tornadoweb/tornado/tree/stable/demos
3.中文 http://www.tornadoweb.cn/documentation
模块索引
最重要的一个模块是web， 它就是包含了 Tornado 的大部分主要功能的 Web 框架。其它的模块都是工具性质的， 以便让 web 模块更加有用 后面的 Tornado 攻略 详细讲解了 web 模块的使用方法。

主要模块
web - FriendFeed 使用的基础 Web 框架，包含了 Tornado 的大多数重要的功能
escape - XHTML, JSON, URL 的编码/解码方法
database - 对 MySQLdb 的简单封装，使其更容易使用
template - 基于 Python 的 web 模板系统
httpclient - 非阻塞式 HTTP 客户端，它被设计用来和 web 及 httpserver 协同工作
auth - 第三方认证的实现（包括 Google OpenID/OAuth、Facebook Platform、Yahoo BBAuth、FriendFeed OpenID/OAuth、Twitter OAuth）
locale - 针对本地化和翻译的支持
options - 命令行和配置文件解析工具，针对服务器环境做了优化
底层模块
httpserver - 服务于 web 模块的一个非常简单的 HTTP 服务器的实现
iostream - 对非阻塞式的 socket 的简单封装，以方便常用读写操作
ioloop - 核心的 I/O 循环