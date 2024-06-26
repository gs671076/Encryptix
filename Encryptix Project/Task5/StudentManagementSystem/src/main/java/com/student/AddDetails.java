/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student;

import javax.swing.*;
import com.toedter.calendar.*;
import java.awt.*;
import java.sql.*;
import java.awt.event.*;
import java.text.SimpleDateFormat;

/**
 *
 * @author gs671
 */
public class AddDetails extends JFrame implements ActionListener{
    JComboBox combo1,combo2;
    JTextField txt_name,txt_roll,txt_fname,txt_add,txt_contact,txt_email,txt_aadhar;
    JButton b1,b2;
    JDateChooser date;
    AddDetails()
    {
    setLayout(null);
    
    JPanel p1=new JPanel();
    p1.setLayout(null);
    p1.setBounds(0, 0, 1300, 200);
    p1.setBackground(Color.blue);
    add(p1);
    
    JLabel heading=new JLabel("ADD STUDENT DETAILS");
    heading.setBounds(400,80,500,50);
    heading.setFont(new Font("TIMES NEW ROMAN",Font.BOLD,36));
    p1.add(heading);
    
    JLabel name=new JLabel("Name");
    name.setBounds(300, 220,200,20);
    add(name);
    
    JLabel rollNo=new JLabel("Roll Number");
    rollNo.setBounds(300, 250, 200, 20);
    add(rollNo);
    
    JLabel dob=new JLabel("Date of Birth");
    dob.setBounds(300, 280, 200, 20);
    add(dob);
    
    JLabel fname=new JLabel("Father Name");
    fname.setBounds(300,310, 200, 20);
    add(fname);
    
    JLabel address=new JLabel("Address");
    address.setBounds(300, 340, 200, 20);
    add(address);
    
    JLabel contact=new JLabel("Mobile No.");
    contact.setBounds(300,370, 200, 20);
    add(contact);
    
    JLabel email=new JLabel("Email");
    email.setBounds(300, 400, 200, 20);
    add(email);
    
    JLabel aadhar=new JLabel("Aadhar NO.");
    aadhar.setBounds(300, 430, 200, 20);
    add(aadhar);
    
    JLabel course=new JLabel("Course");
    course.setBounds(300, 460, 200, 20);
    add(course);
    
    JLabel branch=new JLabel("Branch");
    branch.setBounds(300, 490, 200, 20);
    add(branch);
    
    txt_name=new JTextField();
    txt_name.setBounds(400, 220, 200, 20);
    add(txt_name);
    
    txt_roll=new JTextField();
    txt_roll.setBounds(400, 250, 200, 20);
    add(txt_roll);
    
    date=new JDateChooser();
    date.setBounds(400, 280, 200, 20);
    add(date);
    
    txt_fname=new JTextField();
    txt_fname.setBounds(400, 310, 200, 20);
    add(txt_fname);
    
    txt_add=new JTextField();
    txt_add.setBounds(400, 340, 200, 20);
    add(txt_add);
    
    txt_contact=new JTextField();
    txt_contact.setBounds(400, 370, 200, 20);
    add(txt_contact);
    
    txt_email=new JTextField();
    txt_email.setBounds(400, 400, 200, 20);
    add(txt_email);
    
    txt_aadhar=new JTextField();
    txt_aadhar.setBounds(400, 430, 200, 20);
    add(txt_aadhar);
    
    combo1=new JComboBox();
    combo1.setBounds(400, 460, 200, 20);
    combo1.addActionListener(this);
    add(combo1);
    fetchData();
    
    combo2=new JComboBox();
    combo2.setBounds(400, 490, 200, 20);
    add(combo2);
    
    b1=new JButton("SUBMIT");
    b1.setBounds(700, 490, 100, 20);
    b1.addActionListener(this);
    add(b1);
    
    b2=new JButton("BACK");
    b2.setBounds(900, 490, 100, 20);
    b2.addActionListener(this);
    add(b2);
    
    ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("image/S1.jpeg"));
    JLabel image=new JLabel(img);
    image.setBounds(500,120,500,500);
    add(image);
    
    int r=fetchRollNO();
    r++;
    txt_roll.setText(Integer.toString(r));
    
    setSize(1300,800);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    
    public void fetchData()
    {
     try
     {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/student";
      Connection con=DriverManager.getConnection(url,"root","gaurav@123");
      String sql="select distinct courseName from department";
      Statement st=con.createStatement();
      ResultSet rs=st.executeQuery(sql);
      while(rs.next())
      {
      combo1.addItem(rs.getString("courseName"));
      }
     }
     catch(Exception e)
     {
     e.getStackTrace();
     }
    }
    
    public void setData()
    {
    try
     {
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/student";
      Connection con=DriverManager.getConnection(url,"root","gaurav@123");
      String sql="select distinct branch from department where courseName=?";
      PreparedStatement st=con.prepareStatement(sql);
      String item=combo1.getSelectedItem().toString();
      st.setString(1,item);
      ResultSet rs=st.executeQuery();
      combo2.removeAllItems();
      while(rs.next())
      {
      combo2.addItem(rs.getString("branch"));
      }
     }
     catch(Exception e)
     {
     e.getStackTrace();
     }
    }
    int fetchRollNO()
    {int roll=0;
    try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String url = "jdbc:mysql://localhost:3306/student";
            Connection con = DriverManager.getConnection(url, "root", "gaurav@123");
            String sql = "select max(rollno) from student1";
            PreparedStatement st = con.prepareStatement(sql);
            ResultSet rs=st.executeQuery(sql);
            if(rs.next()==true)
             roll=rs.getInt(1);
            
        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
       return roll;
    }
    public void insertData()
    {
         String name,fname,dob1,rollno,address,phone,email,course,branch,aadhar;
        name=txt_name.getText();
        fname=txt_fname.getText();
        rollno=txt_roll.getText();
        address=txt_add.getText();
        phone=txt_contact.getText();
        email=txt_email.getText();
        course=combo1.getSelectedItem().toString();
        branch=combo2.getSelectedItem().toString();
        aadhar=txt_aadhar.getText();
        SimpleDateFormat s1=new SimpleDateFormat("yyyy-MM-dd");
        dob1=s1.format(date.getDate());
        
     try{
      Class.forName("com.mysql.cj.jdbc.Driver");
      String url="jdbc:mysql://localhost:3306/student";
      Connection con=DriverManager.getConnection(url,"root","gaurav@123");
      String sql="insert into student1 values(?,?,?,?,?,?,?,?,?,?)";
      PreparedStatement st=con.prepareStatement(sql);
      st.setString(1,name);
      st.setString(2,fname);
      st.setString(3,rollno);
      st.setString(4,dob1);
      st.setString(5,address);
      st.setString(6,phone);
      st.setString(7,email);
      st.setString(8,course);
      st.setString(9,branch);
      st.setString(10,aadhar);
      int rs=st.executeUpdate();
     if(rs==1)
     {
     JOptionPane.showMessageDialog(this, "Records Inserted Successfuly.");
     }
     else
     {
     JOptionPane.showMessageDialog(this, "Operation Failed!..");
     }
     }
     catch(Exception e)
     {
     e.getStackTrace();
     JOptionPane.showMessageDialog(this, e);

     }
    }
    
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==combo1)
    { setData();}
    else if(e.getSource()==b1)
    {if (validateInputs())
    insertData();
    }
    else if(e.getSource()==b2)
    {
    StudentManagementSystem s1=new StudentManagementSystem();
    s1.setVisible(true);
    this.dispose();
    }
    }
    
    public boolean validateInputs() {
    if (txt_name.getText().isEmpty() || txt_fname.getText().isEmpty() || txt_roll.getText().isEmpty() ||
        txt_add.getText().isEmpty() || txt_contact.getText().isEmpty() || txt_email.getText().isEmpty() ||
        txt_aadhar.getText().isEmpty() || combo1.getSelectedItem() == null || combo2.getSelectedItem() == null ||
        date.getDate() == null) {
        JOptionPane.showMessageDialog(this, "Please fill all fields.", "Validation Error", JOptionPane.ERROR_MESSAGE);
        return false;
    }
    return true;
}

    public static void main(String args[])
    {
    new AddDetails();
    }
}
