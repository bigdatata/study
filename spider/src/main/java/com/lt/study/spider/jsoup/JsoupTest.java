package com.lt.study.spider.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.safety.Whitelist;
import org.junit.Test;

import java.io.File;
import java.io.IOException;

/**
 * Created by luotao on 2015/3/20.
 */
public class JsoupTest {
    @Test
    public void 解析一个HTML文档_test(){
        // parse a HTML
        String html = "<html><head><title>First parse</title></head>"
                + "<body><p>Parsed HTML into a doc.</p></body></html>";
        Document doc = Jsoup.parse(html);
        System.out.println(doc.body());
    }

    @Test
    public void 解析一个body片断_test(){
        String html = "<div><p>Lorem ipsum.</p>";
        Document doc = Jsoup.parseBodyFragment(html);
        Element body = doc.body();
        System.out.println(body);
    }
    @Test
    public void 从一个URL加载一个Document_test() throws IOException {
        Document doc = Jsoup.connect("http://www.jd.com/").get();
        String title = doc.title();
        System.out.println(title);
    }
    @Test
    public void 从一个文件加载一个文档_test() throws IOException {
        File input = new File("/tmp/input.html");
        Document doc = Jsoup.parse(input, "UTF-8", "http://example.com/");
    }

    @Test
    public void 消除不受信任的HTML(){
        String unsafe =
                "<p><a href='http://example.com/' onclick='stealCookies()'>Link</a></p>";
        String safe = Jsoup.clean(unsafe, Whitelist.basic());
// now: <p><a href="http://example.com/" rel="nofollow">Link</a></p>
    }



}
