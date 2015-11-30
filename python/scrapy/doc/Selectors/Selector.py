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

body="""
  <html>
 <head>
  <base href='http://example.com/' />
  <title>Example website</title>
 </head>
 <body>
  <div id='images'>
   <a href='image1.html'>Name: My image 1 <br /><img src='image1_thumb.jpg' /></a>
   <a href='image2.html'>Name: My image 2 <br /><img src='image2_thumb.jpg' /></a>
   <a href='image3.html'>Name: My image 3 <br /><img src='image3_thumb.jpg' /></a>
   <a href='image4.html'>Name: My image 4 <br /><img src='image4_thumb.jpg' /></a>
   <a href='image5.html'>Name: My image 5 <br /><img src='image5_thumb.jpg' /></a>
  </div>
 </body>
</html>
"""

response = HtmlResponse(url='http://doc.scrapy.org/en/latest/_static/selectors-sample1.html', body=body)
print(response.selector.xpath("//title/text()"))
print(response.xpath('//title/text()'))
print(response.css('title::text'))
print(response.css('img').xpath('@src').extract())
print(response.css('img').xpath('@src').extract_first())
print(response.xpath('//div/[id="not-exists"]/text()').extract_first() is None)
print(response.css('title::text').extract())

print(response.xpath('//base/@href').extract())
print(response.css('base::attr(href)').extract())

print(response.xpath('//a[contains(@href, "image")]/@href').extract())
print(response.css('a[href*=image]::attr(href)').extract())
print(response.xpath('//a[contains(@href, "image")]/img/@src').extract())
print(response.css('a[href*=image] img::attr(src)').extract())

links = response.xpath('//a[contains(@href,"image")]')
print(links.extract())

for index,link in enumerate(links):
    args = (index,link.xpath('@href').extract(),link.xpath('img/@src').extract())


