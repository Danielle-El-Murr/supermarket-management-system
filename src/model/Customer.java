/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

/**
 *
 * @author user
 */
public class Customer {
    private int cus_id,age,cus_PNum;
    private String fname,lname;
    public Customer(int cus_id, int age, int cus_PNum, String fname, String lname) {
        this.cus_id = cus_id;
        this.age = age;
        this.cus_PNum = cus_PNum;
        this.fname = fname;
        this.lname = lname;
    }
    public int getCus_id() {
        return cus_id;
    }
    public int getAge() {
        return age;
    }
    public int getCus_PNum() {
        return cus_PNum;
    }
    public String getFname() {
        return fname;
    }
    public String getLname() {
        return lname;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setCus_PNum(int cus_PNum) {
        this.cus_PNum = cus_PNum;
    }
    public void setFname(String fname) {
        this.fname = fname;
    }
    public void setLname(String lname) {
        this.lname = lname;
    }
}