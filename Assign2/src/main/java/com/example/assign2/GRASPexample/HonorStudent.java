package com.example.assign2.GRASPexample;

public class HonorStudent extends Student{
    private double gpa;
    public HonorStudent(Long id, String name, int age, double gpa){
        super(id,name,age);
        this.gpa = gpa;
    }

    public double getGpa() {
        return gpa;
    }

    public void setGpa(double gpa) {
        this.gpa = gpa;
    }
}
