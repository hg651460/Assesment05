package com.company.assesment5.dao;

import com.company.assesment5.dto.InventoryItemDTO;

import java.util.List;

public interface InventoryOperations {

    //read database
public List<InventoryItemDTO> getItemList () throws Exception;

public void create(String itemName, double costPrice, double sellingPrice);

public void delete(String itemName) throws Exception;

public void updateBuy(String itemName, int quantity);

public void updateSell(String itemName, int quantity) throws Exception;

public void report();

public void updateSellPrice(String itemName, double newSellPrice);
}
