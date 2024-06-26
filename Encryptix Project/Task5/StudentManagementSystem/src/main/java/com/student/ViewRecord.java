/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student;

import javax.swing.*;
import java.awt.event.*;
import java.sql.*;
import net.proteanit.sql.*;

/**
 *
 * @author gs671
 */
public class ViewRecord extends JFrame implements ActionListener {

    JMenuItem view, back, home,view2;
    JTable table;
    JScrollPane jsp;

    ViewRecord() {
        setLayout(null);
        setVisible(true);
        JMenuBar j1 = new JMenuBar();
        setJMenuBar(j1);

        home = new JMenuItem("Home");
        home.addActionListener(this);
        j1.add(home);

        view = new JMenuItem("View Records");
        view.addActionListener(this);
        j1.add(view);
        
        view2 = new JMenuItem("View Course");
        view2.addActionListener(this);
        j1.add(view2);

        back = new JMenuItem("Back");
        back.addActionListener(this);
        j1.add(back);
        
        table=new JTable();
        jsp=new JScrollPane(table);
        jsp.setBounds(1, 100, 1250, 500);
        add(jsp);

        setSize(1300, 800);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    public void fetchRecord() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/student";
        Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
        String sql = "select * from student1";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e);
        }
    }
    public void fetchRecord1() {
        try{
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/student";
        Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
        String sql = "select * from department";
        Statement st=con.createStatement();
        ResultSet rs=st.executeQuery(sql);
        table.setModel(DbUtils.resultSetToTableModel(rs));
        }
        catch(Exception e)
        {
        JOptionPane.showMessageDialog(this, e);
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == home) {
            StudentManagementSystem s1 = new StudentManagementSystem();
            s1.setVisible(true);
            this.dispose();
        }
        if (e.getSource() == view) {
           fetchRecord();
        }
        if (e.getSource() == view2) {
           fetchRecord1();
        }
        if (e.getSource() == back) {
            StudentManagementSystem s1 = new StudentManagementSystem();
            s1.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String args[]) {
        new ViewRecord();
    }
}
