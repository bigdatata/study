package com.lt.study.spider.jsoup;

import com.google.common.base.Charsets;
import com.lt.study.jobinfo.domain.JobInfo;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * Created by luotao on 2015/4/8.
 */
public class Lagou extends JobInfo{

    private String positionName;//": "��ҳ�༭����˿�����PHP/java",
    private Integer positionId;//": 900994,
    private String city;//        "city": "�ɶ�",
    private Integer companyId;//        "companyId": 83980,
    private String positionFirstType;//        "positionFirstType": "����",
    private String education;//        "education": "ѧ������",
    private String workYear;//        "workYear": "����",
    private String jobNature;//        "jobNature": "ȫְ",
    private String salary;//        "salary": "5k-10k",
    private Date createTime;// "createTime": "2015-07-21 10:34:43.0",
    // "score": 634,
    private String companyShortName;//       "companyShortName": "�ɶ��ַ��Ƽ����޹�˾",
    private String companyName;//       "companyName": "�ַ��Ƽ�",
    private String positionType;//       "positionType": "��˿���",
    private String financeStage;//       "financeStage": "������(��ʹ��)",
    private String industryField;//      "industryField": "�ƶ������� �� ����",
    private String companyLogo;//        "companyLogo": "image1/M00/3A/71/Cgo8PFWtrAyAWYlwAAFWp77OJuk015.jpg?cc=0.11896941461600363",
    private String positionAdvantage;//        "positionAdvantage": "�ɳ��ռ��+��չǰ����",
    private String leaderName;//        "leaderName": "��û����д",
    private String companySize;//        "companySize": "����15��",
    private List<String> companyLabelList;
//            "companyLabelList": [
//            "������ѵ",
//            "��Ʊ��Ȩ",
//            "��н���",
//            "��λ����"
//            ],

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
            Integer companyId = Integer.valueOf(page.getElementById("companyid").val());
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

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
        this.id = positionId;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public Integer getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Integer companyId) {
        this.companyId = companyId;
    }

    public String getPositionFirstType() {
        return positionFirstType;
    }

    public void setPositionFirstType(String positionFirstType) {
        this.positionFirstType = positionFirstType;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getWorkYear() {
        return workYear;
    }

    public void setWorkYear(String workYear) {
        this.workYear = workYear;
    }

    public String getJobNature() {
        return jobNature;
    }

    public void setJobNature(String jobNature) {
        this.jobNature = jobNature;
    }

    @Override
    public String getSalary() {
        return salary;
    }

    @Override
    public void setSalary(String salary) {
        this.salary = salary;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCompanyShortName() {
        return companyShortName;
    }

    public void setCompanyShortName(String companyShortName) {
        this.companyShortName = companyShortName;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getPositionType() {
        return positionType;
    }

    public void setPositionType(String positionType) {
        this.positionType = positionType;
    }

    public String getFinanceStage() {
        return financeStage;
    }

    public void setFinanceStage(String financeStage) {
        this.financeStage = financeStage;
    }

    public String getIndustryField() {
        return industryField;
    }

    public void setIndustryField(String industryField) {
        this.industryField = industryField;
    }

    public String getCompanyLogo() {
        return companyLogo;
    }

    public void setCompanyLogo(String companyLogo) {
        this.companyLogo = companyLogo;
    }

    public String getPositionAdvantage() {
        return positionAdvantage;
    }

    public void setPositionAdvantage(String positionAdvantage) {
        this.positionAdvantage = positionAdvantage;
    }

    public String getLeaderName() {
        return leaderName;
    }

    public void setLeaderName(String leaderName) {
        this.leaderName = leaderName;
    }

    public String getCompanySize() {
        return companySize;
    }

    public void setCompanySize(String companySize) {
        this.companySize = companySize;
    }

    public List<String> getCompanyLabelList() {
        return companyLabelList;
    }

    public void setCompanyLabelList(List<String> companyLabelList) {
        this.companyLabelList = companyLabelList;
    }
}
