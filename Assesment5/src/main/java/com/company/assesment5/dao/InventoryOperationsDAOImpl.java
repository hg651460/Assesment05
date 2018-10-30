package com.company.assesment5.dao;

import com.company.assesment5.dto.InventoryItemDTO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class InventoryOperationsDAOImpl implements InventoryOperationsDAO {

    static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    static final String DB_URL = "jdbc:mysql://localhost:3306/inventory?allowPublicKeyRetrieval=true&useSSL=false";

    //  Database credentials
    static final String USER = "root";
    static final String PASSWORD = "mysqlroot";

    Connection conn = null;
    Statement statement = null;
    List<InventoryItemDTO> itemList;
    static double profit = 0;

    public List<InventoryItemDTO> getItemList() {

        //SELECT * FROM inventory.inventory_table;
        itemList = new ArrayList<InventoryItemDTO>();

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();
            String sql;
            sql = "SELECT * FROM inventory.inventory_table;";
            System.out.println(sql);
            ResultSet rs = statement.executeQuery(sql);

            System.out.println(" Item Name: " + "\t" + " Bought At: " + "\t" + " Sold At: " + "\t" + " AvailableQty: "+ "\t\t" + " Value: ");
            //STEP 5: Extract data from result set
            while(rs.next()){
                //Retrieve by column name
                int id  = rs.getInt("id");
                String item_name = rs.getString("item_name");
                double cost_price = rs.getDouble("cost_price");
                double selling_price = rs.getDouble("selling_price");
                int quantity = rs.getInt("quantity");
                InventoryItemDTO inventoryItemDTO = new InventoryItemDTO(id, item_name, cost_price, selling_price, quantity);
                itemList.add(inventoryItemDTO);
                //Display values
                //System.out.println(inventoryItemDTO.toString());
            }
            //STEP 6: Clean-up environment
            rs.close();
            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        }catch(Exception e){
            //Handle errors for Class.forName
            e.printStackTrace();
        }finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
        return itemList;
    }

    public void create(String itemName, double costPrice, double sellingPrice) {

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();

            String sql;
            sql = "INSERT INTO `inventory`.`inventory_table` (`item_name`,`cost_price`,`selling_price`,`quantity`)\n" +
                    "VALUES \n" +
                    "( '" +itemName +"',"+costPrice +"," + sellingPrice +"," + 0 +");";
            System.out.println(sql);

            System.out.println(sql);
             statement.executeUpdate(sql);

            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public void delete(String itemName) throws Exception {

//        for (int i=0; i<itemList.size(); i++) {
//
//            if(itemList.get(i).getItem_name().equalsIgnoreCase(itemName)){
//                profit =profit + (itemList.get(i).getSelling_price()-itemList.get(i).getCost_price())
//                        * itemList.get(i).getAvailable_qty();
//            }else{
//                throw new Exception("Item not found" +itemName);
//            }
//        }

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();

            String sql;
            sql = "DELETE FROM inventory.inventory_table \n" +
                    "WHERE item_name ='"+itemName+"';";
            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try
    }

    public void updateBuy(String itemName, int quantity) {

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();

            String sql;
            sql = "UPDATE inventory.inventory_table \n" +
                    "SET quantity = quantity + "+quantity+" WHERE item_name Like '"+itemName+"';";

            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public void updateSell(String itemName, int quantity) throws Exception {

        for (int i=0; i<itemList.size(); i++) {

            if(itemList.get(i).getItem_name().equalsIgnoreCase(itemName)){
                profit = profit + (itemList.get(i).getSelling_price()-itemList.get(i).getCost_price())
                        * quantity ;
            }else{
                throw new Exception("Item not found" +itemName);
            }
        }

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();

            String sql;
            sql = "UPDATE inventory.inventory_table \n" +
                    "SET quantity = quantity - "+quantity+" WHERE item_name Like '"+itemName+"';";
            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

    }

    public void report() {

        getItemList();

        double total_value = 0;

        for (InventoryItemDTO item:itemList) {
            double value = item.getCost_price() * item.getAvailable_qty();
            System.out.println(item.toString()+" \t\t" +value);
            total_value = total_value + value;
        }

        System.out.println("Total Value          "+ total_value);
        System.out.println("Profit since previous report          "+ profit);

        profit = 0;
    }

    public void updateSellPrice(String itemName, double newSellPrice) {
        System.out.println("Profit before sells price update");
        report();

        try{
            //STEP 2: Register JDBC driver
            Class.forName(JDBC_DRIVER);
            //STEP 3: Open a connection
            System.out.println("Connecting to database...");
            conn = DriverManager.getConnection(DB_URL,USER,PASSWORD);
            //STEP 4: Execute a query
            System.out.println("Creating statement...");
            statement = conn.createStatement();

            String sql;
            sql = "UPDATE inventory.inventory_table \n" +
                    "SET selling_price = "+newSellPrice+" WHERE item_name Like '"+itemName+"';";
            System.out.println(sql);
            statement.executeUpdate(sql);

            statement.close();
            conn.close();
        }catch(SQLException se){
            //Handle errors for JDBC
            se.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally{
            //finally block used to close resources
            try{
                if(statement!=null)
                    statement.close();
            }catch(SQLException se2){
            }// nothing we can do
            try{
                if(conn!=null)
                    conn.close();
            }catch(SQLException se){
                se.printStackTrace();
            }//end finally try
        }//end try

        getItemList();
        report();


    }

}
