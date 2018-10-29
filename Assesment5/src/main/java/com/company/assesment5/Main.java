package com.company.assesment5;

import com.company.assesment5.dao.InventoryOperationsImp;

public class Main {

public static void main(String [] args){

    InventoryOperationsImp inventoryList = new InventoryOperationsImp();

   System.out.println("**************GET ITEMS FROM TABLE BEFORE OPERATIONS*****************");

        try {
                 inventoryList.getItemList();
        } catch (Exception e) {
            e.printStackTrace();
        }

     System.out.println("**************ADD ITEMS*****************");

    try {
               inventoryList.create("Pen", 0.50,1.0);
         } catch (Exception e) {
              e.printStackTrace();
        }

    System.out.println("**************UPDATE ITEM*****************");

    try {
        inventoryList.updateBuy("Pen", 10);
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("**************UPDATE ITEMS*****************");

    try {
        inventoryList.updateSell("Pen", 2);
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("**************DELETE ITEMS*****************");

    try {
        inventoryList.delete("pen");
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("**************TABLE REPORT*****************");

    try {
        inventoryList.report();
    } catch (Exception e) {
        e.printStackTrace();
    }

    System.out.println("**************GET ITEMS FROM TABLE AFTER Selling price update*****************");

    try {
        inventoryList.updateSellPrice("BOOK01", 10);
    } catch (Exception e) {
        e.printStackTrace();
    }
}
}
