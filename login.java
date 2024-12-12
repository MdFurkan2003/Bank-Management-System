
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.sql.*;

public class login extends JFrame implements ActionListener {

    static void addActionListener(ActionListener actionListener) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
    JButton login,clear,signup;
    JTextField cardTextField;
    JPasswordField pinTextField;
    login(){   
        setTitle("AUTOMATED TELLER MACHINE");
        setLayout(null);
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/logo2.jpg"));
       Image i2 = i1.getImage().getScaledInstance(155,90,Image.SCALE_DEFAULT);
       //Image.setFont(new Font("RALEWAY",Font.BOLD,14));
       ImageIcon i3 =new ImageIcon(i2);
        JLabel label = new JLabel(i3);
        label.setBounds(90,10,100,100);
        add(label); 
        
        JLabel text = new JLabel("Welcome To ATM");
        text.setFont(new Font("RALEWAY",Font.BOLD,40));
        text.setBounds(200,40,400,40); 
        add(text);
        
        JLabel cardno = new JLabel("CARD NO");
        cardno.setFont(new Font("RALEWAY",Font.BOLD,30));
        cardno.setBounds(120,150,150,30); 
        add(cardno);
        
         cardTextField =new JTextField();
        cardTextField.setBounds(300,150,240,30);
        cardTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(cardTextField);
        
        
        JLabel pin = new JLabel("PIN");
        pin.setFont(new Font("osward",Font.BOLD,30));
        pin.setBounds(120,220,250,30); 
        add(pin);
        
         pinTextField = new JPasswordField();
        pinTextField.setBounds(300,220,250,30);
        pinTextField.setFont(new Font("Arial",Font.BOLD,14));
        add(pinTextField);
        
         login = new JButton("SIGN IN");
        login.setBounds(200,300,100,30);
        login.setBackground(Color.BLACK);
        login.setForeground(Color.WHITE);
        login.addActionListener(this);
        add(login);
        
         clear = new JButton("CLEAR");
        clear.setBounds(430,300,100,30);
        clear.setBackground(Color.BLACK);
        clear.setForeground(Color.WHITE);
        clear.addActionListener(this);
        add(clear);
        
         signup = new JButton("SIGN UP");
        signup.setBounds(260,350,230,30);
        signup.setBackground(Color.BLACK);
        signup.setForeground(Color.WHITE);
        signup.addActionListener(this);
        add(signup);
        
        
        getContentPane().setBackground(Color.WHITE);
        setSize(1000,600);
        setVisible(true);
        setLocation(350,200);
        
    }
    public void actionPerformed(ActionEvent ae){
        if(ae.getSource()==clear){
            cardTextField.setText("");
            pinTextField.setText("");
            
        }else if(ae.getSource()==login){
            
            Conn conn = new Conn();
            String cardnumber = cardTextField.getText();
            String pinnumber = pinTextField.getText();
            String query = "select * from login where cardnumber ='"+cardnumber+"'and pin = '"+pinnumber+"'"; 
            try{
                ResultSet rs = conn.s.executeQuery(query);
                if(rs.next()){
                    setVisible(false);
                    new Transactions(pinnumber).setVisible(true);
                }else{
                    JOptionPane.showMessageDialog(null,"Incorrect Card Number or Pin");
                }
            }catch(Exception e){
                System.out.println(e);
            }
            
        }else if(ae.getSource()==signup){
            setVisible(false);
            new SignupOne().setVisible(true);
            
        }
    }

   
    public static void main(String args[]) {
        
       //
       new login();
     }
  }