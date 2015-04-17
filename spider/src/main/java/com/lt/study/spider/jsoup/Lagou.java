package com.lt.study.spider.jsoup;

import com.google.common.base.Charsets;
import com.lt.study.jobinfo.domain.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Created by luotao on 2015/4/8.
 */
public class Lagou extends JobInfo{

    public static void main(String[] args) throws IOException {
        Lagou lagou =getLagou("http://www.lagou.com/jobs/453394.html");

    }

    public static  Lagou getLagou(String url){
        Lagou lagou = new Lagou();
        try {
            Document page=Jsoup.connect(url).get();
            Element jobDetail = page.getElementsByClass("job_detail").first();
            Element head =jobDetail.getElementsByClass("join_tc_icon").first().getElementsByTag("h1").first();
            String title=head.attr("title");
            String companyDep=head.getElementsByTag("div").first().text();
            String jobId=page.getElementById("jobid").val();
            String companyId = page.getElementById("companyid").val();
            String jobRequest = jobDetail.getElementsByClass("job_request").first().text();
            String jobDescription = jobDetail.getElementsByClass("job_bt").first().text();
            String  salary =  jobDetail.getElementsByClass("job_bt").first().getElementsByTag("span").text();
            lagou.setTitle(title);
            lagou.setCompanyDep(companyDep);
            lagou.setSalary(salary);
            lagou.setRequirement(jobRequest);
            lagou.setDescription(jobDescription);
            lagou.setJobId(jobId);
            lagou.setCompanyId(companyId);
            lagou.setUrl(url);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return lagou;
    }

}
