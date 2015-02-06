package com.study;

import com.google.common.base.Charsets;
import com.google.common.collect.Lists;
import com.google.common.io.CharStreams;
import com.google.common.io.Files;
import com.google.common.io.InputSupplier;
import com.google.common.io.LineProcessor;
import junit.framework.Assert;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.net.URL;
import java.util.List;

import java.util.ArrayList;

/**
 * Created with IntelliJ IDEA.
 * User: cdluotao1
 * Date: 14-4-9
 * Time: 下午4:09
 * To change this template use File | Settings | File Templates.
 */
public class IOStudy {
    protected final Logger log = LoggerFactory.getLogger(getClass());

    @Test
    public void test01() throws IOException {
        InputSupplier<FileInputStream> input= Files.newInputStreamSupplier(new File("g:/didd.txt"));
        FileInputStream fin=input.getInput();
        int b=0;
        while ((b=fin.read())!=-1) {
           log.info((char)b+"");
        }
    }

    @Test
    public void testCopyFile() throws IOException {
          Files.copy(new File("g:/didd.txt"),new File("g:/didd-copy.txt"));
    }

    @Test
    public void testEqual() throws IOException {
        boolean flag=Files.equal(new File("g:/didd.txt"),new File("g:/didd-copy.txt"));
        Assert.assertTrue(flag);
    }
    @Test
    public void testMove() throws IOException{
        Files.copy(new File("g:/didd.txt"),new File("g:/didd-copy-move.txt"));
        Files.move(new File("g:/didd-copy-move.txt"), new File("g:/didd-move.txt"));
    }

    @Test
    public void testFileExtension(){
        log.info(Files.getFileExtension("a.txt"));
    }

    @Test
    public void testReadLines(){
        File file=new File("g:/didd-move.txt");
        log.info(file.getAbsolutePath());
        List<String> lines=null;
        try {
            lines=Files.readLines(file, Charsets.UTF_8);
        } catch (IOException e) {
            e.printStackTrace();  //To change body of catch statement use File | Settings | File Templates.
        }
        log.info(lines.toString());
    }
    @Test
    public void test12() throws IOException{
        Files.append("\n你好",new File("g:/didd.txt"),Charsets.UTF_8);
        log.info(Files.toString(new File("g:/didd.txt"),Charsets.UTF_8));
    }

    /***
     *  读文件时候，取出文件中的一行包含某一个字段
     */
    @Test
    public void test06() throws IOException {
        File file=new File("g:/didd.txt");
        ArrayList<String> result= CharStreams.readLines(Files.newReaderSupplier(file, Charsets.UTF_8),
                new LineProcessor<ArrayList<String>>() {
                    ArrayList<String> list= Lists.newArrayList();
                    public boolean processLine(String line) throws IOException {
                        if(line.contains("D")){
                            log.info(String.format("line:%s,包含D不存储",line));
                        }else {
                            list.add(line);
                        }
                        return true;
                    }

                    public ArrayList<String> getResult() {
                        return list;
                    }
                });
        log.info("result: "+result);
    }

    @Test
    public void testReadLines_withLineProcessor() throws IOException{
        URL resource=getClass().getResource("/test.txt");
        LineProcessor<List<String>> collectAndLowercaseAndTrim= new LineProcessor<List<String>>() {
            List<String> collector=Lists.newArrayList();
            public boolean processLine(String line) throws IOException {
                collector.add(line.toLowerCase().trim()) ;
                return true;
            }

            public List<String> getResult() {
                return collector;
            }
        };

    }


}
