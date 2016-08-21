/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.swingUI;

import com.leapfrog.swing.Program;
import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import sun.font.CreatedFontTracker;

/**
 *
 * @author Toshiba
 */
public class SwingUI extends JFrame {

    private JLabel lblFileName;
    private JTextArea txtShortText,txtopenShortText;
    private JButton btnSaveFile, btnCreateFile;
    private JTextField txtLongText;
    private JScrollPane scrollPane;
    
    public SwingUI() {
        setTitle("What Up");
        lblFileName=new JLabel("Enter File Name");
        add(lblFileName);
        lblFileName.setBounds(20,20, 100, 40);
        txtShortText=new JTextArea();
        add(txtShortText);
        txtShortText.setBounds(150, 25, 250, 25);
        txtLongText=new JTextField();
        add(txtLongText);
        txtLongText.setBounds(18,70, 550, 400);
        //scrollPane=new JScrollPane(txtShortText);
        
        btnCreateFile=new JButton("Create File");
        add(btnCreateFile);
        btnCreateFile.setBounds(420, 25, 150, 25);
         btnCreateFile.addActionListener(new EventButton());
        btnSaveFile=new JButton("Open File");
        add(btnSaveFile);
        btnSaveFile.setBounds(420, 480, 150, 25);
         btnSaveFile.addActionListener(new EventButton());
        txtopenShortText = new JTextArea();
        add(txtopenShortText);
        txtopenShortText.setBounds(150, 480, 250, 25);
        lblFileName=new JLabel("Enter File Name");
        add(lblFileName);
        lblFileName.setBounds(20,480, 100, 25);
        
       
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 200, 600, 600);
        setLayout(null);
        setVisible(true);
     }
    
    
private class EventButton implements ActionListener{

        @Override
        public void actionPerformed(ActionEvent e) {
            String command=e.getActionCommand();
            if (command.equals("Create File")) {
                 try {
                String shortText = txtShortText.getText();
                FileWriter writer = new FileWriter(shortText);
                writer.write(txtLongText.getText());
                writer.close();
                txtLongText.setText("");
                txtShortText.setText("");
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, ioe.getMessage());
            }
                
            }
        
        if(command.equals("Open File")){
            try {
                BufferedReader reader = new BufferedReader(new FileReader(txtopenShortText.getText()));
                String line = "";
                StringBuilder content = new StringBuilder();
                while ((line = reader.readLine()) != null) {
                    content.append(line).append("\r\n");
                    
                }
                reader.close();
                txtLongText.setText(content.toString());
                
            } catch (IOException ioe) {
                JOptionPane.showMessageDialog(null, ioe.getMessage());
            }
        
        }
        
        }
    
}
}
