package com.lt.study.spider.jsoup;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.File;

/**
 * Created by luotao on 2015/7/22.
 */
public class SourceInfo {
    public static void main(String[] args) throws Exception{
        File input = new File("C:\\Users\\luotao\\Desktop\\getFound.html");
        Document doc = Jsoup.parse(input,"utf-8");
        Elements  elements = doc.select("div.item-wrapper");
        for (Element element:elements){
            System.out.println(element.text());
        }
    }
}
