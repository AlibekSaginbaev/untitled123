package EXAM.Frame;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Login extends JPanel {
    private JButton Registration;
    private JButton Authorization;
    private JButton Exit;
    private JLabel welcome;
    private JLabel time;
    private BossFrame frame;


    public Login(BossFrame frame){
        this.frame=frame;


        setSize(800,600);
        Font f1=new Font(Font.SERIF,Font.BOLD,50);
//        setTitle("");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        welcome=new JLabel("WELCOME");
        welcome.setFont(f1);
        welcome.setForeground(Color.red);
        welcome.setBounds(200,100,400,100);
        add(welcome);

        Registration= new JButton("Registration");
        Registration.setBounds(250,250,150,25);
        add(Registration);

        Authorization=new JButton("Authorization");
        Authorization.setBounds(250,290,150,25);
        add(Authorization);

        Exit=new JButton("EXIT");
        Exit.setBounds(250,330,150,25);
        add(Exit);

        Exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Registration.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.login.setVisible(false);
                frame.registration.setVisible(true);
            }
        });

        Authorization.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.login.setVisible(false);
                frame.authorization.setVisible(true);
            }
        });

        Calendar calendar=new GregorianCalendar();
        SimpleDateFormat formattedDate= new SimpleDateFormat("dd.MM.yyyy");
        String dateToday = formattedDate.format(calendar.getTime());

        time = new JLabel(dateToday);
        time.setBounds(700,10,80,50);
        add(time);


    }
}
