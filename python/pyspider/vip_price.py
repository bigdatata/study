#!/usr/bin/env python
# -*- encoding: utf-8 -*-
# Created on 2015-11-19 18:09:09
# Project: vip_price

from pyspider.libs.base_handler import *


class Handler(BaseHandler):
    crawl_config = {
        'headers':{
            'User-Agent':'Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/46.0.2490.80 Safari/537.36',
        }
    }

    @every(minutes=2 * 60)
    def on_start(self):
        self.crawl('http://vip.jd.com/price.html',fetch_type='js',callback=self.index_page)

    @config(age=2 * 60 * 60)
    def index_page(self, response):
        for item in response.doc('.j-price > li').items():
            itemDetailUrl = item.find('.img a').attr('href')
            vipPrice = item.find('.price-p strong').text()
            jdPrice = item.find('.price-p del del').text()
            self.crawl(itemDetailUrl,fetch_type='js',save={'vipPrice':vipPrice,'jdPrice':jdPrice,'pageUrl':response.url}, callback=self.detail_page)
        for each in response.doc('.p-num a[href^="http"]').items():
            self.crawl(each.attr.href,fetch_type='js', callback=self.index_page)

    @config(priority=2)
    def detail_page(self, response):
        return {
            "url":response.url ,
            "title":response.doc('title').text()[:12],
            "detailPrice": response.doc('#summary-price .dd .p-price').text(),
            'vipPrice':response.save['vipPrice'],
            'jdPrice':response.save['jdPrice'],
            'pageUrl':response.save['pageUrl'],
        }
