/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student;

import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
import javax.swing.*;
import java.awt.*;
import java.sql.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author gs671
 */
public class UpdateDob extends JFrame implements ActionListener {

    Choice c1;
    JDateChooser date;
    JButton update, back;
    Connection con;

    UpdateDob() {
        setLayout(null);

        JLabel roll = new JLabel("Roll Number");
        roll.setBounds(100, 100, 100, 30);
        add(roll);

        c1 = new Choice();
        c1.setBounds(200, 110, 100, 20);
        add(c1);

        JLabel dob = new JLabel("DOB");
        dob.setBounds(100, 140, 100, 30);
        add(dob);

        date = new JDateChooser();
        date.setBounds(200, 150, 100, 20);
        add(date);

        fetchRollNo();

        update = new JButton("Update DOB");
        update.setBounds(10, 200, 150, 30);
        update.addActionListener(this);
        add(update);

        back = new JButton("BACK");
        back.setBounds(180, 200, 150, 30);
        back.addActionListener(this);
        add(back);

        setSize(400, 400);
        setLocationRelativeTo(null);
        setVisible(true);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void fetchRollNo() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql = "select rollno from student1";
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(sql);
            while (rs.next()) {
                c1.add(rs.getString("rollno"));
            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }

    }

    public void updateDob() {
        try {
            SimpleDateFormat s1 = new SimpleDateFormat("yyyy-MM-dd");
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql = "update student1 set dob=? where rollno=?";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, s1.format(date.getDate()));
            st.setString(2, c1.getSelectedItem());
            int i = st.executeUpdate();
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Date Of Birth Update.");
            } else {
                JOptionPane.showMessageDialog(this, "Operation not done.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == update) {
            updateDob();
        } else if (e.getSource() == back) {
            UpdateDetails up = new UpdateDetails();
            up.setVisible(true);
            this.dispose();
        }
    }

    public static void main(String args[]) {
        new UpdateDob();
    }
}
