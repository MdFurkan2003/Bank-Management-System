
package bank.management.system;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;
import java.util.Date;


public class FastCash extends JFrame implements ActionListener{
    JButton deposit,withdrawl,pinchange,ministatement,fastcash ,balanceenquiry,exit;
    String pinnumber;
   FastCash(String pinnumber){
        this.pinnumber = pinnumber;
        
        setLayout(null);
        
        ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
       ImageIcon i3 =new ImageIcon(i2);
       JLabel Image = new JLabel(i3);
       Image.setBounds(0,0,900,850);
       add(Image);
       
       JLabel text = new JLabel("SELECT WITHDRAWL AMOUNT");
       text.setBounds(215,300,700,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,15));
       Image.add(text);
       
       deposit = new JButton("RS 100");
       deposit.setBounds(170,395,150,30);
       deposit.addActionListener(this);
       Image.add(deposit);
       
       withdrawl = new JButton("Rs 500");
       withdrawl.setBounds(355,395,150,30);
       withdrawl.addActionListener(this);
       Image.add(withdrawl);
       
       fastcash = new JButton("Rs 1000");
       fastcash.setBounds(170,430,150,30);
       fastcash.addActionListener(this);
       Image.add(fastcash);
       
       ministatement = new JButton("Rs 2000");
       ministatement.setBounds(355,427,150,30);
       ministatement.addActionListener(this);
       Image.add(ministatement);
       
       pinchange = new JButton("Rs 5000");
       pinchange.setBounds(170,465,150,30);
       pinchange.addActionListener(this);
       Image.add(pinchange);
       
        balanceenquiry = new JButton("Rs 10000");
       balanceenquiry.setBounds(355,459,150,30);
       balanceenquiry.addActionListener(this);
       Image.add(balanceenquiry);
       
       exit = new JButton("BACK");
       exit.setBounds(355,490,150,30);
       exit.addActionListener(this);
       Image.add(exit);
       
       setSize(900,900);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource() == exit){
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }else {
            String amount =((JButton)ae.getSource()).getText().substring(3);
            Conn c = new Conn();
            try{
                ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
                int balance = 0;
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance  += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                 }
                  if (ae.getSource()!= exit && balance < Integer.parseInt(amount)){
                      JOptionPane.showMessageDialog(null,"Incufficient balance");
                      return;
                  }
                  Date date = new Date();
                  String query ="insert into bank values('"+pinnumber+"','"+date+"','withdrawl','"+amount+"')";
                    c.s.executeUpdate(query);
                    JOptionPane.showMessageDialog(null," Rs"+ amount + " Debited Sucessfully ");
                    
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                
        }catch(Exception e){
            System.out.println(e);
        }
      }
    }
    
    public static void main(String args[]) {
        new FastCash(" ");
        
    }
}
