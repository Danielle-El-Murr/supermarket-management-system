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
public class Includes {
    private int orderNum,prod_code,qtyBought;
    public Includes(int orderNum, int prod_code, int qtyBought) {
        this.orderNum = orderNum;
        this.prod_code = prod_code;
        this.qtyBought = qtyBought;
    }
    public int getOrderNum() {
        return orderNum;
    }
    public int getProd_code() {
        return prod_code;
    }
    public int getQtyBought() {
        return qtyBought;
    }
    public void setOrderNum(int orderNum) {
        this.orderNum = orderNum;
    }
    public void setProd_code(int prod_code) {
        this.prod_code = prod_code;
    }
    public void setQtyBought(int qtyBought) {
        this.qtyBought = qtyBought;
    }
}