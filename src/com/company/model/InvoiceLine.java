package com.company.model;

import java.text.DateFormat;
import java.text.SimpleDateFormat;

public class InvoiceLine {

    private String itemName;
    private double itemPrice;
    private int itemCount;
    private double totalCol;
    private InvoiceFrame header;

    // getters and setters
    public double getItemPrice() {
        return itemPrice;
    }
    public void setItemPrice(double itemPrice) {
        this.itemPrice = itemPrice;
    }
    public int getItemCount() {
        return itemCount;
    }
    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }
    public double getTotalCol() {
        return totalCol;
    }
    public void setTotalCol(double total) {
        this.totalCol = total;
    }
    public InvoiceFrame getHeader() {
        return header;
    }
    public void setHeader(InvoiceFrame header) {
        this.header = header;
    }
    public String getItemName() {
        return itemName;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public InvoiceLine(String itemName, double itemPrice, int itemCount, InvoiceFrame header){
        this.itemName=itemName;
        this.header=header;
        this.itemCount=itemCount;
        this.itemPrice=itemPrice;
        this.setTotalCol(this.itemCount*this.itemPrice);
    }

    // get data from the excel file
    public String getCSV(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getHeader().getInvNum() + " , " + getItemName()+ " , " + getItemPrice()+ " , " + getItemCount();
    }

}
