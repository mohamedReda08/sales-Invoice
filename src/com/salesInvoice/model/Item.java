/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesInvoice.model;

/**
 *
 * @author moham
 */
public class Item {

    private int id;
    private String itemName;
    private double price;
    private int count;
    private Invoice invoice;

    public Item(int id, String itemName, double price, int count, Invoice invoice) {
        this.id = id;
        this.itemName = itemName;
        this.price = price;
        this.count = count;
        this.invoice = invoice;
    }

    public double getItemTotal(){
        return price*count;
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }



}
