package com.company.model;


import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

public class InvoiceFrame {
    private int invNum;
    private String customerName;
    private Date invDate;
    private ArrayList<InvoiceLine> lines;

    public InvoiceFrame(int invNum, String customerName, Date invDate) {
        this.invNum = invNum;
        this.customerName = customerName;
        this.invDate = invDate;
    }

    public Date getInvDate() {
        return invDate;
    }

    public void setInvDate(Date invDate) {
        this.invDate = invDate;
    }

    public int getInvNum() {
        return invNum;
    }

    public void setInvNum(int invNum) {
        this.invNum = invNum;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }


    @Override
    // to return the colume without any changes
    public String toString() {
        String allstr="InvoiceFrame{" + "invoiceNb=" + invNum + ", name=" + customerName + ", invoiceDate=" + invDate + '}' ;
            for (InvoiceLine col : getLines()) {
                allstr += "\n\t" + col;
            }
            return allstr;
        }
    // add new col if its emptyy i.e equal to null by checking all tables
    public ArrayList<InvoiceLine> getLines() {
        if (lines==null)
        // lazy creation
            lines = new ArrayList<>();
        return lines;
    }

    public double getTotalInvoice(){
        double tol=0;
        for(InvoiceLine table :getLines()) {
            tol += table. getTotalCol();
        }
        return tol;
    }
    // add new col
    public void addNewCol(InvoiceLine table){
        getLines().add(table);
    }

    // get data from the excel file
    public String getCSV(){
        DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
        return "" + getInvNum() + " , " + dateFormat.format(getInvDate()) + " , " + getCustomerName();
    }
}