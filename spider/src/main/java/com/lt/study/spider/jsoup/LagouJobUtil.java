package com.lt.study.spider.jsoup;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

import java.io.*;
import java.util.List;

/**
 * Created by luotao on 2015/7/21.
 */
public class LagouJobUtil {

    public static void main(String[] args) throws Exception{
        InputStreamReader isr = new InputStreamReader(new FileInputStream("C:\\Users\\luotao\\Desktop\\data.txt"), "UTF-8");
        BufferedReader reader = new BufferedReader(isr);
        String line =reader.readLine();
        System.out.println(getJobList(line).size());
    }

    public static List<Lagou> getJobList(String jobListJson){
        JSONObject jsonObject = JSON.parseObject(jobListJson);
        List<Lagou> lagouList = JSON.parseArray(jsonObject.getJSONObject("content").getString("result"),Lagou.class);
        return lagouList;
    }

    public static void saveAllToFile(String kd,String city,String yx) throws FileNotFoundException, UnsupportedEncodingException {
        //http://www.lagou.com/jobs/positionAjax.json?px=new&city=%E6%88%90%E9%83%BD&kd=java&pn=1
        String lagouListUrlTemplate="http://www.lagou.com/jobs/positionAjax.json?px=new&city=%s&yx=%s&pn=%d";
        OutputStreamWriter outputStreamWriter = new OutputStreamWriter(new FileOutputStream("C:\\Users\\luotao\\Desktop\\data.txt"),"UTF-8");
    }



}
