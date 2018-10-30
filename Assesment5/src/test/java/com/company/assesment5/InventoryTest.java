package com.company.assesment5;

import com.company.assesment5.dao.InventoryOperationsDAOImpl;
import com.company.assesment5.dto.InventoryItemDTO;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

import static org.junit.Assert.assertEquals;

public class InventoryTest {



        private String itemName;
        private double costPrice;
        private double sellPrice;
        private int quantity;
        InventoryOperationsDAOImpl inventoryOperationsImp;

        InventoryItemDTO dtoList;

        @Before //Executed before each test. It is used to prepare the test environment
        public void setUp() {
            System.out.println("Inside @Before");
            inventoryOperationsImp = new InventoryOperationsDAOImpl();
            itemName = "BOOK01";
            costPrice = 10.50;
            sellPrice = 13.00;
            quantity = 100;
        }


        @Test
        public void testDAO(){
            System.out.println("Inside testDAO");
            List<InventoryItemDTO> itemDTOList = null;
        try{
                itemDTOList = inventoryOperationsImp.getItemList();
        } catch (Exception e) {
            e.printStackTrace();
        }

            System.out.println(itemDTOList.size());

            assertEquals(4, itemDTOList.size());

            assertEquals("Book01", itemDTOList.get(0).getItem_name());
            assertEquals(10.50, itemDTOList.get(0).getCost_price(), 0);
            assertEquals(13, itemDTOList.get(0).getSelling_price(), 0);
            assertEquals(100, itemDTOList.get(0).getAvailable_qty());

        }



    }



