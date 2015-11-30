# -*- coding: utf-8 -*-
# CopyRight by heibanke
import time
import random
from threading import Thread
from multiprocessing import Process
def sleepsort(n):
    time.sleep(n*0.01)
    print n,"--",

def thread_process_job(n, Thread_Process, job, value):
    local_time=time.time()
    threads_or_processes = [Thread_Process(target=job,args=(value[i],)) for i in xrange(n)]
    for t in threads_or_processes:
        t.start()
    for t in threads_or_processes:
        t.join()

    print n,Thread_Process.__name__," run job need ",time.time()-local_time

if __name__=="__main__":
    sort_list = [random.randint(1,40) for i in xrange(10)]
    print "Multi Threads"
    for i in xrange(5):
        sort_list = [random.randint(1,40) for i in xrange(10)]
        thread_process_job(len(sort_list),Thread, sleepsort, sort_list)

    print "Multi Process"
    for i in xrange(5):
        sort_list = [random.randint(1,40) for i in xrange(10)]
        thread_process_job(len(sort_list),Process, sleepsort,sort_list)