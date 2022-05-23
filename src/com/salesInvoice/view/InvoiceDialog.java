package com.salesInvoice.view;

import javax.swing.*;
import java.awt.*;

public class InvoiceDialog extends JDialog {
    private JTextField customerName;
    private JTextField invoiceDate;
    private JLabel customerNameLabel;
    private JLabel invoiceDateLabel;
    private JButton okButton;
    private JButton cancelButton;

    public InvoiceDialog(InvoiceForm form){
        customerNameLabel = new JLabel("Customer Name: ");
        customerName = new JTextField(20);
        invoiceDateLabel = new JLabel("Date: ");
        invoiceDate = new JTextField(20);
        okButton = new JButton("Ok");
        cancelButton = new JButton("Cancel");
//        Action Command
        okButton.setActionCommand("Add New Invoice Ok");
        cancelButton.setActionCommand("Add New Invoice Cancel");

//       Add Action Listener to Buttons

        okButton.addActionListener(form.getController());
        cancelButton.addActionListener(form.getController());

//        Draw Layout
        setLayout(new GridLayout(3,2));
        add(invoiceDateLabel);
        add(invoiceDate);
        add(customerNameLabel);
        add(customerName);
        add(okButton);
        add(cancelButton);

        pack();

    }

    public JTextField getCustomerName() {
        return customerName;
    }

    public JTextField getInvoiceDate() {
        return invoiceDate;
    }
}
