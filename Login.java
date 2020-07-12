package atm;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
/**
 *
 * @author kulha
 */
public class Login extends JFrame implements ActionListener{
    
    JLabel l1, l2, l3;
    JTextField tf1;
    JPasswordField pf1;
    JButton b1, b2, b3;
    Login(){
        setFont(new Font("System", Font.BOLD, 22));
        Font f = getFont();
        FontMetrics fm = getFontMetrics(f);
        int x = fm.stringWidth("AUTOMATED TELLER MACHINE");
        int y = fm.stringWidth(" ");
        int z = getWidth() - x;
        int w = z/y;
        String pad = "";
        pad = String.format("%"+w+"s",pad);
        setTitle(pad+"AUTOMATED TELLER MACHINE");
        
        l1 = new JLabel("Welcome to ATM");
        l1.setFont(new Font("Osward", Font.BOLD, 38));
        
        l2 = new JLabel("Card NO");
        l2.setFont(new Font("Raleway", Font.BOLD, 28));
        
        l3 = new JLabel("PIN");
        l3.setFont(new Font("Raleway", Font.BOLD, 28));;
        
        tf1 = new JTextField(15);
        pf1 = new JPasswordField(15);
        
        b1 = new JButton("SIGN IN");
        b1.setBackground(Color.BLACK);
        b1.setForeground(Color.WHITE);
        
        b2 = new JButton("CLEAR");
        b2.setBackground(Color.BLACK);
        b2.setForeground(Color.WHITE);
        
        b3 = new JButton("SIGN UP");
        b3.setBackground(Color.BLACK);
        b3.setForeground(Color.WHITE);
        
        setLayout(null);
        
        l1.setBounds(175, 50, 450, 200);
        add(l1);
        
        l2.setBounds(125, 150, 375, 200);
        add(l2);
        
        l3.setBounds(125, 255,375, 200);
        add(l3);
        
        tf1.setBounds(300, 235, 230, 30);
        pf1.setBounds(300, 310, 230, 30);
        
        add(tf1);
        add(pf1);
        
        b1.setBounds(300, 400, 100, 30);
        add(b1);
        
        b2.setBounds(430, 400, 100, 30);
        add(b2);
        
        b3.setBounds(300, 450, 230, 30);
        add(b3);
        
        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        
        getContentPane().setBackground(Color.WHITE);
        
        setSize(750, 750);
        setLocation(500, 200);
        setVisible(true);
    }
    
    public void actionPerformed(ActionEvent ae){
        try{
            conn c1 = new conn();
            String a = tf1.getText();
            String b = pf1.getText();
            if(ae.getSource() == b1)
            {
                if(a.isEmpty() || b.isEmpty())
                    JOptionPane.showMessageDialog(rootPane, "Please fill all the details");
                else{
                    String q = "select * from login where cardno = '"+a+"' and pin = '"+b+"'";
                    ResultSet rs = c1.s.executeQuery(q);
                    if(!rs.next())
                        JOptionPane.showMessageDialog(rootPane, "You don't have account please click on SIGNUP button");
                    String checka = rs.getString("cardno");
                    String checkb = rs.getString("pin");
                    if(a.equals(checka) && b.equals(checkb))
                        JOptionPane.showMessageDialog(rootPane, "LoginSuccessfull");
                    else
                        JOptionPane.showConfirmDialog(rootPane, "You entered wrong details");
                }
            }
            if(ae.getSource() == b2)
            {
                tf1.setText("");
                pf1.setText("");
            }
            if(ae.getSource() == b3)
            {
                new Signup().setVisible(true);
                //this.setVisible(false);
            }
            
            
        }catch(Exception e){
            System.out.println(e);
        }
    }
    public static void main(String ares[])
    {
        new Login().setVisible(true);
    }
}
