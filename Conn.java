
package bank.management.system;

import java.sql.*;
public class Conn {
    Connection c;
    Statement s;
   public Conn(){
       try{
           c = DriverManager.getConnection("jdbc:mysql:///banks", "root", "Furkan@#34");
           
           s = c.createStatement();
       }catch(Exception e){
           System.out.println(e);
       }
        
    }

    
    //public static void main(String args[]) {
        
    }
//}
