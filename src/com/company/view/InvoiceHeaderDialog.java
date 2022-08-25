package com.company.view;

import com.company.MainFrame;

import java.awt.GridLayout;
import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class InvoiceHeaderDialog extends JDialog {

    private JTextField nameField;
    private JLabel nameLabel;

    private JTextField invoiceDateField;
    private JLabel invoiceDateLabel;

    private JButton okBTN;
    private JButton cancelBTN;

    public InvoiceHeaderDialog(MainFrame frame){
        nameLabel = new JLabel("Customer Name:");
        nameField = new JTextField(20);
        invoiceDateLabel = new JLabel("Invoice Date:");
        invoiceDateField = new JTextField(20);
        okBTN = new JButton("OK");
        cancelBTN = new JButton("Cancel");

        okBTN.setActionCommand("createInvOK");
        cancelBTN.setActionCommand("createInvCancel");
        okBTN.addActionListener(frame.getListener());
        cancelBTN.addActionListener(frame.getListener());
        setLayout(new GridLayout(3, 2));

        add(invoiceDateLabel);
        add(invoiceDateField);
        add(nameLabel);
        add(nameField);
        add(okBTN);
        add(cancelBTN);

        pack();

    }


    public JTextField getNameField() {
        return nameField;
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JTextField getInvoiceDateField() {
        return invoiceDateField;
    }

    public JLabel getInvoiceDateLabel() {
        return invoiceDateLabel;
    }

    public JButton getOkBTN() {
        return okBTN;
    }

    public JButton getCancelBTN() {
        return cancelBTN;
    }





}
