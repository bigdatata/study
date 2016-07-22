package com.lt.log;

/**
 * Created by luotao on 2016/5/16.
 */
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class TestLogBySlf4J {
    Logger logger = LoggerFactory.getLogger(TestLogBySlf4J.class);

    @Test
    public void print() {
        logger.info("hello world");
        logger.info("My name is {}， I am {} years old.", "name", 12);
    }

}
