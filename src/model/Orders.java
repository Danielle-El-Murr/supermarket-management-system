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
public class Orders {
    private int orderNum,cus_id,cas_id,br_id;
    private String date;
    private String paymentType;
    public Orders(int orderNum, int cus_id, int cas_id, int br_id, String date, String paymentType) {
        this.orderNum = orderNum;
        this.cus_id = cus_id;
        this.cas_id = cas_id;
        this.br_id = br_id;
        this.date = date;
        this.paymentType = paymentType;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public int getCus_id() {
        return cus_id;
    }
    public int getCas_id() {
        return cas_id;
    }
    public int getBr_id() {
        return br_id;
    }
    public String getDate() {
        return date;
    }
    public String getPaymentType() {
        return paymentType;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    public void setCus_id(int cus_id) {
        this.cus_id = cus_id;
    }
    public void setCas_id(int cas_id) {
        this.cas_id = cas_id;
    }
    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }
    public void setDate(String date) {
        this.date = date;
    }
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
}