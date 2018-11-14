package resume_match.model;

import java.util.Date;

/**
 * @author vector
 * @date: 2018/10/23 0023 16:57
 */
public class ResumeFeatureSimHash {
    private String resumeId;

    private String realName;

    private String pinyinName;

    private Long realNameSim;

    private Long pinyinNameSim;

    private Long companySim;

    private Long majorSim;

    private Long schoolSim;

    private Long titleSim;

    private Date workStartDate;

    private Date eduStartDate;

    private Date eduEndDate;

    private int gender;

    private int degree;

    private int age;


    private Date created;

    private Date updated;

    public String getResumeId() {
        return resumeId;
    }

    public void setResumeId(String resumeId) {
        this.resumeId = resumeId;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPinyinName() {
        return pinyinName;
    }

    public void setPinyinName(String pinyinName) {
        this.pinyinName = pinyinName;
    }

    public Long getRealNameSim() {
        return realNameSim;
    }

    public void setRealNameSim(Long realNameSim) {
        this.realNameSim = realNameSim;
    }

    public Long getPinyinNameSim() {
        return pinyinNameSim;
    }

    public void setPinyinNameSim(Long pinyinNameSim) {
        this.pinyinNameSim = pinyinNameSim;
    }

    public Long getCompanySim() {
        return companySim;
    }

    public void setCompanySim(Long companySim) {
        this.companySim = companySim;
    }

    public Long getMajorSim() {
        return majorSim;
    }

    public void setMajorSim(Long majorSim) {
        this.majorSim = majorSim;
    }

    public Long getSchoolSim() {
        return schoolSim;
    }

    public void setSchoolSim(Long schoolSim) {
        this.schoolSim = schoolSim;
    }

    public Long getTitleSim() {
        return titleSim;
    }

    public void setTitleSim(Long titleSim) {
        this.titleSim = titleSim;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
    }

    public Date getEduStartDate() {
        return eduStartDate;
    }

    public void setEduStartDate(Date eduStartDate) {
        this.eduStartDate = eduStartDate;
    }

    public Date getEduEndDate() {
        return eduEndDate;
    }

    public void setEduEndDate(Date eduEndDate) {
        this.eduEndDate = eduEndDate;
    }

    public int getGender() {
        return gender;
    }

    public void setGender(int gender) {
        this.gender = gender;
    }

    public int getDegree() {
        return degree;
    }

    public void setDegree(int degree) {
        this.degree = degree;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Date getCreated() {
        return created;
    }

    public void setCreated(Date created) {
        this.created = created;
    }

    public Date getUpdated() {
        return updated;
    }

    public void setUpdated(Date updated) {
        this.updated = updated;
    }
}
