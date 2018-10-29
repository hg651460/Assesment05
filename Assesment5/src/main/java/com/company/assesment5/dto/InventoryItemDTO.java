package com.company.assesment5.dto;

public class InventoryItemDTO {

    private int id;
    private String item_name;
    private double cost_price;
    private double selling_price;
    private int available_qty;


    public InventoryItemDTO(int id, String item_name, double cost_price, double selling_price, int available_qty) {
        this.id = id;
        this.item_name = item_name;
        this.cost_price = cost_price;
        this.selling_price = selling_price;
        this.available_qty = available_qty;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItem_name() {
        return item_name;
    }

    public void setItem_name(String item_name) {
        this.item_name = item_name;
    }

    public double getCost_price() {
        return cost_price;
    }

    public void setCost_price(double cost_price) {
        this.cost_price = cost_price;
    }

    public double getSelling_price() {
        return selling_price;
    }

    public void setSelling_price(double selling_price) {
        this.selling_price = selling_price;
    }

    public int getAvailable_qty() {
        return available_qty;
    }

    public void setAvailable_qty(int available_qty) {
        this.available_qty = available_qty;
    }


    @Override
    public String toString() {
        return "InventoryItemDTO{" +
                "id=" + id +
                ", item_name='" + item_name + '\'' +
                ", cost_price=" + cost_price +
                ", selling_price=" + selling_price +
                ", available_qty=" + available_qty +
                '}';
    }
}
