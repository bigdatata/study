package com.lt.study.btrace;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-10-15
 * Time: 上午11:34
 * To change this template use File | Settings | File Templates.
 */
import com.sun.btrace.annotations.BTrace;

import static com.sun.btrace.BTraceUtils.*;
@BTrace
public class TraceJInfo {
    static{
        println("java vm properties:===>");
        printVmArguments();
        println("System properties:===>");
        printProperties();
        println("OS properties:===>");
        printEnv();
        exit();
    }
}

