package EXAM.Frame;

import EXAM.data.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Registration extends JPanel {
//    public static String namewl;
    private JLabel log;
    private JLabel password;
    private JLabel name;
    private JLabel surname;
    private JTextField logf;
    private JTextField pasf;
    private JTextField namef;
    private JTextField surnamef;
    private JButton enter;
    private JButton Back;
    private BossFrame frame;

    public Registration(BossFrame frame){
        this.frame=frame;

        setSize(800,600);
        setLayout(null);

        log=new JLabel("Enter Login");
        log.setBounds(100,200,100,25);
        add(log);

        password=new JLabel("Enter password");
        password.setBounds(100,250,100,25);
        add(password);

        name=new JLabel("Enter name");
        name.setBounds(100,100,100,25);
        add(name);

        surname=new JLabel("Enter surname");
        surname.setBounds(100,150,100,25);
        add(surname);

        logf=new JTextField();
        logf.setBounds(250,200,100,25);
        add(logf);

        pasf=new JPasswordField();
        pasf.setBounds(250,250,100,25);
        add(pasf);

        namef=new JTextField();
        namef.setBounds(250,100,100,25);
        add(namef);

        surnamef=new JTextField();
        surnamef.setBounds(250,150,100,25);
        add(surnamef);

        enter=new JButton("REGISTRATION");
        enter.setBounds(300,300,150,25);
        add(enter);

        Back=new JButton("BACK");
        Back.setBounds(100,300,150,25);
        add(Back);

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                if(logf.getText().isEmpty() || pasf.getText().isEmpty() || surnamef.getText().isEmpty()
                || namef.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                }
                else{
                    User u = new User();
                    u.setLogin(logf.getText());
                    u.setName(namef.getText());
                    u.setPassword(pasf.getText());
                    u.setSurname(surnamef.getText());


                    boolean registered = frame.client.registr(u);
                    if(registered == true){
                        JOptionPane.showMessageDialog(frame, "You are registered");
                        namef.setText("");
                        surnamef.setText("");
                        logf.setText("");
                        pasf.setText("");

                        frame.registration.setVisible(false);
                        frame.window1.setVisible(true);
                    }
                }
            }
        });


        Back.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.registration.setVisible(false);
                frame.login.setVisible(true);
            }
        });
    }
}

