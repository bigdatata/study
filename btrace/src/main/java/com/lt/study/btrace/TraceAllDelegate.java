package com.lt.study.btrace;

/**
 * User: cdluotao1
 * Date: 14-10-15
 * Time: 上午11:40
 */
import com.sun.btrace.BTraceUtils;
import com.sun.btrace.annotations.*;

import static com.sun.btrace.BTraceUtils.*;

@BTrace
public class TraceAllDelegate {

    @TLS
    private static long startTime = 0;

    @OnMethod(clazz = "/com//.crm//.components//..*Delegate.*/",
            method = "/.*/")
    public static void startMethod(){
        startTime = BTraceUtils.timeMillis();
    }

    @OnMethod(clazz = "/com//.crm//.components//..*Delegate.*/",
            method = "/.*/", location = @Location(Kind.RETURN))
    public static void endMethod(){
        println(strcat("time taken=>",str(BTraceUtils.timeMillis()-startTime)));
        println("--------------------------------------");
    }

    @OnMethod(clazz = "/com//.crm//.components//..*Delegate.*/",
            method = "/.*/", location = @Location(Kind.RETURN))
    public static void print(@ProbeClassName String pcn,@ProbeMethodName String pmn) {
        println(pcn);
        println(pmn);
    }
}

