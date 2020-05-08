package EXAM.Frame;

import EXAM.data.User;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Authorization extends JPanel {
    private JLabel log;
    private JLabel par;
    private JTextField logf;
    private JTextField parf;
    private JButton exit, enter;
    private BossFrame frame;


    public Authorization(BossFrame frame){
        this.frame=frame;

        setSize(800,600);
        setLayout(null);

        log=new JLabel("Login");
        log.setBounds(250,150,100,25);
        add(log);

        par=new JLabel("Password");
        par.setBounds(250,200 ,100,25);
        add(par);

        logf=new JTextField("");
        logf.setBounds(350,150,100,25);
        add(logf);

        parf=new JPasswordField("");
        parf.setBounds(350,200,100,25);
        add(parf);

        exit=new JButton("BACK");
        exit.setBounds(250,250,100,25);
        add(exit);

        enter=new JButton("ENTER");
        enter.setBounds(375,250,100,25);
        add(enter);

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.authorization.setVisible(false);
                frame.login.setVisible(true);
            }
        });

        enter.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if(logf.getText().isEmpty() || parf.getText().isEmpty()){
                    JOptionPane.showMessageDialog(frame, "Fill all fields");
                }
                else{
                    User u = new User();
                    u.setLogin(logf.getText());
                    u.setPassword(parf.getText());

                    User authUser = frame.client.login(u);
                    if(authUser != null){
                       // JOptionPane.showMessageDialog(frame, "You are Logged in");
                        logf.setText("");
                        parf.setText("");

                        frame.authorization.setVisible(false);
                        frame.window1.setVisible(true);

//                        if(authUser.getRole().equals("ADMIN")){
//                            //go to AddBookPage
//                        }
//                        else{
//                            //go to ListBookPage
//                        }
                    }
                    else
                        JOptionPane.showMessageDialog(frame, "Incorrect login or password");
                }

            }
        });
    }
}
