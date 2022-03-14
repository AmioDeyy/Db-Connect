package amio;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TableOp extends JFrame {
    JPanel TPanel,OPanel;
    JTable table;
    JTextField serialTxt, nameTxt,idTxt;
    JButton addBtn,delBtn,updateBtn;
    DefaultTableModel model;

    String serial,name,id;

    TableOp(){

        setSize(500,580);
        setTitle("Information table");
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        TPanel = new JPanel();
        TPanel.setBounds(0,0,580,290);
        TPanel.setBackground(Color.LIGHT_GRAY);
        TPanel.setLayout(null);
        add(TPanel);

        OPanel = new JPanel();
        OPanel.setBounds(0,300,580,290);
        OPanel.setBackground(Color. yellow);
        OPanel.setLayout(null);
        add(OPanel);

        Object data[][] = {{"1","amio","268"},{"2","rishad","264"},{"3","sujoy","269"},{"4","rafi","259"}};
        String coloumnNames[] = {"serial","names","id"};

        model = new DefaultTableModel(data,coloumnNames);

        table = new JTable(model);
        JScrollPane sp = new JScrollPane(table);
        sp.setBounds(10,10,450,290);
        TPanel.add(sp);

        serialTxt = new JTextField("serial");
        serialTxt.setBounds(130,30,200,20);
        OPanel.add(serialTxt);

        nameTxt = new JTextField("name");
        nameTxt.setBounds(130,70,200,20);
        OPanel.add(nameTxt);

        idTxt = new JTextField("id");
        idTxt.setBounds(130,100,200,20);
        OPanel.add(idTxt);

        addBtn = new JButton("Add");
        addBtn.setBounds(50,170,80,40);
        OPanel.add(addBtn);

        updateBtn = new JButton("Update");
        updateBtn.setBounds(200,170,80,40);
        OPanel.add(updateBtn);

        delBtn = new JButton("Delete");
        delBtn.setBounds(350,170,80,40);
        OPanel.add(delBtn);

        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                serial = serialTxt.getText();
                name = nameTxt.getText();
                id = idTxt.getText();

                Object newRow[] = {serial,name,id};
                model.addRow(newRow);
            }
        });


        table.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                super.mouseClicked(e);
                int rowIndex = table.getSelectedRow();
//              System.out.println(rowIndex);

                serial = (String) model.getValueAt(rowIndex,0);
                name = (String) model.getValueAt(rowIndex,1);
                id = (String) model.getValueAt(rowIndex,2);

                serialTxt.setText(serial);
                nameTxt.setText(name);
                idTxt.setText(id);
            }
        });
      updateBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              serial = serialTxt.getText();
              name = nameTxt.getText();
              id = idTxt.getText();

              int row = table.getSelectedRow();
              model.setValueAt(serial,row,0);
              model.setValueAt(name,row,1);
              model.setValueAt(id,row,2);

          }
      });
      delBtn.addActionListener(new ActionListener() {
          @Override
          public void actionPerformed(ActionEvent e) {
              model.removeRow(table.getSelectedRow());
          }
      });


        setVisible(true);
    }
}
