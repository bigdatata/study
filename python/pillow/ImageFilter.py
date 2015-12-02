# -*- coding: utf-8 -*-
# ImageFilter模块
#
# ImageFilter是PIL的滤镜模块，当前版本支持9中加强滤镜，通过这些预定义的滤镜，可以方便的对图片进行一些过滤操作，从而去掉图片中的噪音(部分的消除)，这样可以降低将来处理的复杂度(如模式识别等)。
#
# 滤镜名称	含义
# ImageFilter.BLUR	模糊滤镜
# ImageFilter.CONTOUR	轮廓
# ImageFilter.EDGE_ENHANCE	边界加强
# ImageFilter.EDGE_ENHANCE_MORE	边界加强(阀值更大)
# ImageFilter.EMBOSS	浮雕滤镜
# ImageFilter.FIND_EDGES	边界滤镜
# ImageFilter.SMOOTH	平滑滤镜
# ImageFilter.SMOOTH_MORE	平滑滤镜(阀值更大)
# ImageFilter.SHARPEN	锐化滤镜
#
# 要使用PIL的滤镜功能，需要引入ImageFilter模块
__author__ = 'luotao'
from PIL import ImageFilter
from PIL import Image
import pytesser

import os
black, white = (0, 0, 0), (255, 255, 255)


def is_white(pix, threshold=120):
    return pix[0] > threshold


def set_white_or_black(image):
    pixdata = image.load()
    # if color != black, then set to white.
    for y in xrange(image.size[1]):
        for x in xrange(image.size[0]):
            if is_white(pixdata[x, y]):
                pixdata[x, y] = white
            else:
                pixdata[x, y] = black

    return image


def is_noise(pixdata, x, y):
    neighbor_white_count = 0
    for i in (x - 1, x, x + 1):
        for j in (y - 1, y, y + 1):
            try:
                if is_white(pixdata[i, j]):
                    neighbor_white_count = neighbor_white_count + 1
            except IndexError:
                neighbor_white_count = neighbor_white_count + 1
    return neighbor_white_count >=7


def remove_noise(image):
    pixdata = image.load()
    # Clean the background noise
    for y in xrange(image.size[1]):
        for x in xrange(image.size[0]):
            if is_white(pixdata[x, y]) | is_noise(pixdata, x, y):
                pixdata[x, y] = white
            else:
                pixdata[x, y] = black

    return image


def remove_line(image):
    threshold = 100
    pixdata = image.load()
    # Clean the background noise, if color != black, then set to white.
    for y in xrange(image.size[1]):
        for x in xrange(image.size[0]):
            if not (pixdata[x, y][0] > threshold and pixdata[x, y][1] > threshold and pixdata[x, y][2] > threshold):
                pixdata[x, y] = (0, 0, 0, 255)
            else:
                pixdata[x, y] = (255, 255, 255, 255)


image = Image.open('2.jpg')
image = remove_noise(image)
for i in xrange(5):
    image = remove_noise(image)
image.show()
print(pytesser.image_to_string(image))


