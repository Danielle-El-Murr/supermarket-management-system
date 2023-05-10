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
public class Contain {
    private int br_id,prod_code,qty;
    public Contain(int br_id, int prod_code, int qty) {
        this.br_id = br_id;
        this.prod_code = prod_code;
        this.qty = qty;
    }
    public int getBr_id() {
        return br_id;
    }
    public int getProd_code() {
        return prod_code;
    }
    public int getQty() {
        return qty;
    }
    public void setBr_id(int br_id) {
        this.br_id = br_id;
    }
    public void setProd_code(int prod_code) {
        this.prod_code = prod_code;
    }
    public void setQty(int qty) {
        this.qty = qty;
    }
}