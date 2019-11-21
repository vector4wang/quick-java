package com.feature.learn.ojcp.online;

public class TestClass {
    public static void main(String[] args) throws Exception {
        TestClass tc = new TestClass();
        tc.myMethod();
    }
    
    public void myMethod() throws Exception {
        yourMethod();
    }
    
    public void yourMethod() throws Exception {
        throw new Exception();
    }    
}