package com.lt.study.mongo;

/**
 * Created by luotao on 2015/3/16.
 */

import com.google.common.collect.ImmutableList;
import com.google.gson.Gson;
import java.net.UnknownHostException;
import java.util.Calendar;
import java.util.Date;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

import com.mongodb.*;
import com.mongodb.util.JSON;
import org.bson.types.ObjectId;
import org.junit.Before;
import org.junit.Test;

public class TestMongoDriver {

    MongoClient mongo;

    DB testDB;

    DBCollection testCollection;

    @Before
    public void init() throws UnknownHostException {
        // 连接到mongodb
        mongo = new MongoClient("localhost", 27017);
        // 打开数据库test
        testDB = mongo.getDB("test");
        // 取得集合emp(若：test不存在，mongodb将自动创建该集合)
        testCollection = testDB.getCollection("test");
    }

    /**
     * db.test.insert({"bar":"baz"})
     */
    @Test
    public void insert(){
        dropCollection();
        BasicDBObject doc=new BasicDBObject("bar","baz");
        doc.put("_id",1);
        testCollection.insert(doc);
        BasicDBObject doc1=new BasicDBObject("bar","baz");
        BasicDBObject doc2=new BasicDBObject("bar","baz");
        testCollection.insert(doc1,doc2);
        testCollection.insert(new DBObject[]{new BasicDBObject("1", "2"), new BasicDBObject("1", "2")});
        testCollection.insert(ImmutableList.<DBObject>of(new BasicDBObject("2", "3"), new BasicDBObject("2", "3")));
        testFindAll();
    }

    /**
     * Insert和Save的区别是：如果插入的集合的“_id”值，在集合中已经存在,用Insert执行插入操作回报异常，
     * 已经存在"_id"的键。用Save如果系统中没有相同的"_id"就执行插入操作，有的话就执行覆盖掉原来的值。
     * 相当于修改操作。
     */
    @Test
    public void compareInsertVsSave(){
        dropCollection();
        BasicDBObject doc=new BasicDBObject("bar","baz");
        doc.put("_id",1);
        testCollection.insert(doc);
        //com.mongodb.MongoException$DuplicateKey: { "serverUsed" : "localhost:27017" , "ok" : 1 , "n" : 0 , "err" : "insertDocument :: caused by :: 11000 E11000 duplicate key error index: test.test.$_id_  dup key: { : 1 }" , "code" : 11000}
       // testCollection.insert(doc);
        testFindAll();
        System.out.println("update");
        BasicDBObject doc2=new BasicDBObject("bar","baz-new");
        doc2.put("_id",1);
        testCollection.save(doc2);
        testFindAll();
    }


    /***
     * 删除整个集合，速度快，索引也同时被删除
     */
    @Test
    public void dropCollection(){
        testCollection.drop();
    }

    /***
     * 删除整个集合，速度慢，但索引未被删除
     */
    @Test
    public void removeAll(){
        testCollection.remove(new BasicDBObject());
        testFindAll();
    }

    @Test
    public void remove(){
        testCollection.remove(new BasicDBObject("_id",new Integer(1)));
        testFindAll();
    }


    @Test
    public void testFindAll(){
        DBCursor dbCursor = testCollection.find();
        while (dbCursor.hasNext()){
            System.out.println(dbCursor.next());
        }
    }

    //文档替换
    @Test
    public void update(){
        testCollection.drop();
        testCollection.save(new BasicDBObject("username", "jeo").append("_id", 1).append("friends", 32).append("enemies", 2));
        testCollection.save(new BasicDBObject("username","jeo").append("_id",2).append("friends", 32).append("enemies", 2));
        DBObject  jeo = testCollection.findOne(new BasicDBObject("username","jeo").append("friends",32));
        jeo.removeField("enemies");
        testCollection.update(new BasicDBObject("_id",1),jeo);

        //$inc 增加和减少 只能用于 整形、长整形或双精度浮点数
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$inc",new BasicDBObject("friends",1)));
        testCollection.update(new BasicDBObject("_id",2),new BasicDBObject("$inc",new BasicDBObject("friends",-11)));
        // $set $unset 设置键值  删除键值
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$set",new BasicDBObject("favorite book","war and peace")));
        testCollection.update(new BasicDBObject("_id",2),new BasicDBObject("$set",new BasicDBObject("favorite book",
                new String[]{"cat's cradle","foundation trilogy","ender's game"})));
        testFindAll();
        System.out.println("test unset");
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$unset",new BasicDBObject("friends",1)));
        //数组修改器  $push $pop  $addToSet
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$push",new BasicDBObject("comments",
                new BasicDBObject("name","jeo1").append("email","jeo@hello.com").append("content","nice post."))));
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$push",new BasicDBObject("comments",
                new BasicDBObject("name","jeo2").append("email", "jeo@hello.com").append("content","nice post."))));
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$pop",new BasicDBObject("comments",
                new BasicDBObject("name","jeo2").append("email","jeo@hello.com").append("content","nice post."))));
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$addToSet",new BasicDBObject("comments",
                new BasicDBObject("name","jeo3").append("email","jeo@hello.com").append("content","nice post."))));
        testFindAll();

        testCollection.drop();
        testCollection.insert(new BasicDBObject("_id",1).append("username","joe"));
        //$ne 一个元素不存在 放入
        testCollection.update(new BasicDBObject("emails",new BasicDBObject("$ne","jeo@jd.com")),
                new BasicDBObject("$push",new BasicDBObject("emails","jeo@jd.com")));

        //$each
        testCollection.update(new BasicDBObject("_id",1),
                new BasicDBObject("$addToSet",new BasicDBObject("emails",new BasicDBObject("$each",new String[]{
                        "jeo@jd.com","jeo1@jd.com","jeo2@jd.com","jeo3@jd.com"
                }))));
        testFindAll();

        //$pop 删除一个元素  {$pop:{key:1}} 从尾部删除   $pull 删除所有相同的
        testCollection.drop();
        testCollection.save(new BasicDBObject("todo",new String[]{
                        "dishes","laundry","dry cleaning","dishes","dishes"
                }).append("_id", 1));
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$pop",new BasicDBObject("todo","dishes")));
        testFindAll();
        testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$pull",new BasicDBObject("todo","dishes")));
        testFindAll();

        //数组的定位修改器
        testCollection.drop();
        testCollection.save(new BasicDBObject("comments", new BasicDBObject[]{
                new BasicDBObject("comment", "good post").append("author", "John").append("votes", 0),
                new BasicDBObject("comment", "I thought it was too short").append("author", "Claire").append("votes", 3),
                new BasicDBObject("comment", "free watches").append("author", "Alice").append("votes", -1)
        }).append("_id", 1));
        testCollection.update(new BasicDBObject("_id", 1), new BasicDBObject("$inc", new BasicDBObject("comments.0.votes", 1)));
        testCollection.update(new BasicDBObject("comments.author", "John"), new BasicDBObject("$set", new BasicDBObject("comments.$.author","Jim")));
        testFindAll();
    }

    /***
     * $push 比较耗时
     */
    @Test
    public void compareTimeConsume(){
        testCollection.drop();
        testCollection.insert(new BasicDBObject("_id",1));
        long startTime=System.currentTimeMillis();
        testCollection.findOne();
        for (int i = 1; i <10000; i++) {
            testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$inc",new BasicDBObject("x",1)));
        }
        testCollection.findOne();
        System.out.println("cost "+(System.currentTimeMillis()-startTime));
        testCollection.drop();
        testCollection.insert(new BasicDBObject("_id",1));
        startTime=System.currentTimeMillis();
        testCollection.findOne();
        for (int i = 1; i <10000; i++) {
            testCollection.update(new BasicDBObject("_id",1),new BasicDBObject("$push",new BasicDBObject("x",1)));
        }
        testCollection.findOne();
        System.out.println("cost "+(System.currentTimeMillis()-startTime));
    }

    @Test
    public void testCRUD() throws UnknownHostException {
        // 连接到mongodb
        Mongo mongo = new MongoClient("localhost", 27017);

        // 打开数据库test
        DB db = mongo.getDB("test");

        // 遍历所有集合的名字
        Set<String> colls = db.getCollectionNames();
        for (String s : colls) {
            System.out.println(s);
            // 先删除所有Collection(类似于关系数据库中的"表")
            if (!s.equals("system.indexes")) {
                db.getCollection(s).drop();
            }
        }

        // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
        DBCollection coll = db.getCollection("emp");

        // delete all
        DBCursor dbCursor = coll.find();
        for (DBObject dbObject : dbCursor) {
            coll.remove(dbObject);
        }

        // create
        BasicDBObject doc = new BasicDBObject("name", "杨俊明").append("sex", "男")
                .append("address",
                        new BasicDBObject("postcode", "201202").append(
                                "street", "田林路888号").append("city", "上海"));
        coll.insert(doc);

        // retrieve
        BasicDBObject docFind = new BasicDBObject("name", "杨俊明");
        DBObject findResult = coll.findOne(docFind);
        System.out.println(findResult);

        // update
        doc.put("sex", "MALE");// 把sex属性从"男"，改成"MALE"
        coll.update(docFind, doc);
        findResult = coll.findOne(docFind);
        System.out.println(findResult);

        coll.dropIndexes();// 先删除所有索引
        // create index
        coll.createIndex(new BasicDBObject("name", 1)); // 1代表升序

        // 复杂对象
        UserData userData = new UserData("jimmy", "123456");
        Set<String> pets = new HashSet<String>();
        pets.add("cat");
        pets.add("dog");
        Map<String, String> favoriteMovies = new HashMap<String, String>();
        favoriteMovies.put("dragons", "Dragons II");
        favoriteMovies.put("avator", "Avator I");
        userData.setFavoriteMovies(favoriteMovies);
        userData.setPets(pets);
        userData.setBirthday(getDate(1990, 5, 1));
        BasicDBObject objUser = new BasicDBObject("key", "jimmy").append(
                "value", toDBObject(userData));
        coll.insert(objUser);
        System.out.println(coll.findOne(objUser));
    }

    /**
     * 将普通Object对象转换成mongodb的DBObject对象
     *
     * @param obj
     * @return
     */
    private DBObject toDBObject(Object obj) {
        Gson gson = new Gson();
        String json = gson.toJson(obj);
        return (DBObject) JSON.parse(json);
    }

    /**
     * 获取指定日期
     *
     * @param year
     * @param month
     * @param day
     * @return
     */
    private Date getDate(int year, int month, int day) {
        Calendar calendar = Calendar.getInstance();
        calendar.clear();
        calendar.set(year, month - 1, day);
        return calendar.getTime();

    }

}