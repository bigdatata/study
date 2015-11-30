# -*- coding: utf-8 -*-
import scrapy


class VipPriceSpider(scrapy.Spider):
    name = "vip_price"
    allowed_domains = ["vip.jd.com"]
    start_urls = (
        'http://www.vip.jd.com/price.html',
    )

    def parse(self, response):
        pass
