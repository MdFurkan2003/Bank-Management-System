
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;


public class Withdrawl extends JFrame implements ActionListener {
   JTextField amount;
    JButton withdrawl,back;
    String pinnumber;
    Withdrawl(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel Image = new JLabel(i3);
       Image.setBounds(0,0,900,850);
       add(Image);
       
       JLabel text = new JLabel("Enter the amount you want to withdraw");
       text.setBounds(180,300,400,20);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,15));
       Image.add(text);
       
       amount = new JTextField();
       amount.setFont(new Font("Raleway",Font.BOLD,22));
       amount.setBounds(170,340,320,20);
       Image.add(amount);
       
       withdrawl = new JButton("Withdraw");
      withdrawl.setBounds(355,455,150,30);
       withdrawl.addActionListener(this);
       Image.add(withdrawl);
       
       back = new JButton("Back");
       back.setBounds(355,490,150,30);
       back.addActionListener(this);
       Image.add(back);
       
        setSize(900,900);
        setLocation(300,0);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==withdrawl){ 
         String number = amount.getText();
            Date date = new Date();
            
            if(number.equals("")){
                   JOptionPane.showMessageDialog(null,"Please enter the amount you want to withdrawl "); 
                }else{
                try{
                    Conn conn = new Conn();
                    String query1 ="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+number+"')";
                    conn.s.executeUpdate(query1);
                    JOptionPane.showMessageDialog(null,"RS"+number+"withrawl suscessfully");
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }catch(Exception e){
                 System.out.println(e);
            }
            
            }
        }else if (ae.getSource()==back){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
    }

 

    
    public static void main(String args[]) {
        new Withdrawl("");
    }
}
