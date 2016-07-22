# -*- coding: utf-8 -*-
from __future__ import  print_function
import os, sys
from PIL import Image
from PIL import ImageFilter
image = Image.open('numberAndLetters.bmp')
print(image.format,image.size,image.mode)
image.show()
box = (100, 0, 400, 60)
region = image.crop(box)
region.show()
region = region.transpose(Image.ROTATE_180)
region.show
image.paste(region,box)
image.show()
# # Convert files to JPEG
# for infile in sys.argv[1:]:
#     f, e = os.path.splitext(infile)
#     outfile = f + ".jpg"
#     if infile != outfile:
#         try:
#             Image.open(infile).save(outfile)
#         except IOError:
#             print("cannot convert", infile)
