package amio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.regex.Pattern;

public class RegistrationFom extends JFrame {
    JLabel l1,l2,l3,l4,l5,l6,l7;
    JButton b1,b2;
    JPanel p1,p2;
    JTextField t1,t2,t3,t4,t5,t6;



    RegistrationFom(){
        setSize(550,580);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("**RegisTration InterFace**");

        Font f = new Font("Arial",Font.BOLD,19);
        Font f1 = new Font("Italic",Font.BOLD,29);

        p1 = new JPanel();
        p1.setBounds(0,0,550,80);
        p1.setBackground(Color.LIGHT_GRAY);
        add(p1);

        p2 = new JPanel();
        p2.setBounds(0,100,550,420);
        p2.setBackground(Color.CYAN);
        p2.setLayout(null);
        add(p2);

        l1 = new JLabel("** RegistrationFromInterface **");
        l2 = new JLabel("Name                            :");
        l3 = new JLabel("Email                            :");
        l4 = new JLabel("Password                    :");
        l5 = new JLabel("Confirm Password    :");
        l6 = new JLabel("Mobile                          :");
        l7 = new JLabel("Address                       :");

        l1.setBounds(10,20,350,50);
        l1.setFont(f1);
        p1.add(l1);

        l2.setBounds(8,110,200,20);
        l2.setFont(f);
        p2.add(l2);

        l3.setBounds(8,170,210,20);
        l3.setFont(f);
        p2.add(l3);

        l4.setBounds(8,230,200,20);
        l4.setFont(f);
        p2.add(l4);

        l5.setBounds(8,290,300,20);
        l5.setFont(f);
        p2.add(l5);

        l6.setBounds(8,350,200,20);
        l6.setFont(f);
        p2.add(l6);

        l7.setBounds(8,410,200,20);
        l7.setFont(f);
        p2.add(l7);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();

        t1.setBounds(230,110,250,35);
        t1.setFont(f);
        p2.add(t1);

        t2.setBounds(230,170,250,35);
        t2.setFont(f);
        p2.add(t2);

        t3.setBounds(230,230,250,35);
        t3.setFont(f);
        p2.add(t3);

        t4.setBounds(230,290,250,35);
        t4.setFont(f);
        p2.add(t4);

        t5.setBounds(230,350,250,35);
        t5.setFont(f);
        p2.add(t5);

        t6.setBounds(230,410,250,35);
        t6.setFont(f);
        p2.add(t6);

        b1 = new JButton("Login");
        b2 = new JButton("Register");

        b1.setBounds(19,460,120,60);
        b1.setFont(f);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.LIGHT_GRAY);
        p2.add(b1);

        b2.setBounds(360,460,120,60);
        b2.setFont(f);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.LIGHT_GRAY);
        p2.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new LoginForm();
            }
        });

        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = t1.getText();
                String email = t2.getText();
                String Pass = t3.getText();
                String conPass = t4.getText();
                String mobile = t5.getText();
                String address = t6.getText();
                // System.out.println(email);

                String nameRegex = "^[a-zA-Z.]+$";
                String emailRegex = "^[a-z0-9]+@[a-z]+.[a-z]+$";
                String mobileRegex = "(\\+88)?-?01[3-9]\\d{8}";
                String passRegex = "(?=.*\\d)(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$$%&*()]).{6,20}";


                if(!Pattern.matches(nameRegex,userName)){
                    JOptionPane.showMessageDialog(null,"Only use character!!");
                }
                else if(!Pattern.matches(emailRegex,email)){
                    JOptionPane.showMessageDialog(null,"Invalid Data!!");
                }
                else if(!Pattern.matches(passRegex,Pass)){
                    JOptionPane.showMessageDialog(null,"Invalid pass!!,1 digit,1lower,1 upper,1 special char,length 6-20");
                }
                else if(!conPass.equals(Pass)){
                    JOptionPane.showMessageDialog(null,"pass And conPass are not same!!");
                }
                else if(!Pattern.matches(mobileRegex,mobile)){
                    JOptionPane.showMessageDialog(null,"Invalid phone no!!");
                }
                else if(address.equals("")){
                    JOptionPane.showMessageDialog(null,"Please Insert data!!");
                }
                else {
                    DbConnect db = new DbConnect();
                    String queryInsert = "INSERT INTO `registration`( `name`, `email`, `pass`, `phone`, `address`) VALUES ('"+userName+"','"+email+"'," +
                            "'"+Pass+"','"+mobile+"','"+address+"')";
                    db.RegisterInsert(queryInsert);
                }

            }
        });









        setVisible(true);

    }
}




