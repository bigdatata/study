package com.lt.study.elasticsearch;

import org.elasticsearch.client.Client;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.node.Node;
import org.junit.Test;

import static org.elasticsearch.node.NodeBuilder.nodeBuilder;

/**
 * Created by luotao on 2015/4/9.
 */
public class ClientTest {

    @Test
    public void first() {
        // on startup
        Node node = nodeBuilder().node();
        Client client = node.client();
        // on shutdown
        node.close();
    }

    /***
     *   You can define cluster.name in the /src/main/resources/elasticsearch.yml file in your project.
     *   As long as elasticsearch.yml is present in the classpath, it will be used when you start your node.
     *
     *   cluster.name: yourclustername
     */
    public void setupWithClusterName(){
        Node node = nodeBuilder().clusterName("yourclustername").node();
        Client client = node.client();
        node.close();
    }

    /***
     * This is simple to configure by setting either node.data setting to false or node.client to true
     * node.data setting to false or node.client to true
     */
    public void setupWhetherHoldData(){

        Node node = nodeBuilder().client(true).node();
        Client client = node.client();
        node.close();

    }

    /**
     *Another common usage is to start the Node and use the Client in unit/integration tests
     */
    public void setupInLocal(){
        Node node = nodeBuilder().local(true).node();
        Client client = node.client();
        node.close();
    }

    public void TransportClient(){
        // on startup

        Client client = new TransportClient()
                .addTransportAddress(new InetSocketTransportAddress("host1", 9300))
                .addTransportAddress(new InetSocketTransportAddress("host2", 9300));

        // on shutdown

        client.close();
    }
}
