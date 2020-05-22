package EXAM.Frame;

import EXAM.data.User;
import jdk.jshell.execution.JdiDefaultExecutionControl;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Profile extends JPanel {
    private JLabel main, name, surname, login;
    public static JTextArea namet, surnamet, logint;
    private JButton Back;
    private BossFrame frame;
    private JButton refresh;
    private JTable table;
    private Object columns[]={"SUBJECT", "RESULT"};
    private JScrollPane pane;
    private DefaultTableModel model;

    public Profile(BossFrame frame){
        this.frame=frame;

        setSize(800,600);
        setLayout(null);

        main=new JLabel("PROFILE");
        main.setBounds(25,25,100,25);
        add(main);

        name=new JLabel("Your name ");
        name.setBounds(25,75,100,25);
        add(name);

        surname=new JLabel("Your surname ");
        surname.setBounds(25,125,100,25);
        add(surname);

        login= new JLabel("Your login ");
        login.setBounds(25,175,100,25);
        add(login);

        namet=new JTextArea();
        namet.setBounds(125,75,100,25);
        add(namet);

        surnamet=new JTextArea();
        surnamet.setBounds(125,125,100,25);
        add(surnamet);

        logint=new JTextArea();
        logint.setBounds(125,175,100,25);
        add(logint);

        Back=new JButton("BACK");
        Back.setBounds(25,225,100,25);
        add(Back);

        refresh=new JButton("REFRESH");
        refresh.setBounds(130,225,100,25);
        add(refresh);
        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.profile.setVisible(false);
                frame.window1.setVisible(true);
            }
        });

        refresh.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

            }
        });

        table=new Table(columns);
        pane=new JScrollPane(table);
        pane.setBounds(300,25,300,400);
        add(pane);


    }

}
