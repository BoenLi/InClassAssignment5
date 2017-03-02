package com.example.android.inclassassignment05_boenl;

import java.io.Serializable;

///**
// * Created by boenli on 2/22/17.
// */

public class Student implements Serializable{
    private String studentName;
    private int age;
    private double gpa;
    private boolean p;

    public Student(String studentName, int age, double gpa, boolean p) {
        this.studentName = studentName;
        this.age = age;
        this.gpa = gpa;
        this.p = p;
    }


    private String transformBoolean(){
        String result;
        if(p){
            result = "Yes";}
        else{
            result = "No";}
        return result;

    }

    @Override
    public String toString() {
        return "Name：" + studentName + '\n' +
                "Age" + age +'\n'+
                "GPA" + gpa +'\n'+
                "Graduated:" + transformBoolean();
    }
}
