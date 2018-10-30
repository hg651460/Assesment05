package com.company.assesment5;

import com.company.assesment5.dao.InventoryOperationsDAOImpl;

import java.util.Scanner;

public class Main {

public static void main(String [] args){

    InventoryOperationsDAOImpl inventoryList = new InventoryOperationsDAOImpl();


    System.out.println("Enter one of the operation below :");
    System.out.println("Add item : 'CREATE'");
    System.out.println("Delete item : 'DELETE'");
    System.out.println("Update buy quantity : UPDATEBUY");
    System.out.println("Update item sold quantity : UPDATESELL");
    System.out.println("Generate report : REPORT");
    System.out.println("End the operation : QUIT");

    Scanner scan = new Scanner(System.in);
    String operation ;
    int quantity;

    String itemName;
    double costPrice, sellPrice;

    do {
        System.out.println("Enter operation you want to perform :");
        operation = scan.nextLine().toUpperCase();
        switch (operation) {

            case "CREATE":
                System.out.println("Enter item name");
                itemName = scan.nextLine();
                System.out.println("Enter cost price");
                costPrice = scan.nextDouble();
                System.out.println("Enter sell price");
                sellPrice = scan.nextDouble();
                try {
                    inventoryList.create(itemName, costPrice, sellPrice);
                } catch (Exception e) {
                    e.printStackTrace();
                }

                break;

            case "DELETE":
                System.out.println("Enter item name to be deleted");
                itemName = scan.nextLine();
                try {
                    inventoryList.delete(itemName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "UPDATEBUY":
                System.out.println("Enter item name");
                itemName = scan.nextLine();
                System.out.println("Enter no of items bought");
                quantity = scan.nextInt();
                try {
                    inventoryList.updateBuy(itemName, quantity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "UPDATESELL":
                System.out.println("Enter item name to be deleted");
                itemName = scan.nextLine();
                System.out.println("Enter no of items sold");
                quantity = scan.nextInt();
                try {
                    inventoryList.updateSell(itemName, quantity);
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "REPORT":
                System.out.println("********REPORT***********");
                try {
                    inventoryList.report();
                } catch (Exception e) {
                    e.printStackTrace();
                }
                break;

            case "QUIT" :
                System.out.println("Quiting operations");
                break;

            default:
                System.out.println("Invalid Argument");
                break;
        }

    }while (!operation.equalsIgnoreCase("QUIT"));
    }

}

