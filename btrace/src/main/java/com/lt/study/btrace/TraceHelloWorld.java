package com.lt.study.btrace;

/**
 * User: cdluotao1
 * Date: 14-10-15
 * Time: 上午11:03
 * @see http://blog.csdn.net/qyongkang/article/details/6090497
 */
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;
@BTrace
public class TraceHelloWorld {

    @TLS
    private static long startTime = 0;

    @OnMethod(clazz = "com.lt.study.btrace.HelloWorld", method = "execute")
    public static void startMethod(){
        startTime = timeMillis();
    }

    @OnMethod(clazz = "com.lt.study.btrace.HelloWorld", method = "execute", location = @Location(Kind.RETURN))
    public static void endMethod(){
        println(strcat("the class method execute time=>", str(timeMillis()-startTime)));
        println("-------------------------------------------");
    }

    @OnMethod(clazz = "com.lt.study.btrace.HelloWorld", method = "execute", location = @Location(Kind.RETURN))
    public static void traceExecute(@ProbeClassName String name,@ProbeMethodName String method,int sleepTime){
        println(strcat("the class name=>", name));
        println(strcat("the class method=>", method));
        println(strcat("the class method params=>", str(sleepTime)));

    }
}

