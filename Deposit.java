/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package atm;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
/**
 *
 * @author kulha
 */
public class Deposit extends JFrame implements ActionListener{
    
    JTextField t1,t2;
    JButton b1,b2,b3;
    JLabel l1,l2,l3;
    
    Deposit(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("DEPOSIT");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (5*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"DEPOSIT");
        
        
        l1 = new JLabel("ENTER AMOUNT YOU WANT");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("TO DEPOSIT");
        l2.setFont(new Font("System", Font.BOLD, 35));
        
        l3 = new JLabel("Enter Pin");
        l3.setFont(new Font("System", Font.BOLD, 14));
        
        t1 = new JTextField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JTextField();
        t2.setFont(new Font("Raleway", Font.BOLD, 14));
        
        b1 = new JButton("DEPOSIT");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("EXIT");
        b3.setFont(new Font("System", Font.BOLD, 18));
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        
        setLayout(null);
        
        l3.setBounds(620,10,80,30);
        add(l3);
        
        t2.setBounds(700,10,40,30);
        add(t2);
        
        l1.setBounds(150,150,800,60);
        add(l1);
        
        l2.setBounds(290,210,800,60);
        add(l2);
        
        t1.setBounds(250,300,300,50);
        add(t1);
        
        b1.setBounds(260,380,125,50);
        add(b1);
        
        b2.setBounds(415,380,125,50);
        add(b2);
        
        b3.setBounds(300,550,200,50);
        add(b3);
        
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        
        if(ae.getSource() == b1)
        {
            try{
                String pin = t2.getText();
                String amount = t1.getText();
                conn con = new conn();
                String q = "select balance from bank where pin = '"+pin+"'";
                ResultSet rs = con.s.executeQuery(q);
                if(!rs.next())
                {
                    JOptionPane.showMessageDialog(rootPane, "You Entered a Wrong PIN number");
                    new Transaction().setVisible(true);
                }
                else{
                    Integer balance = Integer.parseInt(rs.getString("balance"));
                    balance += Integer.parseInt(amount);
                    q = "update bank set balance = '"+Integer.toString(balance)+"' where pin = '"+pin+"'";
                    con.s.executeUpdate(q);
                    
                    q = "select balance from bank where pin = '"+pin+"'";
                    rs = con.s.executeQuery(q);
                    JOptionPane.showMessageDialog(rootPane, "Your New Availabe Balance is\n"+balance);
                    new Transaction().setVisible(true);
                    
                }
            }catch(Exception e)
            {
                JOptionPane.showMessageDialog(rootPane, e);
            }
        }
        else if(ae.getSource() == b2)
            setVisible(false);
            new Transaction().setVisible(true);
        else
        {
            setVisible(false);
            System.exit(0);
        }
        
    }
}
