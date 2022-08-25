package com.company.control;

import com.company.MainFrame;
import com.company.model.InvoiceFrame;
import com.company.model.InvoiceHeaderTableModel;
import com.company.model.InvoiceLine;
import com.company.model.InvoiceLinesTableModel;
import com.company.view.InvoiceHeaderDialog;
import com.company.view.InvoiceLineDialog;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;


public class SaleGeneratorListener implements ActionListener, ListSelectionListener {

    private MainFrame frame;
    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private InvoiceLineDialog lineD;
    private InvoiceHeaderDialog HeaderD;
    private InvoiceHeaderTableModel InvoiceHeaderTableModel;

    public SaleGeneratorListener(MainFrame frame) {
        this.frame = frame;
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                displayNewInvoice();
                break;
            case "DeleteInvoice":
                deleteCreatedInvoice();
                break;
            case "CreateNewRow":
                displayNewColDialog();
                break;
            case "DeleteRow":
                deleteRow();
                break;
            case "LoadFile":
                LoadFile();
                break;
            case "SaveFile":
                saveData();
                break;
            case "createCancelChanges":
                createCancelChanges();
                break;
            case "createInvoiceOKBtn":
                createInvoiceOKBtn();
                break;
            case "createRowCancel":
                createRowCancel();
                break;
            case "createOK":
                createOK();
                break;
        }
    }

    private void deleteCreatedInvoice() {
    }

    private void displayNewColDialog() {
    }

    private void saveData() {
    }

    private void createInvoiceOKBtn() {
    }

    private void createCancelChanges() {
    }

    private void createRowCancel() {
    }

    private void deleteRow() {
    }

    private void displayNewInvoice() {
    }

    private void createOK() {
    }

    // done
    private void LoadFile() {
        JOptionPane.showMessageDialog(frame, "Please, Select a Header File!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(frame);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try {
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader(headerFr);
                String headerLine = null;

                while ((headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invoiceNumberString = headerParts[0];
                    String invoiceDateString = headerParts[1];
                    String customerName = headerParts[2];

                    int invoiceNumber = Integer.parseInt(invoiceNumberString);
                    Date invoiceDate = dateFormat.parse(invoiceDateString);

                    InvoiceFrame inv = new InvoiceFrame(invoiceNumber, customerName, invoiceDate);
                    frame.getInvoicesList().add(inv);

                }

                JOptionPane.showMessageDialog(frame, "Please, select lines file!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(frame);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr = new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) != null) {
                        String[] lineParts = linesLine.split(",");
                        String invoiceNumberString = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceString = lineParts[2];
                        String itemCountString = lineParts[3];
                        int invoiceNumber = Integer.parseInt(invoiceNumberString);
                        double itemPrice = Double.parseDouble(itemPriceString);
                        int itemCount = Integer.parseInt(itemCountString);

                    }
                }
                System.out.println("Check");
            } catch (ParseException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Date Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (NumberFormatException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Number Format Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (FileNotFoundException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "File Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            } catch (IOException ex) {
                ex.printStackTrace();
                JOptionPane.showMessageDialog(frame, "Read Error\n" + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        displayInvoices();
    }

    //done
    private InvoiceFrame searchInvoiceByNumber(int invoiceNumber) {
        InvoiceFrame head = null;
        for (InvoiceFrame invoiceFrame : frame.getInvoicesList()) {
            if (invoiceNumber == invoiceFrame.getInvNum()) {
                    head = invoiceFrame;
                break;
            }
        }
        return head;
    }

    @Override
    public void valueChanged(ListSelectionEvent e) {
        System.out.println("Invoice Selected!");
        invoicesTableRowSelected();
    }

    private void invoicesTableRowSelected() {
        int selectedRowIndex = frame.getInvoicesTable().getSelectedRow();
        if (selectedRowIndex >= 0) {
            InvoiceFrame row = frame.getInvoiceHeaderTableModel().getInvoicesLists().get(selectedRowIndex);
            frame.getCustNameTF().setText(row.getCustomerName());
            frame.getInvDateTF().setText(dateFormat.format(row.getInvDate()));
            frame.getInvNumLbl().setText("" + row.getInvNum());
            frame.getInvTotalLbl().setText("" + row.getTotalInvoice());
            ArrayList<InvoiceLine> lines = row.getLines();
            frame.setInvoiceLinesTableModel(new InvoiceLinesTableModel(lines));
            frame.getInvLinesTable().setModel(frame.getInvoiceLinesTableModel());
            frame.getInvoiceLinesTableModel().fireTableDataChanged();
        }
    }

    private void displayNewInvoiceDialog() {
        frame.setHeaderDialog(new InvoiceHeaderDialog(frame));
        frame.getHeaderDialog().setVisible(true);
    }

    private void displayNewLineDialog() {
        frame.setLineDialog(new InvoiceLineDialog(frame));
        frame.getLineDialog().setVisible(true);
    }

    private void createInvoiceCancel() {
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
    }

    private void createInvoiceOK() {
        String custName = frame.getHeaderDialog().getNameField().getText();
        String invDateStr = frame.getHeaderDialog().getInvoiceDateField().getText();
        frame.getHeaderDialog().setVisible(false);
        frame.getHeaderDialog().dispose();
        frame.setHeaderDialog(null);
        try {
            Date invDate = dateFormat.parse(invDateStr);
            int invNum = getNextInvoiceNum();
            InvoiceFrame invoiceHeader = new InvoiceFrame(invNum, custName, invDate);
            frame.getInvoicesList().add(invoiceHeader);
            frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        } catch (ParseException ex) {
            JOptionPane.showMessageDialog(frame, "Wrong date format", "Error", JOptionPane.ERROR_MESSAGE);
            ex.printStackTrace();
        }
        displayInvoices();
    }

    private int getNextInvoiceNum() {
        int max = 0;
        for (InvoiceFrame header : frame.getInvoicesList()) {
            if (header.getInvNum() > max) {
                max = header.getInvNum();
            }
        }
        return max + 1;
    }

    private void createLineCancel() {
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
    }

    private void createLineOK() {
        String itemName = frame.getLineDialog().getNameField().getText();
        String itemCountStr = frame.getLineDialog().getCountField().getText();
        String itemPriceStr = frame.getLineDialog().getPriceField().getText();
        frame.getLineDialog().setVisible(false);
        frame.getLineDialog().dispose();
        frame.setLineDialog(null);
        int itemCount = Integer.parseInt(itemCountStr);
        double itemPrice = Double.parseDouble(itemPriceStr);
        int headerIndex = frame.getInvoicesTable().getSelectedRow();
        InvoiceFrame invoice = frame.getInvoiceHeaderTableModel().getInvoicesLists().get(headerIndex);

        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, invoice);
        invoice.addNewCol(invoiceLine);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + invoice.getTotalInvoice());
        displayInvoices();
    }

    private void deleteInvoice() {
        int invIndex = frame.getInvoicesTable().getSelectedRow();
        InvoiceFrame header = frame.getInvoiceHeaderTableModel().getInvoicesLists().get(invIndex);
        frame.getInvoiceHeaderTableModel().getInvoicesLists().remove(invIndex);
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.setInvoiceLinesTableModel(new InvoiceLinesTableModel(new List<InvoiceLine>() {
            @Override
            public int size() {
                return 0;
            }

            @Override
            public boolean isEmpty() {
                return false;
            }

            @Override
            public boolean contains(Object o) {
                return false;
            }

            @Override
            public Iterator<InvoiceLine> iterator() {
                return null;
            }

            @Override
            public Object[] toArray() {
                return new Object[0];
            }

            @Override
            public <T> T[] toArray(T[] a) {
                return null;
            }

            @Override
            public boolean add(InvoiceLine invoiceLine) {
                return false;
            }

            @Override
            public boolean remove(Object o) {
                return false;
            }

            @Override
            public boolean containsAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean addAll(Collection<? extends InvoiceLine> c) {
                return false;
            }

            @Override
            public boolean addAll(int index, Collection<? extends InvoiceLine> c) {
                return false;
            }

            @Override
            public boolean removeAll(Collection<?> c) {
                return false;
            }

            @Override
            public boolean retainAll(Collection<?> c) {
                return false;
            }

            @Override
            public void clear() {

            }

            @Override
            public boolean equals(Object o) {
                return false;
            }

            @Override
            public int hashCode() {
                return 0;
            }

            @Override
            public InvoiceLine get(int index) {
                return null;
            }

            @Override
            public InvoiceLine set(int index, InvoiceLine element) {
                return null;
            }

            @Override
            public void add(int index, InvoiceLine element) {

            }

            @Override
            public InvoiceLine remove(int index) {
                return null;
            }

            @Override
            public int indexOf(Object o) {
                return 0;
            }

            @Override
            public int lastIndexOf(Object o) {
                return 0;
            }

            @Override
            public ListIterator<InvoiceLine> listIterator() {
                return null;
            }

            @Override
            public ListIterator<InvoiceLine> listIterator(int index) {
                return null;
            }

            @Override
            public List<InvoiceLine> subList(int fromIndex, int toIndex) {
                return null;
            }
        }));
        frame.getInvLinesTable().setModel(frame.getInvoiceLinesTableModel());
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getCustNameTF().setText("");
        frame.getInvDateTF().setText("");
        frame.getInvNumLbl().setText("");
        frame.getInvTotalLbl().setText("");
        displayInvoices();
    }

    private void deleteLine() {
        int lineIndex = frame.getInvLinesTable().getSelectedRow();
        InvoiceLine line = frame.getInvoiceLinesTableModel().getInvoiceTables().get(lineIndex);
        frame.getInvoiceLinesTableModel().getInvoiceTables().remove(lineIndex);
        frame.getInvoiceLinesTableModel().fireTableDataChanged();
        frame.getInvoiceHeaderTableModel().fireTableDataChanged();
        frame.getInvTotalLbl().setText("" + line.getHeader().getTotalInvoice());
        displayInvoices();
    }

    private void displayInvoices() {
        System.out.println("____________________________________________");
        for (InvoiceFrame header : frame.getInvoicesList()) {
            System.out.println(header);
        }
        System.out.println("_____________________________________________");
    }

}