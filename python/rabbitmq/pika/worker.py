#coding:utf-8
import time,pika

connection = pika.BlockingConnection(pika.ConnectionParameters('localhost'))
channel = connection.channel()
# channel.queue_declare(queue='hello')
channel.queue_declare(queue='task_queue', durable=True)
def callback(ch,method,properties,body):
    print( " [x] Received %r"%(body,))
    time.sleep(body.count('.'))
    print("[x] Done")
    ch.basic_consume(delivery_tag = method.delivery_tag)

#在接收到该Consumer的ack前，他它不会将新的Message分发给它
channel.basic_qos(prefetch_count=1)
#,no_ack=True
channel.basic_consume(callback,queue='hello')
print(' [*] Waiting for messages. To exit press CTR+C')
channel.start_consuming()