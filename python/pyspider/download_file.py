__author__ = 'luotao'

import shutil

import requests

url = 'http://img1.gtimg.com/ninja/1/2015/11/ninja144739858144348.jpg'
response = requests.get(url, stream=True)
with open('ninja144739858144348.jpg', 'wb') as out_file:
    shutil.copyfileobj(response.raw, out_file)
del response