/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.epsilon.entity;
public class Employee {
    private int Id;
    private String Complete_name;
    private String BirthDate;
    private int Salary;
    private int age;
    
    public Employee(){
        
    }

    public Employee(int Id, String Complete_name, String BirthaDate, int Salary, int age) {
        this.Id = Id;
        this.Complete_name = Complete_name;
        this.BirthDate = BirthaDate;
        this.Salary = Salary;
        this.age = age;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getComplete_name() {
        return Complete_name;
    }

    public void setComplete_name(String Complete_name) {
        this.Complete_name = Complete_name;
    }

    public String getBirthDate() {
        return BirthDate;
    }

    public void setBirthDate(String BirthaDate) {
        this.BirthDate = BirthaDate;
    }

    public int getSalary() {
        return Salary;
    }

    public void setSalary(int Salary) {
        this.Salary = Salary;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "Employee{" + "Id=" + Id + ", Complete_name=" + Complete_name + ", BirthaDate=" + BirthDate + ", Salary=" + Salary + ", age=" + age + '}';
    }
    
}
