package amio;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DocInformation extends JFrame {

    JLabel title, l1,l2,l3,l4,l5,l6,l7,l8;
    JTextField t1,t2,t3,t4,t5,t6,t7,t8;
    JPanel p1,p2;
    JButton add;


    DocInformation(){
        setSize(590,750);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setLayout(null);
        setTitle("**//DOCTOR DESCRIPTION//**");

        Font f = new Font("Arial",Font.BOLD,19);
        Font f1 = new Font("Arial",Font.BOLD,28);

        p1 = new JPanel();
        p1.setBounds(0,0,590,80);
        p1.setBackground(Color.green);
        p1.setLayout(null);
        add(p1);

        p2 = new JPanel();
        p2.setBounds(0,110,590,690);
        p2.setBackground(Color.YELLOW);
        p2.setLayout(null);
        add(p2);

        title = new JLabel("**// DOCTORS DESCRIPTION //**");
        title.setBounds(150,30,350,40);
        title.setFont(f);
        p1.add(title);

        l1 = new JLabel("DocID");
        l2 = new JLabel("DocName ");
        l3 = new JLabel("Age ");
        l4 = new JLabel("Visiting time");
        l5 = new JLabel("Visiting days  ");
        l6 = new JLabel("Mobile ");
        l7 = new JLabel("City ");
        l8 = new JLabel("Address");

        l1.setBounds(70,40,300,30);
        l1.setFont(f1);
        p2.add(l1);

        l2.setBounds(20,110,200,20);
        l2.setFont(f);
        p2.add(l2);

        l3.setBounds(20,150,210,30);
        l3.setFont(f);
        p2.add(l3);

        l4.setBounds(20,200,200,30);
        l4.setFont(f);
        p2.add(l4);

        l5.setBounds(20,240,300,40);
        l5.setFont(f);
        p2.add(l5);

        l6.setBounds(20,290,200,20);
        l6.setFont(f);
        p2.add(l6);

        l7.setBounds(20,340,200,20);
        l7.setFont(f);
        p2.add(l7);

        l8.setBounds(20,400,200,20);
        l8.setFont(f);
        p2.add(l8);

        t1 = new JTextField();
        t2 = new JTextField();
        t3 = new JTextField();
        t4 = new JTextField();
        t5 = new JTextField();
        t6 = new JTextField();
        t7 = new JTextField();
        t8 = new JTextField();

        t1.setBounds(190,40,80,40);
        t1.setFont(f);
        p2.add(t1);

        t2.setBounds(200,110,300,30);
        t2.setFont(f);
        p2.add(t2);

        t3.setBounds(200,150,300,30);
        t3.setFont(f);
        p2.add(t3);

        t4.setBounds(200,200,300,30);
        t4.setFont(f);
        p2.add(t4);

        t5.setBounds(200,240,300,30);
        t5.setFont(f);
        p2.add(t5);

        t6.setBounds(200,290,300,30);
        t6.setFont(f);
        p2.add(t6);

        t7.setBounds(200,340,300,30);
        t7.setFont(f);
        p2.add(t7);

        t8.setBounds(200,400,300,40);
        t8.setFont(f);
        p2.add(t8);

        add = new JButton("UPDATE");

        add.setBounds(230,480,140,60);
        add.setFont(f);
        add.setForeground(Color.WHITE);
        add.setBackground(Color.BLACK);
        add.setFocusable(false);
        p2.add(add);

        add.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String doctorId = t1.getText();
                String doctorName = t2.getText();
                String age = t3.getText();
                String visitingTime = t4.getText();
                String visitingDays = t5.getText();
                String mobile = t6.getText();
                String city = t7.getText();
                String address = t8.getText();

                DbConnect db = new DbConnect();
                String queryInsert = "INSERT INTO `docinfo`( `doctorName`, `age`, `visitingTime`, `visitingDays`, `phone`, `city`, `address`) VALUES ('"+doctorName+"','"+age+"','"+visitingTime+"','"+visitingDays+"','"+mobile+"','"+city+"','"+address+"')";
                db.RegisterInsert(queryInsert);
            }
        });





















        setVisible(true);

    }
}
