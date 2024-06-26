/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.student;
import java.awt.*;
import javax.swing.*;
import java .awt.event.*;

/**
 *
 * @author gs671
 */
public class StudentManagementSystem extends JFrame implements ActionListener {
    JButton add,view,search,update;
    StudentManagementSystem()
    {
    setLayout(null);
    ImageIcon img=new ImageIcon(ClassLoader.getSystemResource("image/first.jpg"));
    Image img2 = img.getImage().getScaledInstance(1600,800, Image.SCALE_DEFAULT);
    ImageIcon img3=new ImageIcon(img2);
    JLabel image=new JLabel(img3);
    image.setBounds(0,0,1600,800);
    add(image);
    
    JLabel heading=new JLabel("Welcome To Student Management System");
    heading.setBounds(400,20,600,40);
    heading.setForeground(Color.red);
    heading.setFont(new Font("RALEWAY",Font.BOLD,25));
    image.add(heading);
    
    add=new JButton("Add Details");
    add.setBounds(400,100,200,40);
    add.addActionListener(this);
    image.add(add);
    
    view=new JButton("View Details");
    view.setBounds(700,100,200,40);
    view.addActionListener(this);
    image.add(view);
    
    search=new JButton("Search Records");
    search.setBounds(400,200,200,40);
    search.addActionListener(this);
    image.add(search);
    
    update=new JButton("Update Details");
    update.setBounds(700,200,200,40);
    update.addActionListener(this);
    image.add(update);
    

    setSize(1600,800);
    setVisible(true);
    setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public void actionPerformed(ActionEvent e)
    {
    if(e.getSource()==add)
    {
    AddDetails a1=new AddDetails();
    a1.setVisible(true);
    this.dispose();
    }
    else if(e.getSource()==view)
    {
    ViewRecord v1=new ViewRecord();
    v1.setVisible(true);
    this.dispose();
    }
    else if(e.getSource()==search)
    {
      SearchDetails sd=new SearchDetails("Search");
      sd.setVisible(true);
      this.dispose();
    }
    else if(e.getSource()==update)
    {
     UpdateDetails d1=new UpdateDetails();
     d1.setVisible(true);
     this.dispose();
    }
    }
    public static void main(String args[])
    {
     new StudentManagementSystem();
    }
}
