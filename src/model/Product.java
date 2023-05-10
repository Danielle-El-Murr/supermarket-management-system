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
public class Product {
    private int prod_code;
    private double price;
    private String name,category,manf;
    public Product(int prod_code, String name, String category, double price, String manf) {
        this.prod_code = prod_code;
        this.price = price;
        this.name = name;
        this.category = category;
        this.manf = manf;
    }
    public int getProd_code() {
        return prod_code;
    }
    public double getPrice() {
        return price;
    }
    public String getName() {
        return name;
    }
    public String getCategory() {
        return category;
    }
    public String getManf() {
        return manf;
    }
    public void setProd_code(int prod_code) {
        this.prod_code = prod_code;
    }
    public void setPrice(double price) {
        this.price = price;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setCategory(String category) {
        this.category = category;
    }
    public void setManf(String manf) {
        this.manf = manf;
    }
}