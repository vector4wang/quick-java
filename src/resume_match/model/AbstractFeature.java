package resume_match.model;

import java.util.Date;

public class AbstractFeature {
    private String id;
    private String realName;
    private String school;
    private String major;
    private Date eduStartDate;
    private Date eduEndDate;
    private String company;
    private String title;
    private Date workStartDate;
    private int gender;
    private int degree;
    private int age;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getSchool() {
        return school;
    }

    public void setSchool(String school) {
        this.school = school;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
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

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getWorkStartDate() {
        return workStartDate;
    }

    public void setWorkStartDate(Date workStartDate) {
        this.workStartDate = workStartDate;
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

    @Override
    public String toString() {
        return "AbstractFeature{" + "id='" + id + '\'' + ", realName='" + realName + '\'' + ", school='" + school + '\''
                + ", major='" + major + '\'' + ", eduStartDate=" + eduStartDate + ", eduEndDate=" + eduEndDate
                + ", company='" + company + '\'' + ", title='" + title + '\'' + ", workStartDate=" + workStartDate
                + ", gender=" + gender + ", degree=" + degree + ", age=" + age + '}';
    }
}