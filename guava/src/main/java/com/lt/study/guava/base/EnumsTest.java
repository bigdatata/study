package com.lt.study.guava.base;

import com.google.common.base.Enums;
import com.google.common.base.Function;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-8-8
 * Time: 下午2:09
     将String转化成已有的ENUM
     传统java使用的是emum.valueOf(str);
     现在guava可以这样用

 */
public class EnumsTest {
    private enum TestEnum{
        CHEETO,HONDA,POODLE,
    }

    public void testValueOfFunction(){
        Function<String,TestEnum> function= Enums.valueOfFunction(TestEnum.class);
//        Assert.assertEquals(TestEnum.CHEETO, function.apply("CHEETO"));
//        Assert.assertEquals(TestEnum.HONDA, function.apply("HONDA"));
//        Assert.assertEquals(TestEnum.POODLE, function.apply("POODLE"));
    }
//    @Test
    public void test(){
        int n=6;
//        n <<= 1;
        System.out.println(n);
    }
}
