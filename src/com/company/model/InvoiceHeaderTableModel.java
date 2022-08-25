package com.company.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.List;

public class InvoiceHeaderTableModel extends AbstractTableModel {


    private List<InvoiceFrame> invoicesLists;
    private DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");

    //getters
    public DateFormat getDateFormat() {
        return dateFormat;
    }
    public InvoiceHeaderTableModel(List<InvoiceFrame> invoicesLists){
        this.invoicesLists = invoicesLists;
    }

    @Override
    public int getRowCount() {
        return invoicesLists.size();
    }

    public List<InvoiceFrame> getInvoicesLists() {
        return invoicesLists;
    }

    @Override
    public int getColumnCount() {
        return 4;
    }

    @Override
    // done
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceFrame row= invoicesLists.get(rowIndex);
        switch(columnIndex){
            case 0: return row.getInvNum();
            case 1: return row.getCustomerName();
            case 2: return dateFormat.format(row.getInvDate());
            case 3: return row.getTotalInvoice();
            default:
                return null;
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0: return Integer.class;
            case 1: return String.class;
            case 2: return String.class;
            case 3: return Double.class;
            default: return Object.class;
        }
    }

    public boolean CheckCell(int rowIndex , int columnIndex){
        return false;
    }

}

