package feature.learn.generic_paradigm;

public class Teacher
{  
    private String name; // 姓名  
  
    private String course; // 课程  
  
    public Teacher(String name, String course)  
    {  
        this.name = name;  
        this.course = course;  
    }  
      
    public void show()  
    {  
        System.out.println("我叫："+this.name+",是一名"+this.course+"教师");  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public void setName(String name)  
    {  
        this.name = name;  
    }  
  
    public String getCourse()  
    {  
        return course;  
    }  
  
    public void setCourse(String course)  
    {  
        this.course = course;  
    }  
}  