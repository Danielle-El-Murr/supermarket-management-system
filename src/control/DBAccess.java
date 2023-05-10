/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package control;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.*;

/**
 *
 * @author user
 */
public class DBAccess {

    private Connection connection;
    private Statement statement;

    private void connect() throws SQLException {
        connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/supermarket", "root", "");
        statement = connection.createStatement();
    }

    private void close() throws SQLException {
        statement.close();
        connection.close();
    }

    public ArrayList<Integer> getAllBrIds() {
        ArrayList<Integer> brIds = new ArrayList();
        String query = "SELECT br_id FROM branch;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                brIds.add(RS.getInt("br_id"));//br_id is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return brIds;
    }

    public Branch getBranchById(int br_id) {
        Branch br = null;
        String query = "SELECT * FROM branch WHERE br_id=" + br_id + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            if (RS.next()) {
                br = new Branch(br_id, RS.getInt("extNum"), RS.getString("city"), RS.getString("street"), RS.getString("m_fname"),
                        RS.getString("m_lname"));
                RS.close();
            }
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return br;
    }

    public ArrayList<String> getAvailableProductsPerBranch(int br_id) {
        ArrayList<String> getProducts = new ArrayList();
        String query = "SELECT prod_code, name, category, price, manf, Qty FROM contain NATURAL "
                + "JOIN product WHERE br_id=" + br_id + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                getProducts.add(String.valueOf(RS.getInt("prod_code")));
                getProducts.add(RS.getString("name"));
                getProducts.add(RS.getString("category"));
                getProducts.add(String.valueOf(RS.getDouble("price")));
                getProducts.add(RS.getString("manf"));
                getProducts.add(String.valueOf(RS.getInt("Qty")));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getProducts;
    }

    public void deleteProduct(int prod_code) {
        String query = "DELETE FROM product WHERE prod_code=" + prod_code + ";";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addProduct(Product prod) {
        String query = "INSERT INTO product VALUES(" + prod.getProd_code() + ", '" + prod.getName() + "', '" + prod.getCategory() + "', "
                + prod.getPrice() + ", '" + prod.getManf() + "');";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addContain(Contain con) {
        String query = "INSERT INTO contain VALUES(" + con.getBr_id() + ", " + con.getProd_code() + ", " + con.getQty() + ");";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Integer> getAllProdCodes(int br_id) {
        ArrayList<Integer> prodCodes = new ArrayList();
        String query = "SELECT prod_code FROM contain WHERE br_id=" + br_id + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                prodCodes.add(RS.getInt("prod_code"));//prod_code is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return prodCodes;
    }

    public ArrayList<String> getAvailableCashiersPerBranch(int br_id) {
        ArrayList<String> getCashiers = new ArrayList();
        String query = "SELECT cas_id, c_fname, c_lname, cas_PNum, salary, joinYear FROM "
                + "cashier WHERE br_id=" + br_id + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                getCashiers.add(String.valueOf(RS.getInt("cas_id")));
                getCashiers.add(RS.getString("c_fname"));
                getCashiers.add(RS.getString("c_lname"));
                getCashiers.add(String.valueOf(RS.getInt("cas_PNum")));
                getCashiers.add(String.valueOf(RS.getDouble("salary")));
                getCashiers.add(String.valueOf(RS.getInt("joinYear")));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getCashiers;
    }

    public void deleteCashier(int cas_id) {
        String query = "DELETE FROM cashier WHERE cas_id=" + cas_id + ";";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Integer> getAllCashIds(int br_id) {
        ArrayList<Integer> cashIds = new ArrayList();
        String query = "SELECT cas_id FROM cashier WHERE br_id=" + br_id + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                cashIds.add(RS.getInt("cas_id"));//cas_id is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cashIds;
    }

    public void addCashier(Cashier cas) {
        String query = "INSERT INTO cashier VALUES(" + cas.getCas_id() + ", '" + cas.getC_fname() + "', '" + cas.getC_lname() + "', "
                + cas.getCas_PNum() + ", " + cas.getSalary() + ", " + cas.getJoinYear() + ", " + cas.getBr_id() + ");";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateCashier(int cas_id, double salary, int cas_PNum) {
        String query = "UPDATE cashier SET salary=" + salary + ",cas_PNum=" + cas_PNum + " WHERE cas_id=" + cas_id + ";";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    public ArrayList<Integer> getAllCusIds() {
        ArrayList<Integer> cusIds = new ArrayList();
        String query = "SELECT cus_id FROM customer;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                cusIds.add(RS.getInt("cus_id"));//cus_id is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return cusIds;
    }

    public void addCustomer(Customer cus) {
        String query = "INSERT INTO customer VALUES(" + cus.getCus_id() + ", '" + cus.getFname() + "', '" + cus.getLname() + "', "
                + cus.getAge() + ", " + cus.getCus_PNum() + ");";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<String> getProductAttributes(int br_id, int prod_code) {
        ArrayList<String> getProdAtt = new ArrayList();
        String query = "SELECT name, category, price, qty FROM contain NATURAL JOIN product"
                + " WHERE br_id=" + br_id + " AND prod_code=" + prod_code + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                getProdAtt.add(RS.getString("name"));
                getProdAtt.add(RS.getString("category"));
                getProdAtt.add(String.valueOf(RS.getDouble("price")));
                getProdAtt.add(String.valueOf(RS.getInt("qty")));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getProdAtt;
    }

    public ArrayList<Integer> getAllOrderNumbers() {
        ArrayList<Integer> orderNumbers = new ArrayList();
        String query = "SELECT orderNum FROM orders;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                orderNumbers.add(RS.getInt("orderNum"));//orderNum is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderNumbers;
    }

    public void addOrder(Orders ord) {
        String query = "INSERT INTO orders VALUES(" + ord.getOrderNum() + ", '" + ord.getDate() + "', '" + ord.getPaymentType()
                + "', " + ord.getCus_id() + ", " + ord.getCas_id() + ", " + ord.getBr_id() + ");";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void addIncludes(Includes inc) {
        String query = "INSERT INTO includes VALUES(" + inc.getOrderNum() + ", " + inc.getProd_code() + ", "
                + inc.getQtyBought() + ");";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void updateProdQuantity(int br_id, int prod_code, int qtyBought) {
        String query = "UPDATE contain SET qty=qty-" + qtyBought + " WHERE br_id=" + br_id + ""
                + " AND prod_code=" + prod_code + ";";
        try {
            connect();
            statement.executeUpdate(query);
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public ArrayList<Double> getOrderTotalPriceOfEachInc(int orderNum) {
        ArrayList<Double> orderTotPriceOfEachInc = new ArrayList();
        String query = "SELECT price*qtyBought as totalPrice FROM includes NATURAL JOIN product "
                + "WHERE orderNum=" + orderNum + ";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                orderTotPriceOfEachInc.add(RS.getDouble("totalPrice"));//totalPrice is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return orderTotPriceOfEachInc;
    }

    public ArrayList<String> Ftask1() {
        ArrayList<String> Ftask1Ans = new ArrayList();
        String query = "SELECT name,price FROM product WHERE price=(SELECT MAX(price) FROM product);";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Ftask1Ans.add(RS.getString("name"));
                Ftask1Ans.add(String.valueOf(RS.getDouble("price")));//price is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ftask1Ans;
    }

    public ArrayList<Integer> getAllCasIds() {
        ArrayList<Integer> casIds = new ArrayList();
        String query = "SELECT cas_id FROM cashier;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                casIds.add(RS.getInt("cas_id"));//cas_id is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return casIds;
    }

    public ArrayList<String> Ftask2(int cas_id) {
        ArrayList<String> Ftask2Ans = new ArrayList();
        String query = "SELECT cus_PNum FROM customer NATURAL JOIN orders WHERE cas_id=" + cas_id + " GROUP BY cus_id;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Ftask2Ans.add(String.valueOf(RS.getInt("cus_PNum")));//cus_PNum is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ftask2Ans;
    }

    public int Ftask3() {
        int count = 0;
        String query = "SELECT count(*) as cashierNumbers FROM cashier NATURAL JOIN branch WHERE street='Hamra';";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                count = RS.getInt("cashierNumbers");//cashierNumbers is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }

    public ArrayList<Integer> Dtask1() {
        ArrayList<Integer> Dtask1Ans = new ArrayList();
        String query = "SELECT orderNum FROM orders NATURAL JOIN customer WHERE cus_PNum LIKE '%517';";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Dtask1Ans.add(RS.getInt("orderNum"));//orderNum is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dtask1Ans;
    }

    public ArrayList<Integer> Dtask2(String paymentType) {
        ArrayList<Integer> Dtask2Ans = new ArrayList();
        String query = "SELECT orderNum FROM orders WHERE paymentType='" + paymentType + "';";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Dtask2Ans.add(RS.getInt("orderNum"));//orderNum is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dtask2Ans;
    }
    public ArrayList<String> Dtask2New(String paymentType) {
        ArrayList<String> Dtask2Ans = new ArrayList();
        String query = "SELECT orderNum, fname, c_fname FROM orders "
                + "NATURAL join customer NATURAL JOIN cashier WHERE paymentType='"+paymentType+"';";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Dtask2Ans.add(String.valueOf(RS.getInt("orderNum")));//orderNum is the name of the column in the database
                Dtask2Ans.add(RS.getString("fname"));
                Dtask2Ans.add(RS.getString("c_fname"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dtask2Ans;
    }

    public ArrayList<String> Dtask3() {
        ArrayList<String> Dtask3Ans = new ArrayList();
        String query = "SELECT p1.name AS p1name, p2.name AS p2name FROM product p1, product p2 NATURAL JOIN includes NATURAL JOIN orders WHERE "
                + "p1.prod_code<p2.prod_code AND p1.price=p2.price AND cas_id=cas_id;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Dtask3Ans.add(RS.getString("p1name"));
                Dtask3Ans.add(RS.getString("p2name"));//p2name is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dtask3Ans;
    }

    public ArrayList<String> Dtask4() {
        ArrayList<String> Dtask4Ans = new ArrayList();
        String query = "SELECT c_fname,salary FROM cashier ORDER BY salary DESC;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Dtask4Ans.add(RS.getString("c_fname"));
                Dtask4Ans.add(String.valueOf(RS.getDouble("salary")));//salary is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Dtask4Ans;
    }

    public ArrayList<String> Wtask1() {
        ArrayList<String> Wtask1Ans = new ArrayList();
        String query = "SELECT cas1.c_fname AS C1fname,cas2.c_fname AS C2fname FROM cashier cas1,cashier cas2 "
                + "WHERE cas1.br_id=cas2.br_id AND cas1.cas_id<cas2.cas_id AND cas1.joinYear=cas2.joinYear;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Wtask1Ans.add(RS.getString("C1fname"));
                Wtask1Ans.add(RS.getString("C2fname"));//C2fname is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Wtask1Ans;
    }

    public double Wtask2() {
        double avgPrice = 0;
        String query = "SELECT AVG(salary) AS avgSalary FROM "
                + "cashier NATURAL JOIN branch WHERE city='Beirut' AND street='Ashrafieh';";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                avgPrice = (RS.getDouble("avgSalary"));//avgSalary is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return avgPrice;
    }

    public ArrayList<String> Wtask3() {
        ArrayList<String> Wtask3Ans = new ArrayList();
        String query = "SELECT manf,MAX(price) AS maxPrice FROM product GROUP BY manf;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Wtask3Ans.add(RS.getString("manf"));
                Wtask3Ans.add(String.valueOf(RS.getDouble("maxPrice")));//maxPrice is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Wtask3Ans;
    }

    public ArrayList<String> Wtask4() {
        ArrayList<String> Wtask4Ans = new ArrayList();
        String query = "SELECT fname,lname,age FROM customer WHERE fname LIKE '______' AND cus_id \n"
                + "IN (SELECT cus_id FROM orders WHERE paymentType='Cash');";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Wtask4Ans.add(RS.getString("fname"));
                Wtask4Ans.add(RS.getString("lname"));
                Wtask4Ans.add(String.valueOf(RS.getInt("age")));//age is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Wtask4Ans;
    }

    public ArrayList<String> Wtask5(int cus_id) {
        ArrayList<String>WFtask5Ans = new ArrayList();
        String query = "SELECT name,qtyBought FROM product NATURAL JOIN includes NATURAL JOIN orders \n"
                + "WHERE cus_id="+cus_id+";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                WFtask5Ans.add(RS.getString("name"));
                WFtask5Ans.add(String.valueOf(RS.getInt("qtyBought")));//qtyBought is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return WFtask5Ans;
    }
    public ArrayList<String> Htask1() {
        ArrayList<String>Htask1Ans = new ArrayList();
        String query = "SELECT manf,SUM(price) AS sumPrice FROM product GROUP BY manf;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Htask1Ans.add(RS.getString("manf"));
                Htask1Ans.add(String.valueOf(RS.getDouble("sumPrice")));//sumPrice is the name of the column in the database
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Htask1Ans;
    }
    public ArrayList<String> Htask2() {
        ArrayList<String>Htask2Ans = new ArrayList();
        String query = "SELECT customer.fname FROM customer NATURAL JOIN orders NATURAL "
                + "JOIN includes NATURAL JOIN product where age<18 and category='Alcohol' GROUP BY customer.fname;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Htask2Ans.add(RS.getString("fname"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Htask2Ans;
    }
    public int Htask3(double price){
        int count=0;
        String query ="SELECT COUNT(cus_id) AS count FROM product NATURAL JOIN includes NATURAL JOIN orders WHERE price<"+price+";";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                count=(RS.getInt("count"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public ArrayList<String> Htask4() {
        ArrayList<String>Htask4Ans = new ArrayList();
        String query = "SELECT c_fname,c_lname FROM cashier "
                + "WHERE cas_PNum in (SELECT customer.cus_PNum FROM customer NATURAL join orders);";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Htask4Ans.add(RS.getString("c_fname"));
                Htask4Ans.add(RS.getString("c_lname"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Htask4Ans;
    }
    public ArrayList<String> Ttask1() {
        ArrayList<String>Ttask1Ans = new ArrayList();
        String query = "SELECT name FROM product NATURAL JOIN branch NATURAL JOIN "
                + "contain WHERE city='Mount Lebanon' AND street='Dbayeh' ORDER BY name,price;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Ttask1Ans.add(RS.getString("name"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ttask1Ans;
    }
    public int Ttask2(){
        int count=0;
        String query ="SELECT COUNT(*) AS count FROM (SELECT COUNT(*) FROM orders WHERE dateAndTime "
                + "LIKE '2020-10-12%' GROUP BY cus_id HAVING COUNT(*)>3) AS c;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                count=(RS.getInt("count"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return count;
    }
    public ArrayList<String> getAvailableBranchCities() {
        ArrayList<String> getCities = new ArrayList();
        String query = "SELECT city FROM branch GROUP BY city;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                getCities.add(RS.getString("city"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return getCities;
    }
    public ArrayList<String> Ttask3(String city) {
        ArrayList<String>Ttask3Ans = new ArrayList();
        String query = "SELECT name FROM product NATURAL JOIN orders "
                + "NATURAL JOIN includes NATURAL JOIN branch WHERE city='"+city+"' GROUP by name;";
        try {
            connect();
            ResultSet RS = statement.executeQuery(query);
            for (; RS.next();) {
                Ttask3Ans.add(RS.getString("name"));
            }
            RS.close();
            close();
        } catch (SQLException ex) {
            Logger.getLogger(DBAccess.class.getName()).log(Level.SEVERE, null, ex);
        }
        return Ttask3Ans;
    }
}
