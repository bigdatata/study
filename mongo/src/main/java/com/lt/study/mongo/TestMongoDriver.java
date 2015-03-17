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
import org.junit.Before;
import org.junit.Test;

public class TestMongoDriver {

    MongoClient mongo;

    DB testDB;

    DBCollection testCollection;

    @Before
    public void init() throws UnknownHostException {
        mongo = new MongoClient("localhost", 27017);
        testDB = mongo.getDB("test");
        // 取得集合emp(若：emp不存在，mongodb将自动创建该集合)
        testCollection = testDB.getCollection("test");
    }

    //db.test.insert({"bar":"baz"})
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

    /***
     * 删除整个集合，速度快，索引也同时被删除
     */
    @Test
    public void dropCollection(){
        testCollection.drop();
    }

    @Test
    public void remove(){
        testCollection.remove(new BasicDBObject("_id",new Integer(1)));
        testFindAll();
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
    public void testFindAll(){
        DBCursor dbCursor = testCollection.find();
        while (dbCursor.hasNext()){
            System.out.println(dbCursor.next());
        }
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