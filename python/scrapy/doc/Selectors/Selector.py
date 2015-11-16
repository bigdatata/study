__author__ = 'luotao'

from scrapy.selector import Selector
from scrapy.http import HtmlResponse

# Constructing from text:
body = '<html><body><span>good</span></body></html>'
print(Selector(text=body).xpath('//span/text()').extract())
# Constructing from response:
response = HtmlResponse(url='http://www.jd.com', body=body)
print(Selector(response=response).xpath('//span/text()').extract())
print(response.selector.xpath('//span/text()').extract())