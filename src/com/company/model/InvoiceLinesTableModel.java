package com.company.model;

import javax.swing.table.AbstractTableModel;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class InvoiceLinesTableModel extends AbstractTableModel {

    private ArrayList<InvoiceLine> invoiceTables;
    private DateFormat dateFormat= new SimpleDateFormat("dd-MM-yyyy");

    public InvoiceLinesTableModel(List<InvoiceLine> invoiceLines) {
    }


    //getters
    public List<InvoiceLine> getInvoiceTables() {
        return invoiceTables;
    }
    public DateFormat getDateFormat() {
        return dateFormat;
    }



    @Override
    //done
    public int getRowCount() {
        return invoiceTables.size();
    }
    @Override
    //done 4 as in the given pic
    public int getColumnCount() {
        return 4;
    }

    @Override
    // done
    public Object getValueAt(int rowIndex, int columnIndex) {
        InvoiceLine row= invoiceTables.get(rowIndex);
        switch(columnIndex){
            case 0: return row.getItemName();
            case 1: return row.getItemPrice();
            case 2: return row.getItemCount();
            case 3: return row.getTotalCol();
            default:
                return null;
        }

    }

    @Override
    public Class<?> getColumnClass(int columnIndex){
        switch (columnIndex){
            case 0: return String.class;
            case 1: return Double.class;
            case 2: return Integer.class;
            case 3: return Double.class;
            default: return Object.class;
        }
    }

    public boolean CheckCell(int rowIndex , int columnIndex){
        return false;
    }
}
