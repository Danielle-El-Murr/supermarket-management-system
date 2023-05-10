/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.util.ArrayList;
import model.*;

/**
 *
 * @author user
 */
public class AppController {
    ArrayList<Includes> cart;
    DBAccess DBA;
    public AppController(){
        DBA=new DBAccess();
        cart=new ArrayList();
    }
    public Product addProduct(int prod_code, String name, String category, double price, String manf){
        Product prod=new Product(prod_code, name, category, price, manf);
        return prod;
    }
    public Contain addContain(int br_id, int prod_code, int qty){
        Contain con=new Contain(br_id, prod_code, qty);
        return con;
    }
    public boolean checkProductCode(int br_id,int code){
        ArrayList<Integer> productsCodesOfThisBranch=DBA.getAllProdCodes(br_id);
        for(int i=0;i<productsCodesOfThisBranch.size();i++)
            if(code==productsCodesOfThisBranch.get(i))
                return false;
        return true;
    }
    public Cashier addCashier(int cas_id, int cas_PNum, int joinYear, int br_id, double salary, String c_fname, String c_lname){
        Cashier cas=new Cashier(cas_id, cas_PNum, joinYear, br_id, salary, c_fname, c_lname);
        return cas;
    }
    public boolean checkCashierId(int br_id,int cas_id){
        ArrayList<Integer> cashiersIdsOfThisBranch=DBA.getAllCashIds(br_id);
        for(int i=0;i<cashiersIdsOfThisBranch.size();i++)
            if(cas_id==cashiersIdsOfThisBranch.get(i))
                return false;
        return true;
    }
    public Customer addCustomer(int cus_id, int age, int cus_PNum, String fname, String lname){
        Customer cus=new Customer(cus_id, age, cus_PNum, fname, lname);
        return cus;
    }
    public boolean checkCustomerId(int cus_id){
        ArrayList<Integer> customersIds=DBA.getAllCusIds();
        for(int i=0;i<customersIds.size();i++)
            if(cus_id==customersIds.get(i))
                return false;
        return true;
    }
    public void addToCart(int orderNum, int prod_code, int qtyBought){
        Includes Inc=new Includes(orderNum, prod_code, qtyBought);
        cart.add(Inc);
    }
    public ArrayList<Includes> getCart(){
        return cart;
    }
    public boolean checkOrderNum(int orderNum){
        ArrayList<Integer> ordersNumbers=DBA.getAllOrderNumbers();
        for(int i=0;i<ordersNumbers.size();i++)
            if(orderNum==ordersNumbers.get(i))
                return false;
        return true;
    }
    public Orders addOrder(int orderNum, int cus_id, int cas_id, int br_id, String date, String paymentType){
        Orders ord=new Orders(orderNum, cus_id, cas_id, br_id, date, paymentType);
        return ord;
    }
}
