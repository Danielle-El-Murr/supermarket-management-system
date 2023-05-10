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
public class Branch {
    private int br_id,extNum;
    private String city,street,m_fname,m_lname;
    public Branch(int br_id, int extNum, String city, String street, String m_fname, String m_lname) {
        this.br_id = br_id;
        this.extNum = extNum;
        this.city = city;
        this.street = street;
        this.m_fname = m_fname;
        this.m_lname = m_lname;
    }
    public int getBr_id() {
        return br_id;
    }
    public int getExtNum() {
        return extNum;
    }
    public String getCity() {
        return city;
    }
    public String getStreet() {
        return street;
    }
    public String getM_fname() {
        return m_fname;
    }
    public String getM_lname() {
        return m_lname;
    }
    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }
    public void setExtNum(int extNum) {
        this.extNum = extNum;
    }
    public void setCity(String city) {
        this.city = city;
    }
    public void setStreet(String street) {
        this.street = street;
    }
    public void setM_fname(String m_fname) {
        this.m_fname = m_fname;
    }
    public void setM_lname(String m_lname) {
        this.m_lname = m_lname;
    }
}