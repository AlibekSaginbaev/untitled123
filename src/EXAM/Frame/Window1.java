package EXAM.Frame;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;

public class Window1 extends JPanel {
    private JButton Profile;
    private JComboBox Subject;
    private JLabel subj;
    private JLabel welcome;
    private String subjects[]={"","Math","Proga"};
    private JButton exit,start;
    private JButton asd;
    private BossFrame frame;


    public Window1(BossFrame frame){
        this.frame=frame;

        setSize(800,600);
//        setTitle("");
//        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);

        Profile=new JButton("Profile");
        Profile.setBounds(300,150,100,25);
        add(Profile);

        Subject=new JComboBox(subjects);
        Subject.setBounds(375,200,100,25);
        add(Subject);

        subj=new JLabel("Choose a subject ");
        subj.setBounds(250,200,150,25);
        add(subj);

        start=new JButton("START");
        start.setBounds(300,250,100,25);
        add(start);

        welcome=new JLabel();
        welcome.setBounds(250,100,200,25);
        add(welcome);
     //   welcome.setText(Registration.namewl);

        exit=new JButton("EXIT");
        exit.setBounds(300,300,100,25);
        add(exit);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.window1.setVisible(false);
                frame.test.setVisible(true);
            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

        Profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.window1.setVisible(false);
                frame.profile.setVisible(true);


            }
        });

//        asd=new JButton();
//        asd.setBounds(410,300,100,25);
//        add(asd);
//
//        asd.addActionListener(new ActionListener() {
//            @Override
//            public void actionPerformed(ActionEvent e) {
//                String all="";
//                all=Main.user.toString();
//                welcome.setText(all);
//            }
//        });
    }
}
