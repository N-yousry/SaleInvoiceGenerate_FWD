package com.company;


import com.company.control.SaleGeneratorListener;
import com.company.model.InvoiceFrame;
import com.company.model.InvoiceHeaderTableModel;
import com.company.model.InvoiceLine;
import com.company.model.InvoiceLinesTableModel;
import com.company.view.InvoiceHeaderDialog;
import com.company.view.InvoiceLineDialog;

import javax.swing.*;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class MainFrame  extends javax.swing.JFrame implements ActionListener, ListSelectionListener {

    private MainFrame(int invoiceNumberMain, String customerNameMain, Date invoiceDateMain) {
        //this exception to change the body of the generated methods.
        throw new UnsupportedOperationException("Not supported yet.");
    }
    public MainFrame() {
        mainComp();
    }

    public static void main(String[] args) {
        // write your code here
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                MainFrame mainframe = new MainFrame();
                mainframe.setVisible(true);
            }
        });
    }
    /*** MAIN COMPANENT FUNCTIONN**/
    private void mainComp() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jScrollPane2 = new javax.swing.JScrollPane();

        invLinesTable = new javax.swing.JTable();
        invLinesTable.getSelectionModel().addListSelectionListener(this);

        createInvBtn = new javax.swing.JButton();
        createInvBtn.addActionListener(this);
        createInvBtn = new javax.swing.JButton();
        deleteInvBtn.addActionListener(this);

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        invNumLbl = new javax.swing.JLabel();

        custNameTF = new javax.swing.JTextField();
        invDateTF = new javax.swing.JTextField();
        invTotalLbl = new javax.swing.JLabel();

        invLinesTable = new javax.swing.JTable();

        createLineBtn = new javax.swing.JButton();
        createLineBtn.addActionListener(this);

        deleteLineBtn = new javax.swing.JButton();
        deleteLineBtn.addActionListener(this);

        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();

        loadMenuItem = new javax.swing.JMenuItem();
        loadMenuItem.addActionListener(this);

        saveMenuItem = new javax.swing.JMenuItem();
        saveMenuItem.addActionListener(this);

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        invoicesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}
        ));

        jScrollPane1.setViewportView(invoicesTable);
        invoicesTable.getAccessibleContext().setAccessibleName("");

        // Setting "Create new Invoice btn"
        createInvBtn.setText("Create New Invoice");
        createInvBtn.setActionCommand("Create New Invoice");
        createInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createInvoiceBtnActionPerformed(evt);
            }
        });

        // Setting "delete  Invoice btn"
        deleteInvBtn.setText("Create New Invoice");
        deleteInvBtn.setActionCommand("Create New Invoice");
        deleteInvBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteInvoiceBtnActionPerformed(evt);
            }
        });
        //main labels
        jLabel1.setText("Invoice Number");

        jLabel2.setText("Invoice Date");

        jLabel3.setText("Customer Name");

        jLabel4.setText("Invoice Total");

        custNameTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                customerNameActionPerformed(evt);
            }
        });

        invDateTF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                invoiceDateActionPerformed(evt);
            }
        });

        invLinesTable.setModel(new javax.swing.table.DefaultTableModel(
                new Object[][]{},
                new String[]{}));
        jScrollPane2.setViewportView(invoicesTable);

        createLineBtn.setText("Create New Line");
        createLineBtn.setActionCommand("Create New Line");
        createLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                createLineBtnActionPerformed(evt);
            }
        });

        deleteLineBtn.setText("Delete Line");
        deleteLineBtn.setActionCommand("Delete Line");
        deleteLineBtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                deleteLineBtnActionPerformed(evt);
            }
        });


        jMenu1.setText("File");

        loadMenuItem.setText("Load File");
        loadMenuItem.setActionCommand("LoadFile");
        jMenu1.add(loadMenuItem);

        saveMenuItem.setText("Save File");
        saveMenuItem.setActionCommand("SaveFile");
        jMenu1.add(saveMenuItem);

        jMenuBar1.add(jMenu1);

        setJMenuBar(jMenuBar1);
        // THE LAYOUTTTTTTTTTTTTTTTT
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        // HORIZONTALLLL
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 415, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(46, 46, 46)
                                                .addComponent(createInvBtn)
                                                .addGap(68, 68, 68)
                                                .addComponent(deleteInvBtn)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 85, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(invNumLbl))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabel2)
                                                                        .addComponent(jLabel4))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(invTotalLbl)
                                                                        .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jLabel3)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, 242, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(72, 72, 72)
                                                .addComponent(createLineBtn)
                                                .addGap(98, 98, 98)
                                                .addComponent(deleteLineBtn)))
                                .addContainerGap())
        );
        // VERTICALLLLLLLLL
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(invNumLbl)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGap(25, 25, 25)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel2)
                                                        .addComponent(invDateTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGap(7, 7, 7)
                                                                .addComponent(jLabel3))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                                .addComponent(custNameTF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                                .addGap(26, 26, 26)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabel4)
                                                        .addComponent(invTotalLbl))
                                                .addGap(18, 18, 18)
                                                .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(createLineBtn)
                                                        .addComponent(deleteLineBtn)))
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(createInvBtn)
                                        .addComponent(deleteInvBtn))
                                .addGap(104, 104, 104))
        );

        pack();
    }

    //method for deleting the line btn
    private void deleteLineBtnActionPerformed(ActionEvent evt) {
    }
    //method for creating the line btn
    private void createLineBtnActionPerformed(ActionEvent evt) {
    }
    //method for creating the invoice date
    private void invoiceDateActionPerformed(ActionEvent evt) {
    }
    // Method for creating customer name
    private void customerNameActionPerformed(ActionEvent evt) {
    }
    // Method for deleting invoice btn
    private void deleteInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }
    // Method for creating invoice btn
    private void createInvoiceBtnActionPerformed(java.awt.event.ActionEvent evt) {
    }

    // Variable Declaration
    private javax.swing.JButton createInvBtn;
    private javax.swing.JButton createLineBtn;
    private javax.swing.JTextField custNameTF;
    private javax.swing.JButton deleteInvBtn;
    private javax.swing.JButton deleteLineBtn;
    private javax.swing.JTextField invDateTF;

    private javax.swing.JTable invLinesTable;
    private javax.swing.JLabel invNumLbl;
    private javax.swing.JLabel invTotalLbl;
    private javax.swing.JTable invoicesTable;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JMenuItem loadMenuItem;
    private javax.swing.JMenuItem saveMenuItem;

    /*** END OF VARIABLE DECELEATION**/


    private DateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy");
    private List<InvoiceFrame> invoicesList = new ArrayList<>();
    private InvoiceLineDialog lineD;
    private InvoiceHeaderDialog HeaderD;
    private InvoiceHeaderTableModel invoiceHeaderTableModel;
    private InvoiceLinesTableModel invoiceLinesTableModel;
    private SaleGeneratorListener listener = new SaleGeneratorListener(this);


    public SaleGeneratorListener getListener() {
        return listener;
    }

    public void setHeaderDialog(InvoiceHeaderDialog headerDialog) {
        this.HeaderD = headerDialog;
    }

    public void setLineDialog(InvoiceLineDialog lineDialog) {
        this.lineD = lineDialog;
    }

    public void setInvoiceHeaderTableModel(InvoiceHeaderTableModel invoiceHeaderTableModel) {
        this.invoiceHeaderTableModel = invoiceHeaderTableModel;
    }

    public void setInvoiceLinesTableModel(InvoiceLinesTableModel invoiceLinesTableModel) {
        this.invoiceLinesTableModel = invoiceLinesTableModel;
    }


    /*************GEETTTTEEERS****************/
    public JButton getCreateInvBtn() {
        return createInvBtn;
    }

    public JButton getCreateLineBtn() {
        return createLineBtn;
    }

    public JTextField getCustNameTF() {
        return custNameTF;
    }

    public JButton getDeleteInvBtn() {
        return deleteInvBtn;
    }

    public JButton getDeleteLineBtn() {
        return deleteLineBtn;
    }

    public JTextField getInvDateTF() {
        return invDateTF;
    }

    public JTable getInvLinesTable() {
        return invLinesTable;
    }

    public JLabel getInvNumLbl() {
        return invNumLbl;
    }

    public JLabel getInvTotalLbl() {
        return invTotalLbl;
    }

    public JTable getInvoicesTable() {
        return invoicesTable;
    }

    public JMenuItem getLoadMenuItem() {
        return loadMenuItem;
    }

    public JMenuItem getSaveMenuItem() {
        return saveMenuItem;
    }

    public List<InvoiceFrame> getInvoicesList() {
        return invoicesList;
    }

    public InvoiceHeaderTableModel getInvoiceHeaderTableModel() {
        return invoiceHeaderTableModel;
    }

    public InvoiceLinesTableModel getInvoiceLinesTableModel() {
        return invoiceLinesTableModel;
    }

    public InvoiceHeaderDialog getHeaderDialog() {
        return HeaderD;
    }

    public InvoiceLineDialog getLineDialog() {
        return lineD;
    }
    public JLabel getjLabel1() {
        return jLabel1;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public JLabel getjLabel3() {
        return jLabel3;
    }

    public JLabel getjLabel4() {
        return jLabel4;
    }

    public JMenu getjMenu1() {
        return jMenu1;
    }

    public JMenuBar getjMenuBar1() {
        return jMenuBar1;
    }

    public JScrollPane getjScrollPane1() {
        return jScrollPane1;
    }

    public JScrollPane getjScrollPane2() {
        return jScrollPane2;
    }

    public DateFormat getDateFormat() {
        return dateFormat;
    }





    /*
    public void actionPerformed(ActionEvent e) {
        switch (e.getActionCommand()) {
            case "CreateNewInvoice":
                //done
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
                //load is done
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

    //donee
    private void displayNewColDialog() {
        lineD = new InvoiceLineDialog(this);
        lineD.setVisible(true);
    }

    // finished the savings
    private void saveData() {
        String maidenhead = "";
        String rows= "";
        for(InvoiceFrame header : invoicesList){
            maidenhead+= header.getCSV();
            maidenhead += "\n";
            for(InvoiceLine table : header.getLines()) {
                rows += table.getCSV();
                rows += "\n";
            }
        }
        JOptionPane.showMessageDialog(this, "Please,Select File to save data!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser fileChooser = new JFileChooser();
        int result = fileChooser.showSaveDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = fileChooser.getSelectedFile();
            try {
                FileWriter hFW = new FileWriter(headerFile);
                hFW.write(maidenhead);
                hFW.flush();
                hFW.close();

                JOptionPane.showMessageDialog(this, "Please, Select the file to save the data!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = fileChooser.showSaveDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = fileChooser.getSelectedFile();
                    FileWriter lFW = new FileWriter(linesFile);
                    lFW.write(rows);
                    lFW.flush();
                    lFW.close();
                }
                JOptionPane.showMessageDialog(null, "File Saved Successfully ! ");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, "Error: " + ex.getMessage(), "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
    }*/

    /******* to remove invoice by making it invisble***
    private void createCancelChanges() {
        HeaderD.setVisible(false);
        HeaderD.dispose();
        HeaderD =null;
    }***/

    /*** create ButtonOK
    private void createInvoiceOKBtn() {
        String customerName = HeaderD.getNameField().getText();
        String invDateStr = HeaderD.getInvoiceDateField().getText();
        HeaderD.setVisible(false);
        HeaderD.dispose();
        HeaderD = null;
        try {
            Date invoiceDate = dateFormat.parse(invDateStr);
            int invoice_number = getTheFollowingInvNb();
            InvoiceFrame invoiceFrame = new InvoiceFrame(invoice_number, customerName, invoiceDate);
            invoicesList.add(invoiceFrame);
            InvoiceHeaderTableModel.fireTableDataChanged();
        } catch(ParseException ex) {
            ex.printStackTrace();
            displayInvoices();
        }
    } done**/


    /******done
    private int getTheFollowingInvNb() {
        int max=0;
        for(InvoiceFrame header : invoicesList){
            if (header.getInvNum()> max){
                max= header.getInvNum();
            }
        }
        return max+1;
    }***/


    private void createRowCancel() {
    }

    private void createOK() {
    }

    /*****did the load file function***
    private void LoadFile() {
        JOptionPane.showMessageDialog(this, "Please, Select the Header File!", "Attention", JOptionPane.WARNING_MESSAGE);
        JFileChooser openFile = new JFileChooser();
        int result = openFile.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION) {
            File headerFile = openFile.getSelectedFile();
            try{
                FileReader headerFr = new FileReader(headerFile);
                BufferedReader headerBr = new BufferedReader (headerFr);
                String headerLine = null;

                while (( headerLine = headerBr.readLine()) != null) {
                    String[] headerParts = headerLine.split(",");
                    String invoiceNbString = headerParts[0];
                    String invoiceDateString = headerParts[1];
                    String name = headerParts[2];

                    int invoiceNb = Integer.parseInt(invoiceNbString);
                    Date invoiceDate = dateFormat.parse(invoiceDateString);

                    InvoiceFrame invoice = new InvoiceFrame(invoiceNb, name, invoiceDate);
                    invoicesList.add(invoice);

                }

                JOptionPane.showMessageDialog(this, "Please, Select the Header File!", "Attention", JOptionPane.WARNING_MESSAGE);
                result = openFile.showOpenDialog(this);
                if (result == JFileChooser.APPROVE_OPTION) {
                    File linesFile = openFile.getSelectedFile();
                    BufferedReader linesBr= new BufferedReader(new FileReader(linesFile));
                    String linesLine = null;
                    while ((linesLine = linesBr.readLine()) !=null) {
                        String[] lineParts = linesLine.split(",");
                        String invoiceNbString = lineParts[0];
                        String itemName = lineParts[1];
                        String itemPriceStr = lineParts[2];
                        String itemCountStr = lineParts[3];
                        int invoiceNum = Integer.parseInt(invoiceNbString);
                        double itemPrice = Double.parseDouble(itemPriceStr);
                        int itemCount = Integer.parseInt(itemCountStr);
                        InvoiceFrame header = searchInvoiceByNumber(invoiceNum);
                        InvoiceLine invoiceLine = new InvoiceLine(itemName, itemPrice, itemCount, header);
                        header.getLines().add(invoiceLine);
                    }
                    InvoiceHeaderTableModel = new InvoiceHeaderTableModel(invoicesList);
                    invoiceTable.setModel(InvoiceHeaderTableModel);
                    invoiceTable.validate();
                }
            } catch (Exception ex){
                ex.printStackTrace();
            }
        }
        displayInvoices();
    }
*/

    private void displayInvoices() {
    }

    private void deleteRow() {
    }

    private void deleteCreatedInvoice() {
    }

    //DONE
    private void displayNewInvoice() {
        HeaderD = new InvoiceHeaderDialog(this);
        HeaderD.setVisible(true);
    }

    /***invoice frame function
    private InvoiceFrame searchInvoiceByNumber(int invoiceNb) {
        InvoiceFrame h = null;
        for (InvoiceFrame invoice : invoicesList) {
            if (invoiceNb == invoice.getInvNum()) {
                h = invoice;
                break;
            }
        }
        return h;
    }***/
    @Override
    public void valueChanged(ListSelectionEvent e) {

    }


    @Override
    public void actionPerformed(ActionEvent e) {

    }
}
