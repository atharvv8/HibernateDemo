package org.example;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;

@Entity
public class Student {
    @Id
    private int rollNo; //Putting @Id above roll number tells hibernate that rollno is primary key
    private String sName;
    private int age;

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    public void setsName(String sName)
    {
        this.sName = sName;
    }
    public String getsName()
    {
        return sName;
    }
    public void setRollNo(int rollNo)
    {
        this.rollNo = rollNo;
    }
    public int getRollNo()
    {
        return rollNo;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollNo=" + rollNo +
                ", sName='" + sName + '\'' +
                ", age=" + age +
                '}';
    }
}
