
package bank.management.system;

import javax.swing.*;
import java.awt.*;
//import java.util.*;
//import com.toedter.calendar.JDateChooser;
import java.awt.event.*;
// import java.sql.SQLException;
//importjava.sql.SQLException;

public class SignupTwo extends JFrame implements ActionListener {
    //long random;
    JTextField pan,aadahar;
    JButton next;
    JRadioButton syes,sno,eyes,eno;
    JComboBox religion,category,occupation,education,income;
    String formno;
    
    SignupTwo(String formno) {
        this.formno = formno; 
        
        setLayout(null);
        setTitle("NEW ACCOUNT APPLICATION FORM-PAGE2");
        
         //JLabel sformno = new JLabel("APPLICATION FORM NO."+random);
        //sformno.setFont(new Font("Raleway",Font.BOLD,38));
        //sformno.setBounds(140,20,600,40);
        //add(sformno);
        
        JLabel additionalDetails = new JLabel("Page 2:AdditionalDetails");
        additionalDetails.setFont(new Font("Raleway",Font.BOLD,24));
        additionalDetails.setBounds(290,80,400,30);
        add(additionalDetails);
        
        JLabel Religion  = new JLabel("Religion:");
        Religion.setFont(new Font("Raleway",Font.BOLD,22));
        Religion.setBounds(100,140,100,30);
        add(Religion);
        
        String valReligion[] = {"Hindu","Muslim","Sikh","Christian","Other"};
        religion = new JComboBox(valReligion);
        religion.setBounds(300,140,400,30);
        religion.setBackground(Color.WHITE);
        add(religion);
        
        
        JLabel Category = new JLabel(" Category:");
       Category.setFont(new Font("Raleway",Font.BOLD,22));
        Category.setBounds(95,190,200,30);
        add(Category);
        
        String valcategory[] = {"General","OBC","SC","ST","Other"};
        category = new JComboBox(valcategory);
        category.setBounds(300,190,400,30);
        category.setBackground(Color.WHITE);
        add(category);
        
        JLabel dob = new JLabel(" Icome:");
        dob.setFont(new Font("Raleway",Font.BOLD,22));
        dob.setBounds(95,240,200,30);
        add(dob);
        
       String incomecategory[] = {"NULL","<1,50,000","<2,50,000","<5,00,000","upto 10,00,000"};
       income = new JComboBox(incomecategory);
       income.setBounds(300,240,400,30);
       income.setBackground(Color.WHITE);
        add(income);
        
  
        JLabel gender = new JLabel("Educational");
        gender.setFont(new Font("Raleway",Font.BOLD,22));
        gender.setBounds(100,290,200,30);
        add(gender);
        
       String educationalValues[] = {"Non Graduation","Graduation","Post Graduation","Doctrate","Other"};
       education = new JComboBox(educationalValues);
       education.setBounds(300,320,400,30);
       education.setBackground(Color.WHITE);
        add(education); 
        
        JLabel email = new JLabel("Qualification:");
        email.setFont(new Font("Raleway",Font.BOLD,22));
        email.setBounds(100,315,200,30);
        add(email);
        
        JLabel merital = new JLabel("Occupation:");
        merital.setFont(new Font("Raleway",Font.BOLD,22));
        merital.setBounds(100,390,200,30);
        add(merital);
        
       String occupationValues[] = {"Salaried","Self Employed","Bussiness","Student","Retired","Other"};
       occupation = new JComboBox(occupationValues);
       occupation.setBounds(300,390,400,30);
       occupation.setBackground(Color.WHITE);
        add(occupation); 
       
        JLabel address = new JLabel("PAN Number:");
        address.setFont(new Font("Raleway",Font.BOLD,22));
       address.setBounds(100,440,200,30);
        add(address);
        
        pan = new JTextField();
        pan.setFont(new Font("Raleway",Font.BOLD,14 ));
        pan.setBounds(300,440,400,30);
        add(pan);
        
        JLabel city = new JLabel("Aadahar Number:");
       city.setFont(new Font("Raleway",Font.BOLD,22));
        city.setBounds(100,490,200,30);
        add(city);
        
        aadahar = new JTextField();
        aadahar.setFont(new Font("Raleway",Font.BOLD,14 ));
        aadahar.setBounds(300,490,400,30);
        add(aadahar);
        
        JLabel senior = new JLabel("Senior Citizen:");
        senior.setFont(new Font("Raleway",Font.BOLD,22));
        senior.setBounds(100,540,200,30);
        add(senior);
        
         syes=new JRadioButton("Yes");
         syes.setBounds(300,540,100,30);
         syes.setBackground(Color.WHITE);
        add( syes);
        
        sno=new JRadioButton("NO");
        sno.setBounds(450,540,100,30);
        sno.setBackground(Color.WHITE);
        add( sno);
        
        ButtonGroup seniorgroup =new ButtonGroup();
        seniorgroup.add(syes);
        seniorgroup.add(sno);
        
        JLabel exsit = new JLabel("Exsiting Account:");
        exsit.setFont(new Font("Raleway",Font.BOLD,22));
       exsit.setBounds(100,590,200,30);
        add(exsit);
        
         eyes=new JRadioButton("Yes");
         eyes.setBounds(300,590,100,30);
         eyes.setBackground(Color.WHITE);
        add( eyes);
        
        eno=new JRadioButton("NO");
         eno.setBounds(450,590,100,30);
         eno.setBackground(Color.WHITE);
        add( eno);
        
        ButtonGroup exsitinggroup =new ButtonGroup();
        exsitinggroup .add(eyes);
        exsitinggroup .add(eno);
        
        
        
        next = new JButton("Next");
        next.setBackground(Color.BLACK);
        next.setForeground(Color.WHITE);
        next.setFont(new Font("Raleway",Font.BOLD ,14));
        next.setBounds(620,660,80,30);
        next.addActionListener(this);
        add(next);
        
        getContentPane().setBackground(Color.WHITE);
        setSize(850,800);
        setLocation(350,10);
        setVisible(true);
    }
    public void actionPerformed(ActionEvent ae){
       // String formno ="" + random;
        String sreligion = (String)religion.getSelectedItem();
        String scategory =(String)category.getSelectedItem();
        String sincome = (String)income.getSelectedItem();
        String seducation = (String)education.getSelectedItem();
        String soccupation = (String)occupation.getSelectedItem();
        String seniorcitizen = null;
        if(syes.isSelected()){
             seniorcitizen= "Yes";
        } else if(sno.isSelected()){
            seniorcitizen = "No";
        }
        //String email = emailTextField.getText();
        String exsitingaccount = null;
        if(eyes.isSelected()){
             exsitingaccount= "yes";
        }else if(eno.isSelected()){
            exsitingaccount = "no";
        }
        String span = pan.getText();
        String saadahar =aadahar.getText();
        
        try {
            
          Conn c= new Conn();
          String query ="insert into signup4 value('"+formno+"','"+sreligion+"','"+scategory+"','"+sincome+"','"+seducation+"','"+soccupation+"','"+span+"','"+saadahar+"','"+seniorcitizen+"','"+exsitingaccount+"')";
          c.s.executeUpdate(query);
         setVisible(false);
         new SignupThree(formno).setVisible(true);
    
        }catch(Exception e){
            System.out.println(e);
            
        }
    }
        public static void main(String args[]) {     
       // public static void main(String args[]) {
            new SignupTwo("");
      
        
    }

}