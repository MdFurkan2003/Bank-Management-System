
package bank.management.system;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
public class PinChange extends JFrame implements ActionListener{
    JPasswordField pin, repin;
    JButton change,back;
    String pinnumber;
    PinChange(String pinnumber){
        this.pinnumber = pinnumber;
        setLayout(null);
       
       ImageIcon i1 =new ImageIcon(ClassLoader.getSystemResource("icons/atm.jpg"));
       Image i2 = i1.getImage().getScaledInstance(900,850,Image.SCALE_DEFAULT);
       ImageIcon i3 = new ImageIcon(i2);
       JLabel Image = new JLabel(i3);
       Image.setBounds(0,0,900,850);
       add(Image);
       
       JLabel text = new JLabel("CHANGE YOUR PIN");
       text.setBounds(250,280,500,35);
       text.setForeground(Color.WHITE);
       text.setFont(new Font("System",Font.BOLD,16));
       Image.add(text);
       
       JLabel pintext = new JLabel("New Pin:");
       pintext.setBounds(165,320,180,35);
       pintext.setForeground(Color.WHITE);
       pintext.setFont(new Font("System",Font.BOLD,16));
       Image.add(pintext);
       
        pin = new JPasswordField();
       pin.setFont(new Font("Raleway",Font.BOLD,22));
       pin.setBounds(300,320,180,25);
       Image.add(pin);
       
        JLabel repintext = new JLabel("Re-Inter New Pin:");
      repintext.setBounds(165,360,180,35);
       repintext.setForeground(Color.WHITE);
       repintext.setFont(new Font("System",Font.BOLD,16));
       Image.add(repintext);
       
       repin = new JPasswordField();
       repin.setFont(new Font("Raleway",Font.BOLD,22));
       repin.setBounds(300,360,180,25);
       Image.add(repin);
       
       change = new JButton("CHANGE");
       change.setBounds(355,450,150,30);
       change.addActionListener(this);
       Image.add(change);
       
       back = new JButton("BACK");
       back.setBounds(355,485,150,30);
       back.addActionListener(this);
       Image.add(back);
       
       setSize(900,850);
       setLocation(300,0);
       setUndecorated(true);
       setVisible(true);
       
    }
    public void actionPerformed(ActionEvent ae){
        if (ae.getSource()== change){
        try {
            String npin = pin.getText();
            String rpin = pin.getText();
            if(!npin.equals(rpin)){
                JOptionPane.showMessageDialog(null,"Entered Pin does not match ");
                return;
                    
            }
            if(npin.equals("")){
             JOptionPane.showMessageDialog(null,"please enter new PIN ");
             return;
            }
            if(rpin.equals("")){
                JOptionPane.showMessageDialog(null,"please re-enter new PIN ");
                return;
            }
            Conn conn = new Conn();
            String quary1 = "update bank set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            String quary2 = "update login set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            String quary3 = "update signup5 set pin = '"+rpin+"' where pin ='"+pinnumber+"'";
            
            conn.s.executeUpdate(quary1);
            conn.s.executeUpdate(quary2);
            conn.s.executeUpdate(quary3);
            JOptionPane.showMessageDialog(null,"PIN changed successfully ");
            setVisible(false);
            new Transactions(rpin).setVisible(true);
        
        }catch(Exception e){
           System.out.println(e);
        }
      }else {
            setVisible(false);
            new Transactions(pinnumber).setVisible(true);
        }
   }
    public static void main(String args[]) {
        new PinChange("").setVisible(true);
        
         
   }
}
