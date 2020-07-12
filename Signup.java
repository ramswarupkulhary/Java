/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open t
he template in the editor.
 */
package atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.Random;

/**
 *
 * @author kulha
 */
public class Signup extends JFrame implements ActionListener{
    
    JLabel l1, l2, l3, l4, l5, l6, l7, l8, l9, l10, l11, l12, l13, l14, l15;
    JTextField tf1, tf2, tf3, tf4, tf5, tf6, tf7;
    JRadioButton jr1, jr2, jr3, jr4;
    JComboBox jc1, jc2, jc3;
    JButton next;
    Random ran = new Random();
    long formNumber = Math.abs((ran.nextLong() % 9000L) + 1000L);
    Signup(){
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("NEW ACCOUNT APPLICATION FORM");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s",pad);
        setTitle(pad+"NEW ACCOUNT APPLICATION FORM");
        
        l1 = new JLabel("APPLICATION FORM NO. " + formNumber);
        l1.setFont(new Font("Raleway", Font.BOLD, 38));
        
        
        l2 = new JLabel("Page 1: Personal Details");
        l2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        
        l3 = new JLabel("Name");
        l3.setFont(new Font("Raleway", Font.BOLD, 20));
        
        
        l4 = new JLabel("Father's Name");
        l4.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l5 = new JLabel("Date Of Birth");
        l5.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l6 = new JLabel("Gender");
        l6.setFont(new Font("Raleway", Font.BOLD, 22));
        
        
        l7 = new JLabel("Email-Address");
        l7.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l8 = new JLabel("Marital Status");
        l8.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l9 = new JLabel("Address");
        l9.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l10 = new JLabel("City");
        l10.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l11 = new JLabel("Pin Code");
        l11.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l12 = new JLabel("State");
        l12.setFont(new Font("Raleway", Font.BOLD, 22));
        
        l13 = new JLabel("Date");
        l13.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l14 = new JLabel("Month");
        l14.setFont(new Font("Raleway", Font.BOLD, 14));
        
        l15 = new JLabel("Year");
        l15.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        tf1 = new JTextField();
        tf1.setFont(new Font("Raleway",Font.ITALIC, 22));
        
        tf2 = new JTextField();
        tf2.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        tf3 = new JTextField();
        tf3.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        tf4 = new JTextField();
        tf4.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        tf5 = new JTextField();
        tf5.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        tf6 = new JTextField();
        tf6.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        tf7 = new JTextField();
        tf7.setFont(new Font("Raleway", Font.ITALIC, 22));
        
        
        
        jr1 = new JRadioButton("Male");
        jr1.setFont(new Font("Raleway", Font.BOLD, 14));
        jr1.setBackground(Color.WHITE);
        jr1.setForeground(Color.BLACK);
        
        jr2 = new JRadioButton("Female");
        jr2.setFont(new Font("Raleway", Font.BOLD, 14));
        jr2.setBackground(Color.WHITE);
        jr2.setForeground(Color.BLACK);
        
        jr3 = new JRadioButton("Married");
        jr3.setFont(new Font("Raleway", Font.BOLD, 14));
        jr3.setBackground(Color.WHITE);
        jr3.setForeground(Color.BLACK);
        
        jr4 = new JRadioButton("UnMarried");
        jr4.setFont(new Font("Raleway", Font.BOLD, 14));
        jr4.setBackground(Color.WHITE);
        jr4.setForeground(Color.BLACK);
        
        next = new JButton("NEXT");
        next.setFont(new Font("Raleway", Font.BOLD, 14));
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        
        String date[] = {"1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"};
        jc1 = new JComboBox(date);
        jc1.setBackground(Color.WHITE);
        jc1.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String month[] = {"January","February","March","April","May","June","July","August","September","October","November","December"};
        jc2 = new JComboBox(month);
        jc2.setBackground(Color.WHITE);
        jc2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        String year[] = {"1990","1991","1992","1993","1994","1995","1996","1997","1998","1999","2000","2001","2002","2003","2004","2005","2006","2007","2008","2009","2010","2011","2012","2013","2014","2015","2016","2017","2018","2019","2020"};
        jc3 = new JComboBox(year);
        jc3.setBackground(Color.WHITE);
        jc3.setFont(new Font("Raleway", Font.BOLD, 14));
        
        
        
        
        
        
        
        
        setLayout(null);
        
        l1.setBounds(140,20,600,40);
        add(l1);
        l2.setBounds(290,70,600,30);
        add(l2);
        
        l3.setBounds(100,140,100,30);
        add(l3);
        
        tf1.setBounds(300,140,400,30);
        add(tf1);
        
        l4.setBounds(100,190,200,30);
        add(l4);
        
        tf2.setBounds(300,190,400,30);
        add(tf2);
        
        l5.setBounds(100,240,200,30);
        add(l5);
        
        l13.setBounds(300,240,40,30);
        add(l13);
        
        jc1.setBounds(340,240,60,30);
        add(jc1);
        
        l14.setBounds(410,240,50,30);
        add(l14);
        
        jc2.setBounds(460,240,100,30);
        add(jc2);
        
        l15.setBounds(570,240,40,30);
        add(l15);
        
        jc3.setBounds(610,240,90,30);
        add(jc3);
        
        l6.setBounds(100,290,200,30);
        add(l6);
        
        jr1.setBounds(300,290,60,30);
        add(jr1);
        
        jr2.setBounds(450,290,90,30);
        add(jr2);
        
        l7.setBounds(100,340,200,30);
        add(l7);
        
        tf3.setBounds(300,340,400,30);
        add(tf3);
        
        l8.setBounds(100,390,200,30);
        add(l8);
        
        jr3.setBounds(300,390,100,30);
        add(jr3);
        
        jr4.setBounds(450,390,100,30);
        add(jr4);

        
        
        
        l9.setBounds(100,440,200,30);
        add(l9);
        
        tf4.setBounds(300,440,400,30);
        add(tf4);
        
        l10.setBounds(100,490,200,30);
        add(l10);
        
        tf5.setBounds(300,490,400,30);
        add(tf5);
        
        l11.setBounds(100,540,200,30);
        add(l11);
        
        tf6.setBounds(300,540,400,30);
        add(tf6);
        
        l12.setBounds(100,590,200,30);
        add(l12);
        
        tf7.setBounds(300,590,400,30);
        add(tf7);
        
        next.setBounds(620,660,80,30);
        add(next);
        
        next.addActionListener(this); 
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(850,850);
        setLocation(500,90);
        setVisible(true);
        JOptionPane.showMessageDialog(rootPane, "Please Remember your Form Number\nYour Form Number is-: "+formNumber);
        
        
        
        
        
        
    }
    static boolean isEmailValid(String email) {
        String regex = "^[\\w-_\\.+]*[\\w-_\\.]\\@([\\w]+\\.)+[\\w]+[\\w]$";
        return email.matches(regex);
    }
    public void actionPerformed(ActionEvent ae)
    {
        String name = tf1.getText();
        String fname = tf2.getText();
        String email = tf3.getText();
        String add = tf4.getText();
        String city = tf5.getText();
        String pcode = tf6.getText();
        String state = tf7.getText();
        String errors = "";
        String mm = (String)jc2.getSelectedItem();
        String dd = (String)jc1.getSelectedItem();
        String yy = (String)jc3.getSelectedItem();
        
        
        Boolean male = false, female = false;
        if(jr1.isSelected())
                male = true;
        if(jr2.isSelected())
                female = true;
        Boolean married = false, unmarried = false;
        if(jr3.isSelected())
            married = true;
        if(jr4.isSelected())
            unmarried = true;
        if(name.isEmpty() || fname.isEmpty() || email.isEmpty() || add.isEmpty() || city.isEmpty() || pcode.isEmpty() || state.isEmpty() || dd.isEmpty() || mm.isEmpty() || yy.isEmpty() || (!(male || female)) || (!(married || unmarried)))
            JOptionPane.showMessageDialog(rootPane, "Please Select All Fields");
        else{
            if((mm.equals("April") || mm.equals("June") || mm.equals("September")|| mm.equals("November")) && dd.equals("31"))
                errors += "Select Correct Date ";
            else if(mm.equals("February") && (dd.equals("29") || dd.equals("30") || dd.equals("31")))
                errors += "Select Correct Date ";
        
            if(male && female)
                errors += "\nSelect Only one Gender";
        
            if(married && unmarried)
               errors += "\nSelect Only one Marital Status";
            if(!isEmailValid(email))
                errors += "\nPlease enter a valid Email Address";
            if(!errors.isEmpty())
            {
                
                JOptionPane.showMessageDialog(rootPane, errors);
            }
            //SQL execution will start if else block will execute
            //Till now all Validation are checked
            else{
                try{
                    String gender = (male)?"male":"female";
                    String maritalStatus = (married)?"married":"unmarried";
                    JOptionPane.showMessageDialog(rootPane, gender+"\n"+maritalStatus);
                    conn c = new conn();
                    String q = "insert into signup values ('"+name+"', '"+fname+"','"+dd+"','"+mm+"','"+yy+"', '"+gender+"','"+email+"','"+maritalStatus+"','"+add+"','"+city+"','"+pcode+"','"+state+"','"+formNumber+"')";
                    c.s.executeUpdate(q);
                }catch(Exception e){
                    JOptionPane.showMessageDialog(rootPane, e);
                    System.out.print(e);
                }
                
            }
        }
        
        
        
        
        
    }
    public static void main(String args[])
    {
        new Signup().setVisible(true);
    }
        
}
