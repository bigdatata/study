package com.study;

import com.google.common.base.Function;
import com.google.common.base.Predicate;
import com.google.common.collect.*;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import sun.security.krb5.internal.Ticket;

import java.util.*;
import java.util.concurrent.ConcurrentMap;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-4-9
 * Time: 下午2:51
 * To change this template use File | Settings | File Templates.
 */
public class CollectStudy {

    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void test07(){
        //create list
        List<String> listNoElement= Lists.newArrayList();
        List<String> listWithElement=Lists.newArrayList("a","b","c");
        List<String> listCopyOnWrite=Lists.newCopyOnWriteArrayList();
        List<String> listWithLength=Lists.newArrayListWithCapacity(100);

        //create set
        Set<String> set1= Sets.newHashSet();
        Set<String> set2=Sets.newHashSet("1","2");
        Set<String> set3 =Sets.newLinkedHashSet();
        Set<String> set4=Sets.newTreeSet();

        // can not insert null set
        Constraints.constrainedSet(Sets.newHashSet(),Constraints.notNull());

        //create map
        Map<String,String> map1= Maps.newHashMap();
        Map<String,String> map2 = Maps.newLinkedHashMap();
        Map<String,String> map3 = Maps.newTreeMap();
        Map<String,String> map4 = Maps.newConcurrentMap();
    }
    @Test
    public void test09(){
        Set<String> set=new HashSet<String>(Arrays.asList("a","b","c"));
        Set<String> unModifySet=Collections.unmodifiableSet(set);
        unModifySet.add("a");
    }
    @Test
    public void test10(){
        Set<String> set=Sets.newHashSet(Arrays.asList("a","b","c"));
        Set<String> gSet= ImmutableSet.of("a","b","b","d");
        Set<String> cpSet=ImmutableSet.copyOf(set);
    }

    @Test
    public void test11(){
        ImmutableSet.Builder<String> builder=ImmutableSet.builder();
        ImmutableSet<String> set=builder.add("a").addAll(Sets.newHashSet("a","b","c")).build();
    }

    @Test
    public void test12(){
        List<String> list=Lists.newArrayList("a","b","c","d","a","b","c","d");
        Map<String,Integer> map=Maps.newHashMap();
        for(String str:list){
            Integer count=map.get(str);
            map.put(str,(count==null)?1:count+1);
        }
        Integer countNow=map.get("a");
    }
    @Test
    public void test13(){
        List<String> list=Lists.newArrayList("a","b","c","d","a","b","c","d");
        Multiset<String> set=HashMultiset.create(list);
        int count=set.count("a");
    }
    @Test
    public void test14(){
        Map<String,HashSet<String>> map=new HashMap<String, HashSet<String>>();
        List<Ticket> tickets=Lists.newArrayList();
        for (Ticket ticket:tickets){
//            HashSet<String> set=map.get(ticket.getClass())
        }
    }
    @Test
    public void testMultiMap(){
        HashMultimap<String,String> map=HashMultimap.create();
        map.put("key","123");
        map.put("key","123");
        map.put("key","456");
       log.info(map.toString());
    }

    public void test18(){
        //假设map是已经有初始值的
        Map<String,String> map=new HashMap<String, String>();
        for (Map.Entry<String,String> entry:map.entrySet()){
            if (entry.getValue().equals("**")){
                entry.getKey();
            }
        }
    }

    @Test
    public void testBiMap(){
        BiMap<String,String> map=HashBiMap.create();
        map.put("key","d");
        log.info(map.inverse().get("d"));
    }

    public void test20(){
        ConcurrentMap<String,String> map=new MapMaker().weakKeys().makeMap();
    }
    public void test21(){
        ConcurrentMap<String,String> map=new MapMaker().weakValues().makeMap();
    }

    //todo
    public void testMapMaker(){
//        ConcurrentMap<String,String> map=new MapMaker().concurrencyLevel(32).softValues()
//                .weakValues().e
    }

    @Test
    public void testCollections2(){
        List<Integer> list=Lists.newArrayList(8,9,6,4,14,12,36);
        Collection<Integer> coll=Collections2.filter(list,new Predicate<Integer>() {
            public boolean apply(Integer input) {
                return input>=10;
            }
        });
        log.info(coll.toString());
        coll.add(6);
    }
    @Test
    public void testCollections2Transform(){
        List<Integer> list=Lists.newArrayList(8,9,6,4,14,12,36);
        Collection<String> coll=Collections2.transform(list,new Function<Integer, String>() {
            public String apply( Integer input) {
                return String.valueOf(input);
            }
        });
        log.info(coll.toString());
    }

    @Test
    public void test24(){
        Set<String> set1=Sets.newHashSet("a","b","c","d","e","f");
        Set<String> set2=Sets.newHashSet("a","b","g","h","e","f");
        //交集
        Sets.SetView<String> view1=Sets.union(set1,set2);
        log.info(view1.toString());

        log.info(Sets.difference(set1,set2).toString());
        log.info(Sets.difference(set2,set1).toString());

        log.info(Sets.intersection(set1,set2).toString());
        log.info(Sets.intersection(set2,set1).toString());
    }

    @Test
    public void test25(){
        Map<String,String> map1=Maps.newHashMap();
        map1.put("a","aa");
        map1.put("b","bb");
        Map<String,String> map2 = Maps.newHashMap();
        map2.put("a","aa");
        map2.put("c","cc");
        MapDifference<String,String> mapDiffer=Maps.difference(map1,map2);
        log.info(mapDiffer.entriesOnlyOnLeft().toString());
        log.info(mapDiffer.entriesOnlyOnRight().toString());
        log.info(mapDiffer.entriesInCommon().toString());
    }



}
