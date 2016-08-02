package com.lt.study.kafka;

import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.Producer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.junit.Test;

import java.util.Properties;

/**
 * Created by xionger on 2016/8/2.
 */
public class KafkaProducerTest {
    @Test
    public void test(){
        Properties props = new Properties();
        props.put("bootstrap.servers", "localhost:9094");
        props.put("acks", "all");
        props.put("retries", 0);
        props.put("batch.size", 16384);
        props.put("linger.ms", 1);
        props.put("buffer.memory", 33554432);
        props.put("key.serializer", "org.apache.kafka.common.serialization.StringSerializer");
        props.put("value.serializer", "org.apache.kafka.common.serialization.StringSerializer");

        Producer<String, String> producer = new KafkaProducer(props);
        for(int i = 0; i < 100; i++){
            producer.send(new ProducerRecord<String, String>("foo", Integer.toString(i), Integer.toString(i)));
            producer.send(new ProducerRecord<String, String>("bar", Integer.toString(i), Integer.toString(i)));
        }
        producer.close();
    }
}
