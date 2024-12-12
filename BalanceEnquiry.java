
package bank.management.system;
import javax .swing.*;
import java .awt.*;
import java.awt.event.*;
import java.sql.*;
public class BalanceEnquiry extends JFrame implements ActionListener{
    JButton back;
    String Pinnumber;
    BalanceEnquiry(String pinnumber){
        this.Pinnumber = pinnumber;
        setLayout(null);
        
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel Image = new JLabel(i3);
       Image.setBounds(0,0,900,850);
       add(Image);
       
       back = new JButton("BACK");
       back.setBounds(355,485,150,30);
       back.addActionListener(this);
       Image.add(back);
       
        Conn c = new Conn();
         int balance = 0;
            try{
                ResultSet rs = c.s.executeQuery("select *from bank where pin = '"+pinnumber+"'");
                while(rs.next()){
                    if(rs.getString("type").equals("Deposit")){
                        balance  += Integer.parseInt(rs.getString("amount"));
                    }else{
                        balance -= Integer.parseInt(rs.getString("amount"));
                    }
                 }
            }catch(Exception e){
                System.out.println(e);
            }
            
            
       JLabel text = new JLabel("Your Current Account balance is RS" + balance);
       text.setBounds(175,300,400,30);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,15));
       Image.add(text);
       
        setSize(900,850);
        setLocation(300,0);
        setUndecorated(true);
        setVisible(true);
        
    }
    public void actionPerformed(ActionEvent ae){
        setVisible(false);
        new Transactions(Pinnumber).setVisible(true);
        
    }

    
    public static void main(String args[]) {
        new BalanceEnquiry("");
        
    }
}
