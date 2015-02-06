package com.study;

import com.google.common.collect.Lists;
import com.google.common.primitives.Booleans;
import com.google.common.primitives.Doubles;
import org.junit.Test;

import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-4-9
 * Time: 下午5:30
 * To change this template use File | Settings | File Templates.
 */
public class PrimitiveStudy {

    /***
     * concat,indexof,lastindexof contains
     * bytes,chars,booleans 基本相同
     */
    @Test
    public void test01(){
        Booleans.asList(false,true,false);
        Booleans.compare(false,true);
    }

    @Test
    public void test02(){
        double[] aDouble={2.0,3.0,4.0,2.0};
        double[] bDouble={4.0,5.0,6.0};
        List<Double> list= Lists.newArrayList(2.0,3.0,4.0,2.0);

        Doubles.asList(2,3,4,5,6);
        Doubles.compare(2,3);

        Doubles.asList(Doubles.concat(aDouble,bDouble));

        Doubles.contains(aDouble,2.0);

        Doubles.indexOf(aDouble,2.0);

        Doubles.lastIndexOf(aDouble,2.0);

        Doubles.max(aDouble);

        Doubles.min(aDouble);

        Doubles.toArray(list);

        Doubles.join("::",aDouble);
    }
}
