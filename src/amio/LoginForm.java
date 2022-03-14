package amio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class LoginForm extends JFrame {

    JLabel l1,l2,l3;
    JPanel p1,p2;
    JTextField t1,t2;
    JButton b1,b2;


    LoginForm(){
        setSize(550,400);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setTitle("**Login InterFace**");

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

        l1 = new JLabel("** LogInFromInterface **");
        l2 = new JLabel("Name                :");
        l3 = new JLabel("Password        :");


        l1.setBounds(10,20,350,50);
        l1.setFont(f1);
        p1.add(l1);

        l2.setBounds(8,110,200,20);
        l2.setFont(f);
        p2.add(l2);

        l3.setBounds(8,170,230,20);
        l3.setFont(f);
        p2.add(l3);

        t1 = new JTextField();
        t2 = new JTextField();

        t1.setBounds(200,110,290,30);
        t1.setFont(f);
        p2.add(t1);

        t2.setBounds(200,170,290,30);
        t2.setFont(f);
        p2.add(t2);

        b1 = new JButton("Register");
        b2 = new JButton("Login");

        b1.setBounds(25,270,120,60);
        b1.setFont(f);
        b1.setForeground(Color.BLACK);
        b1.setBackground(Color.LIGHT_GRAY);
        p2.add(b1);

        b2.setBounds(370,270,120,60);
        b2.setFont(f);
        b2.setForeground(Color.BLACK);
        b2.setBackground(Color.LIGHT_GRAY);
        p2.add(b2);

        b1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                dispose();
                new RegistrationFom();
            }
        });
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String userName = t1.getText();
                String pass = t2.getText();

                DbConnect  db = new DbConnect();
                String queryLogin = "SELECT * FROM `registration`";
                db.Login(queryLogin,userName,pass);

            }
        });






        setVisible(true);


    }
}
