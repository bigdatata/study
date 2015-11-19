#coding:utf-8
from pyquery import  PyQuery as pyQuery

p = pyQuery('<p id="hello" class="hello"></p>')('p')
print(p.attr('id'))
print(p.attr("id", "plop"))
print(p.attr("id", "hello"))

# more python way
p.attr.id ="plop"
print(p.attr.id)
p.attr['id']="ola"
print(p.attr['id'])
p.attr(id="hello",class_="hello2")
print(repr(p))
p.attr.class_ ="hello"
print(repr(p))

item = pyQuery('<li class="ls-disc-li jpriced" levenum="56" fsid="1591295333" fpid="1729504036">'+
               '<div class="img"> '+
               '<a target="_blank" href="//item.jd.com/1591295333.html"><img title="鸿星尔克男鞋夏秋防滑减震耐磨休闲鞋系带低帮MD大底运动鞋男 孔雀蓝/正黄. 41" alt="鸿星尔克男鞋夏秋防滑减震耐磨休闲鞋系带低帮MD大底运动鞋男 孔雀蓝/正黄. 41" src="//img14.360buyimg.com/n7/jfs/t1342/63/1413028126/240422/f6459617/55c45c99Nfb7344a0.jpg" data-lazyload="done"></a>'+
               '</div>  '+
               '<h3 class="title"><a target="_blank" href="//item.jd.com/1591295333.html" title="鸿星尔克男鞋夏秋防滑减震耐磨休闲鞋系带低帮MD大底运动鞋男 孔雀蓝/正黄. 41">鸿星尔克男鞋夏秋防滑减震耐磨休闲鞋系带低帮MD大底运动鞋男 孔雀蓝/正黄. 41</a></h3>'+
               '<p class="price-p">￥<strong>279</strong><del>京东价：<del>￥279</del></del></p>   '+
               '<p class="rank">   '+
               '<em>专享会员：</em>        '+
               '<i class="rank18 rank18-2" title="铜牌会员"></i>  '+
               '<i class="rank18 rank18-3" title="银牌会员"></i>  '+
               '<i class="rank18 rank18-4" title="金牌会员"></i>  '+
               '<i class="rank18 rank18-5" title="钻石会员"></i> '+
               '</p> '+
               '<p class="btns"><a class="addToCart" skid="1591295333" href="http://cart.jd.com/cart/dynamic/gate.action?pid=1591295333&amp;pcount=1&amp;ptype=1" target="_blank">加入购物车</a></p>'+
               '</li>')

text = item.find('.price-p').text()
itemDetailUrl = item.find('.img a').attr('href')
vipPrice = item.find('.price-p strong').text()
jdPrice = item.find('.price-p del del').text()[3:]
print(text)
