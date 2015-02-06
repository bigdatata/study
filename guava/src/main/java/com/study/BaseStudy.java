package com.study;

import com.google.common.base.*;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Maps;
import org.junit.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.ArrayList;
import static  org.junit.Assert.*;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-4-9
 * Time: 上午11:32
 * To change this template use File | Settings | File Templates.
 */
public class BaseStudy {

    protected final Logger log = LoggerFactory.getLogger(getClass());
    private enum TestEnum{
        CHEETO,HONDA,POODLE,
    }

    @Test
    public void testValueOfFunction(){
        Function<String,TestEnum> function= Enums.valueOfFunction(TestEnum.class);
        Assert.assertEquals(TestEnum.CHEETO, function.apply("CHEETO"));
        Assert.assertEquals(TestEnum.HONDA, function.apply("HONDA"));
        Assert.assertEquals(TestEnum.POODLE, function.apply("POODLE"));
    }

    @Test
    public void test03(){
        Map<String,String> map=new LinkedHashMap<String,String>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        StringBuilder stringBuilder=new StringBuilder();
        for(Map.Entry<String,String> entry:map.entrySet()){
            stringBuilder.append(entry.getKey()).append(":").append(entry.getValue()).append(";");
        }
        log.info(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
    }

    @Test
    public void test28(){
        Map<String,String> map=new LinkedHashMap<String,String>();
        map.put("a","aa");
        map.put("b","bb");
        map.put("c","cc");
        Joiner.MapJoiner joiner=Joiner.on(";").withKeyValueSeparator(":");
        log.info(joiner.join(map));
    }

    @Test
    public void test(){
        Joiner.MapJoiner joiner=Joiner.on(";").withKeyValueSeparator(":");
        Assert.assertEquals("",joiner.join(ImmutableMap.of()));
        Assert.assertEquals(":",joiner.join(ImmutableMap.of("","")));
        Assert.assertEquals("a:b;c:d",joiner.join(ImmutableMap.of("a","b","c","d")));
        Map<String,String> mapWithNulls= Maps.newLinkedHashMap();
        mapWithNulls.put("a",null);
        mapWithNulls.put(null,"b");
        log.info(mapWithNulls.toString());

        try {
            joiner.join(mapWithNulls);
            Assert.fail();
        } catch (NullPointerException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        Assert.assertEquals("a:00;00:b",joiner.useForNull("00").join(mapWithNulls));
        StringBuilder sb=new StringBuilder();
        joiner.appendTo(sb,ImmutableMap.of(1,2,3,4,5,6));
        Assert.assertEquals("1:2;3:4;5:6", sb.toString());
    }

    @Test
    public void test06(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        log.info(list.toString().substring(1,list.toString().length()-1));
    }
    @Test
    public void test07(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        StringBuilder stringBuilder=new StringBuilder();
        for(String str:list){
            stringBuilder.append(",");
        }
        log.info(stringBuilder.deleteCharAt(stringBuilder.length()-1).toString());
    }
    @Test
    public void test08(){
        List<String> list=new ArrayList<String>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        log.info(Joiner.on(",").join(list));
    }

    @Test
    public void testEqual() throws Exception{
        Assert.assertTrue(Objects.equal(1,1));
        Assert.assertTrue(Objects.equal(null, null));
        String s1="foobar";
        String s2=new String(s1);
        Assert.assertTrue(Objects.equal(s1,s2));
        Assert.assertFalse(Objects.equal(s1,null));
        Assert.assertFalse(Objects.equal(null,s1));
        Assert.assertFalse(Objects.equal("foo","bar"));
        Assert.assertFalse(Objects.equal("1",1));
    }

    @Test
    public void testFirstNonNull_withNonNull() throws Exception{
        String s1="foo";
        String s2=Objects.firstNonNull(s1,"bar");
        Assert.assertSame(s1,s2);
        Long n1=new Long(42);
        Long n2=Objects.firstNonNull(null,n1);
        Assert.assertSame(n1,n2);
    }
    /***
     * Strings
     */
     @Test
    public void testNullToEmpty(){
         Assert.assertEquals("", Strings.nullToEmpty(null));
         Assert.assertEquals("",Strings.nullToEmpty(""));
         Assert.assertEquals("a",Strings.nullToEmpty("a"));
     }

    @Test
    public void testPadStart_somePadding(){
        Assert.assertEquals("-",Strings.padStart("",1,'-'));
        Assert.assertEquals("--",Strings.padStart("",2,'-'));
        Assert.assertEquals("-x",Strings.padStart("x",2,'-'));
        Assert.assertEquals("--x",Strings.padStart("x",3,'-'));
        Assert.assertEquals("-xx",Strings.padStart("xx",3,'-'));
    }
    @Test
    public void testPadEnd_somePadding(){
        Assert.assertEquals("-",Strings.padEnd("",1,'-'));
        Assert.assertEquals("--",Strings.padEnd("",2,'-'));
        Assert.assertEquals("x-",Strings.padEnd("x",2,'-'));
        Assert.assertEquals("x--",Strings.padEnd("x",3,'-'));
        Assert.assertEquals("xx-",Strings.padEnd("xx",3,'-'));
    }

    @Test
    public void testRepeat(){
        String input="20";
        Assert.assertEquals("",Strings.repeat(input,0));
        Assert.assertEquals("20",Strings.repeat(input,1));
        Assert.assertEquals("2020",Strings.repeat(input,2));
        Assert.assertEquals("202020",Strings.repeat(input,3));
    }

    public void testCommonPrefix(){
        Assert.assertEquals("",Strings.commonPrefix("",""));
        Assert.assertEquals("",Strings.commonPrefix("abc",""));
        Assert.assertEquals("",Strings.commonPrefix("","abc"));
        Assert.assertEquals("",Strings.commonPrefix("abcde","xyz"));
        Assert.assertEquals("a",Strings.commonPrefix("abcde","aaaaa"));
        Assert.assertEquals("aa",Strings.commonPrefix("aa","aaaaa"));
        Assert.assertEquals("abc",Strings.commonPrefix("abcdef","abcxyz"));
    }

    public void testCommonSuffix(){
        Assert.assertEquals("abc",Strings.commonPrefix("xyzabc","xxxabc"));
    }


}
