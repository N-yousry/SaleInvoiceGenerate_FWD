package com.company.view;

import com.company.MainFrame;
import javax.swing.*;
import java.awt.*;

public class InvoiceLineDialog extends JDialog {


    // decelearation of varaliables
    private JTextField nameField;
    private JTextField countField;
    private JTextField priceField;

    private JLabel nameLabel;
    private JLabel countLabel;
    private JLabel priceLabel;

    private JButton okBTN;
    private JButton cancelBTN;

    public InvoiceLineDialog(MainFrame frame) {
        nameField = new JTextField(20);
        nameLabel = new JLabel("Item Name");

        priceField = new JTextField(20);
        priceLabel = new JLabel("Item Price");

        okBTN = new JButton("OK");
        cancelBTN = new JButton("Cancel");

        okBTN.setActionCommand("createLineOK");
        cancelBTN.setActionCommand("createLineCancel");

        okBTN.addActionListener(frame.getListener());
        cancelBTN.addActionListener(frame.getListener());
        setLayout(new GridLayout(4, 2));

        add(nameLabel);
        add(nameField);
        add(countLabel);
        add(countField);
        add(priceLabel);
        add(priceField);
        add(okBTN);
        add(cancelBTN);

        pack();
    }



    public JTextField getCountField() {
        return countField;
    }
    public JTextField getPriceField() {
        return priceField;
    }
    public JTextField getNameField() {
        return nameField;
    }


}