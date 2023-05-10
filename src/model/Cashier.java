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
public class Cashier {
    private int cas_id,cas_PNum,joinYear,br_id;
    private double salary;
    private String c_fname, c_lname;
    public Cashier(int cas_id, int cas_PNum, int joinYear, int br_id, double salary, String c_fname, String c_lname) {
        this.cas_id = cas_id;
        this.cas_PNum = cas_PNum;
        this.joinYear = joinYear;
        this.br_id = br_id;
        this.c_fname = c_fname;
        this.c_lname = c_lname;
        this.salary=salary;
    }
    public int getCas_id() {
        return cas_id;
    }
    public int getCas_PNum() {
        return cas_PNum;
    }
    public int getJoinYear() {
        return joinYear;
    }
    public int getBr_id() {
        return br_id;
    }
    public double getSalary() {
        return salary;
    }
    public String getC_fname() {
        return c_fname;
    }
    public String getC_lname() {
        return c_lname;
    }
    public void setCas_id(int cas_id) {
        this.cas_id = cas_id;
    }
    public void setCas_PNum(int cas_PNum) {
        this.cas_PNum = cas_PNum;
    }
    public void setJoinYear(int joinYear) {
        this.joinYear = joinYear;
    }
    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }
    public void setSalary(double salary) {
        this.salary = salary;
    }
    public void setC_fname(String c_fname) {
        this.c_fname = c_fname;
    }
    public void setC_lname(String c_lname) {
        this.c_lname = c_lname;
    }
}