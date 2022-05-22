/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.salesInvoice.control;

import com.salesInvoice.model.Invoice;
import com.salesInvoice.model.InvoiceTableModel;
import com.salesInvoice.model.Item;
import com.salesInvoice.model.ItemsTableModel;
import com.salesInvoice.view.InvoiceForm;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author moham
 */
public class Controller implements ActionListener {

    private InvoiceForm form;

    public Controller(InvoiceForm form){
        this.form = form;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        String actionCommand = e.getActionCommand();
        System.out.println("Action Command is: " + actionCommand);
        switch (actionCommand){
            case"Load File" ->loadFile();
            case"Save File"-> saveFile();
            case "Add New Invoice"->createNewInvoice();
            case "Delete Invoice"->deleteInvoice();
            case"Add New Item"-> addNewItem();
            case "Delete Item"-> deleteItem();
        }
    }

//Add CSV Files
    private void loadFile(){
        JFileChooser fileChooser = new JFileChooser();
        try {
            int result =fileChooser.showOpenDialog(form);
            if(result == JFileChooser.APPROVE_OPTION){
                File fileHeader = fileChooser.getSelectedFile();
                Path headerPath =  Paths.get(fileHeader.getAbsolutePath());
                List<String> headerLines = Files.readAllLines(headerPath);
                System.out.println("Invoices have been read");

                ArrayList<Invoice> invoicesArray = new ArrayList<>();
                ArrayList<Item> itemsArray = new ArrayList<>();
                for (String headerLine :headerLines){
                    String[] headerParts =  headerLine.split(",");
                    int id = Integer.parseInt(headerParts[0]);
                    String invoiceDate  = headerParts[1];
                    String customerName  = headerParts[2];
                    Invoice invoice = new Invoice(id, invoiceDate, customerName);

                    invoicesArray.add(invoice);
                }
                System.out.println(invoicesArray);
                System.out.println("After Adding Invoices");

                result = fileChooser.showOpenDialog(form);
                if(result == JFileChooser.APPROVE_OPTION){
                    File itemFile = fileChooser.getSelectedFile();
                    Path itemPath = Paths.get(itemFile.getAbsolutePath());
                    List<String> itemItems = Files.readAllLines(itemPath);
                    System.out.println("Items have been read");

                    for (String itemItem :itemItems){
                        String[] itemParts =  itemItem.split(",");
                        int id = Integer.parseInt(itemParts[0]);
                        String itemName  = itemParts[1];
                        double itemPrice  = Double.parseDouble(itemParts[2]);
                        int count = Integer.parseInt(itemParts[3]);
                        Invoice inv = null;
                        for (Invoice invoice:invoicesArray){
                            if(invoice.getId()==id){
                                inv = invoice;
                                break;
                            }
                        }

                        Item item  = new Item(itemName,itemPrice, count,inv);


                        inv.getItems().add(item);
                        System.out.println(item);
                    }
                }
                form.setInvoices(invoicesArray);
                InvoiceTableModel invoiceTableModel = new InvoiceTableModel(invoicesArray);

                form.setInvoiceTableModel(invoiceTableModel);
                form.getInvoiceTable().setModel(invoiceTableModel);
                form.getInvoiceTableModel().fireTableDataChanged();
}

        }
        catch (Exception e){
            e.printStackTrace();
        }
    }

//Save CSV Files
    private void saveFile(){
        try {

        }
        catch (Exception e){

        }
    }

//Create New Invoice Method
    private void createNewInvoice(){}

//    Delete Invoice Method
    private void deleteInvoice(){}

//    Add New Item Method
    private void addNewItem(){}

//    Delete Item Method
    private void deleteItem(){}


}
