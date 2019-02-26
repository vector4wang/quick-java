package com.feature.learn.generic.paradigm;

public class Student
{  
    private String name;  //姓名  
      
    private String school;  //就读学校  
  
    public Student(String name, String school)  
    {  
        this.name = name;  
        this.school=school;  
    }  
      
    public Student init()  
    {  
        return new Student("1", "2");  
    }  
  
    public String getName()  
    {  
        return name;  
    }  
  
    public void setName(String name)  
    {  
        this.name = name;  
    }  
  
    public String getSchool()  
    {  
        return school;  
    }  
  
    public void setSchool(String school)  
    {  
        this.school = school;  
    }  
      
    public void show()  
    {  
        System.out.println("我叫："+this.name+"，就读于"+this.school);  
    }  
  
}  