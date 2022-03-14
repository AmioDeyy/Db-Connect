package amio;

import javax.swing.*;
import java.sql.*;


public class DbConnect {

    private Connection con;
    private Statement st;
   private ResultSet rs;
   private  int flag = 0;




    public DbConnect() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
             con = DriverManager.getConnection("jdbc:mysql://localhost:3306/docinfotable","root","");
             st = con.createStatement();
        } catch (Exception e){
            System.out.println(e);
        }
    }

    public void RegisterInsert(String queryInsert) {
        System.out.println("Hello");

        try {
             st.executeUpdate(queryInsert);
            System.out.println(queryInsert);
            JOptionPane.showMessageDialog(null,"Registration Completed");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "Registration not Completed!!");
        }
    }

    public void Login(String queryLogin, String userName, String pass) {
        try{
            rs = st.executeQuery(queryLogin);
            while(rs.next())
            {

                String userIdentity = rs.getString(2);
                String userPass = rs.getString(4);

                if(userName.equals(userIdentity) && pass.equals(userPass)){
                    JOptionPane.showMessageDialog(null,"**Most Welcome**");
                    flag = 1;
                    break;
                }

            }
            if (flag == 0){
                JOptionPane.showMessageDialog(null,"you are not a valid user");
            }

        }catch(Exception e) {
            JOptionPane.showMessageDialog(null,e);
        }
    }
}




