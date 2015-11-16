#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2015-11-16 16:44:00
# Project: lagou

from pyspider.libs.base_handler import *

class Handler(BaseHandler):
    crawl_config = {
    }

    @every(minutes=10)
    def on_start(self):
        self.crawl('http://www.lagou.com/jobs/positionAjax.json?gj=1-3%E5%B9%B4&px=default&yx=13k-25k&city=%E6%88%90%E9%83%BD',callback=self.index_page)

    @config(age=24 * 60 * 60)
    def index_page(self, response):
        totalPageCount = int(response.json['content']['totalPageCount'])
        for pageNo in range(1,totalPageCount+1):
            self.crawl(response.url, method='POST', params={'pn': pageNo},data={'pn': pageNo},callback=self.detail_page)

    @config(priority=2)
    def detail_page(self, response):
        for i, each in enumerate(response.json['content']['result']):
            self.send_message(self.project_name,each, url="%s#%s" % (response.url, i))

    def on_message(self, project, msg):
        return msg