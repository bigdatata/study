__author__ = 'luotao'

def foo(x,y=2,*targs,**dargs):
    print("x==>",x)
    print("y==>",y)
    print("targs_tuple==>",targs)
    print("dargs_dict==>",dargs)

foo("1x")

foo("1x","2y")

foo("1x","2y","3t1","3t2")

foo("1x","2y","3t1","3t2",d1="4d1",d2="4d2")