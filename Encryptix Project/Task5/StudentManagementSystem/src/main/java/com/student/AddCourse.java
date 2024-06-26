/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.sql.*;
import javax.swing.*;

/**
 *
 * @author gs671
 */
public class AddCourse extends JFrame implements ActionListener {

    JTextField branch, course;
    JButton submit, back;

    AddCourse() {
        setLayout(null);
        JLabel heading = new JLabel("Add Course");
        heading.setBounds(100, 50, 200, 30);
        heading.setForeground(Color.red);
        heading.setFont(new Font("RALEWAY", Font.BOLD, 25));
        add(heading);

        JLabel courselbl = new JLabel("Course");
        courselbl.setBounds(100, 100, 50, 30);
        add(courselbl);

        JLabel branchlbl = new JLabel("Branch");
        branchlbl.setBounds(100, 150, 50, 30);
        add(branchlbl);

        course= new JTextField();
        course.setBounds(150, 110, 100, 20);
        add(course);

        branch = new JTextField();
        branch.setBounds(150, 160, 100, 20);
        add(branch);

        submit = new JButton("ADD COURSE");
        submit.setBounds(10, 200, 150, 30);
        submit.addActionListener(this);
        add(submit);

        back = new JButton("BACK");
        back.setBounds(180, 200, 150, 30);
        back.addActionListener(this);
        add(back);

        setVisible(true);
        setSize(400, 400);

        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }

    void addDetails() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql = "insert into department values(?,?)";
            PreparedStatement st = con.prepareStatement(sql);
            st.setString(1, course.getText());
            st.setString(2, branch.getText());
            int i=0;
            if(course.getText()!=""&&branch.getText()=="")
            {
             i = st.executeUpdate();
            }
            else
            {
            JOptionPane.showMessageDialog(this, "Please Insert branch and Course.");

            }
            if (i > 0) {
                JOptionPane.showMessageDialog(this, "Record Added Succesfully.");
            } else {
                JOptionPane.showMessageDialog(this, "Record not Added Succesfully.");

            }
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submit) {
            addDetails();
        } else if (e.getSource() == back) {
            UpdateDetails up = new UpdateDetails();
            up.setVisible(true);
            this.dispose();
        }

    }

    public static void main(String args[]) {
        new AddCourse();
    }
}
