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
public class Pin extends JFrame implements ActionListener{
    
    
    JPasswordField t1,t2,t3;
    JButton b1,b2;                               
    JLabel l1,l2,l3,l4;
    
    Pin(){
        
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("PIN CHANGE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - (3*x);
        int w = z/y;
        String pad ="";
        //for (int i=0; i!=w; i++) pad +=" ";   
        pad = String.format("%"+w+"s", pad);
        setTitle(pad+"PIN CHANGE");
        
        
        l1 = new JLabel("CHANGE YOUR PIN");
        l1.setFont(new Font("System", Font.BOLD, 35));
        
        l2 = new JLabel("Current PIN:");
        l2.setFont(new Font("System", Font.BOLD, 22));
        
        l3 = new JLabel("New PIN:");
        l3.setFont(new Font("System", Font.BOLD, 22));
        
        l4 = new JLabel("Re-Enter New PIN:");
        l4.setFont(new Font("System", Font.BOLD, 22));
        
        t1 = new JPasswordField();
        t1.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t2 = new JPasswordField();
        t2.setFont(new Font("Raleway", Font.BOLD, 22));
        
        t3 = new JPasswordField();
        t3.setFont(new Font("Raleway", Font.BOLD, 22));
        
        b1 = new JButton("SAVE");
        b1.setFont(new Font("System", Font.BOLD, 18));
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
    
        b2 = new JButton("BACK");
        b2.setFont(new Font("System", Font.BOLD, 18));
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        
        
        setLayout(null);
        
        l1.setBounds(220,130,800,60);
        add(l1);
        
        l2.setBounds(100,240,150,40);
        add(l2);
        
        l3.setBounds(100,300,150,40);
        add(l3);
        
        l4.setBounds(100,360,200,40);
        add(l4);
        
        t1.setBounds(310,240,360,40);
        add(t1);
        
        t2.setBounds(310,300,360,40);
        add(t2);
        
        t3.setBounds(310,360,360,40);
        add(t3);
        
        b1.setBounds(220,460,160,50);
        add(b1);
        
        b2.setBounds(400,460,160,50);
        add(b2);
        
        
        
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(800,800);
        setLocation(500,90);
        setVisible(true);
    
    }
    
    public void actionPerformed(ActionEvent ae){
        
        String pin = t1.getText();
        String newPin = t2.getText();
        String confirmPin = t3.getText();
        try{
            if(ae.getSource() == b1)
            {
                conn con = new conn();
                String q = "select pin from login where pin = '"+pin+"'";
                
                ResultSet rs = con.s.executeQuery(q);
                if(!(rs.next()))
                    JOptionPane.showMessageDialog(rootPane, "You entered a Wrong PIN\nPlease type correct pin to change");
                else
                {
                    if(newPin.equals(confirmPin))
                    {
                        q = "update bank SET pin = '"+newPin+"' where pin = '"+pin+"'";
                        con.s.executeUpdate(q); // in bank table
                        q = "update login SET pin = '"+newPin+"' where pin = '"+pin+"'";
                        con.s.executeUpdate(q); // in login table
                        q = "update signup3 SET pin = '"+newPin+"' where pin = '"+pin+"'";
                        con.s.executeUpdate(q); // in signup3 table
                    }
                }
            }
            else if(ae.getSource() == b2)
                setVisible(false);
            else
                System.exit(0);
        }catch(Exception e){
                JOptionPane.showMessageDialog(rootPane, e);
        }
    }
}
