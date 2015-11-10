package com.lt.study.jobinfo.domain;

import org.omg.PortableInterceptor.INACTIVE;

/**
 * Created by luotao on 2015/4/17.
 */
public class JobInfo {

    protected Integer id;
    protected String title;
    protected String salary;
    protected String  companyDep;
    protected String jobId;
    protected Integer companyId;
    protected String jobRequest;
    protected String  description;
    protected String  requirement;
    protected String url;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
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

    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
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
