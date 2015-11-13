__author__ = 'luotao'
#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2015-11-13 09:41:38
# Project: news_sc_sina

from pyspider.libs.base_handler import *


class Handler(BaseHandler):
    crawl_config = {
        "Accept":"text/html,application/xhtml+xml,application/xml;q=0.9,image/webp,*/*;q=0.8",
        "Accept-Encoding":"gzip, deflate, sdch",
        "Accept-Language":"zh-CN,zh;q=0.8",
        "Cache-Control":"max-age=0",
        "Connection":"keep-alive",
        "User-Agent":"Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/41.0.2272.101 Safari/537.36"
    }

    @every(minutes=24 * 60)
    def on_start(self):
        self.crawl('http://sc.sina.com.cn/news/b/list.shtml', callback=self.index_page)

    @config(age=10 * 24 * 60 * 60)
    def index_page(self, response):
        for each in response.doc('ul.nav.clear li:not(.cur) a[href^="http"]').items():
            self.crawl(each.attr.href, callback=self.index_page)
        for each in response.doc('.news-list a[href^="http"]').items():
            self.crawl(each.attr.href, callback=self.detail_page)

    @config(priority=2)
    def detail_page(self, response):
        return {
            "url": response.url,
            "title": response.doc('title').text(),
            "content": response.doc('div.main-body').text(),
        }
