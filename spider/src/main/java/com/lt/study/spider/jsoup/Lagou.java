package com.lt.study.spider.jsoup;

import com.google.common.base.Charsets;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;

/**
 * Created by luotao on 2015/4/8.
 */
public class Lagou {

    private String title;
    private String salary;
    private String  companyDep;
    private String jobId;
    private String companyId;
    private String jobRequest;
    private String  description;
    private String  requirement;
    private String url;



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

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getSalary() {
        return salary;
    }

    public void setSalary(String salary) {
        this.salary = salary;
    }



    public String getCompanyDep() {
        return companyDep;
    }

    public void setCompanyDep(String companyDep) {
        this.companyDep = companyDep;
    }

    public String getJobId() {
        return jobId;
    }

    public void setJobId(String jobId) {
        this.jobId = jobId;
    }

    public String getCompanyId() {
        return companyId;
    }

    public void setCompanyId(String companyId) {
        this.companyId = companyId;
    }

    public String getJobRequest() {
        return jobRequest;
    }

    public void setJobRequest(String jobRequest) {
        this.jobRequest = jobRequest;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getRequirement() {
        return requirement;
    }

    public void setRequirement(String requirement) {
        this.requirement = requirement;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
