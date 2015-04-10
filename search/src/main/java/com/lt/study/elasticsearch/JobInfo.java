package com.lt.study.elasticsearch;

import com.alibaba.fastjson.JSON;
import com.lt.study.spider.jsoup.Lagou;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.util.Date;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by luotao on 2015/4/9.
 */
public class JobInfo {

    private Client client;

    @Before
    public void init(){
        client = nodeBuilder().client(true).node().client();
    }

    @After
    public void after(){
        client.close();
    }

    @Test
    public void getLagouJobInfo(){
        String urlTemplate="http://www.lagou.com/jobs/%d.html";
        for(int i=500000;i<563394;i++){
            String url =String.format(urlTemplate,i);
            saveLagouJobInfo(url);
        }
    }

    private void saveLagouJobInfo(String url){
        Lagou lagou = Lagou.getLagou(url);
        String jsonString = JSON.toJSONString(lagou);
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        saveJobInfo("job","lagou",jsonString);
    }

    public void saveJobInfo(String index,String Type,String json){
        IndexResponse response = client.prepareIndex(index, Type)
                .setSource(json)
                .execute()
                .actionGet();
    }
}
