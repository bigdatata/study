package com;

import org.junit.Test;

import java.util.Collections;
import java.util.List;
import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-4-9
 * Time: 上午10:37
 * To change this template use File | Settings | File Templates.
 */
public class Study {
    @Test
    public void testUnmodifiableList() {
        final List<Integer> list = new ArrayList<Integer>();
        list.add(1);
        list.add(2);
        System.out.println(list);// [1, 2]

        final List<Integer> wrapedList = Collections.unmodifiableList(list);
        System.out.println(wrapedList);// [1, 2]

        list.add(3);
        System.out.println(wrapedList);// [1, 2, 3]

        wrapedList.add(4);// throw java.lang.UnsupportedOperationException
    }

}
