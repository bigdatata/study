1.安装python 2.7

2.安装 pycurl
    下载 最新版本的pycurl安装
    https://pypi.python.org/pypi
    http://pycurl.sourceforge.net/download/

3.安装 pyspider pip install pyspider
    运行pyspider run command pyspider, visit http://localhost:5000/

4.安装 PhantomJS
    phantomjs-2.0.0-windows.zip
    http://npm.taobao.org/mirrors/phantomjs
    http://phantomjs.org/download.html
    add to path D:\softinstall\phantomjs-2.0.0-windows\bin

Render with PhantomJS
    pyspider phantomjs     Web server running on port 25555
    pyspider

Deployment
    pip install --allow-all-external pyspider[all]
    1.http://www.rabbitmq.com/download.html
    http://www.erlang.org/download/otp_win64_18.1.exe

    config.json
    Although you can use command-line to specify the parameters. A config file is a better choice.
    {
      "taskdb": "mysql+taskdb://username:password@host:port/taskdb",
      "projectdb": "mysql+projectdb://username:password@host:port/projectdb",
      "resultdb": "mysql+resultdb://username:password@host:port/resultdb",
      "message_queue": "amqp://username:password@host:port/%2F",
      "webui": {
        "username": "some_name",
        "password": "some_passwd",
        "need-auth": true
      }
    }

    # start **only one** scheduler instance
    pyspider -c config.json scheduler

    # phantomjs
    pyspider -c config.json phantomjs

    # start fetcher / processor / result_worker instances as many as your needs
    pyspider -c config.json --phantomjs-proxy="localhost:25555" fetcher
    pyspider -c config.json processor
    pyspider -c config.json result_worker

    # start webui, set `--scheduler-rpc` if scheduler is not running on the same host as webui
    pyspider -c config.json webui


