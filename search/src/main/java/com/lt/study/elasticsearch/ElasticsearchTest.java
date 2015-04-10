package com.lt.study.elasticsearch;

import org.elasticsearch.action.delete.DeleteResponse;
import org.elasticsearch.action.get.GetResponse;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.common.xcontent.XContentBuilder;
import org.elasticsearch.index.mapper.SourceToParse;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.elasticsearch.common.settings.ImmutableSettings;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.node.Node;
import org.elasticsearch.node.NodeBuilder;

import static org.elasticsearch.common.xcontent.XContentFactory.jsonBuilder;
import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by luotao on 2015/4/3.
 */
public class ElasticsearchTest {

    private  Client client = nodeBuilder().client(true).node().client();

    @Test
    public void test() {
        (new Thread() {
            @Override
            public void run() {
                Settings settings = ImmutableSettings.settingsBuilder()
                        .loadFromClasspath("config/elasticsearch.yml").build();
                // 创建并启动节点
                NodeBuilder nodeBuilder = NodeBuilder.nodeBuilder();
                nodeBuilder.settings(settings);
                Node node = nodeBuilder.node();
                node.start();
            }
        }).start();
        while (true){

        }
    }

    @Test
    public void testGenerateJsonContent() throws IOException {
        XContentBuilder builder = jsonBuilder()
                .startObject()
                .field("user", "kimchy")
                .field("postDate", new Date())
                .field("message", "trying out Elasticsearch")
                .endObject();
        System.out.println(builder.string());
    }

    @Test
    public void indexApi() throws IOException {
        Client client = nodeBuilder().client(true).node().client();
        IndexResponse response = client.prepareIndex("twitter", "tweet", "1")
                .setSource(jsonBuilder()
                                .startObject()
                                .field("user", "kimchy")
                                .field("postDate", new Date())
                                .field("message", "trying out Elasticsearch")
                                .endObject()
                )
                .execute()
                .actionGet();
        // Index name
        String _index = response.getIndex();
        // Type name
        String _type = response.getType();
        // Document ID (generated or not)
        String _id = response.getId();
        // Version (if it's the first time you index this document, you will get: 1)
        long _version = response.getVersion();
        // isCreated() is true if the document is a new one, false if it has been updated
        boolean created = response.isCreated();
        client.close();
    }

    @Test
    public void getApi(){
        GetResponse response = client.prepareGet("twitter", "tweet", "1")
               // .setOperationThreaded(false)
                .execute()
                .actionGet();
        System.out.println(response.getField("user").getValue().toString());
    }

    @Test
    public void deleteApi(){
        DeleteResponse response = client.prepareDelete("twitter", "tweet", "1")
                .execute()
                .actionGet();
    }
}
