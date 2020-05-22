package EXAM.Frame;

import EXAM.data.Question;
import EXAM.network.Server;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Queue;

public class Window1 extends JPanel {
    private JButton Profile;
    private JComboBox Subject;
    private JLabel subj;
    private JLabel welcome;
    private String subjects[]={"","Math"};
    private JButton exit,start;
    private JButton asd;
    private BossFrame frame;

    public Integer result=0;

    ArrayList<Question> questions=null;

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

        welcome=new JLabel("");
        welcome.setBounds(250,100,200,25);
        add(welcome);
//        welcome.setText(frame.currentUser.getName());

        exit=new JButton("EXIT");
        exit.setBounds(300,300,100,25);
        add(exit);

        start.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.window1.setVisible(false);
                frame.test.setVisible(true);

                questions=frame.client.getAllQuestion();
                frame.test.showQuestions(questions, questions.get(frame.test.currentQuestionIndex).getAnsw1(),
                        questions.get(frame.test.currentQuestionIndex).getAnsw2(),
                        questions.get(frame.test.currentQuestionIndex).getAnsw3(),
                        questions.get(frame.test.currentQuestionIndex).getAnsw4());
//                for(int i=0;i<questions.size();i++){
//                    sort(questions.get(i).getAnsw1(),questions.get(i).getAnsw2(),questions.get(i).getAnsw3(),questions.get(i).getAnsw4());
//                    if(questions.get(i).isAnsweredRight())
//                        result++;
//
//                }


            }
        });

        exit.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.window1.setVisible(false);
                frame.login.setVisible(true);
            }
        });

        Profile.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                frame.window1.setVisible(false);
                frame.profile.setVisible(true);


            }
        });


    }

    public void updateData(){
        welcome.setText("Welcome "+frame.currentUser.getName());
    }

//    public void sort(String answ1, String answ2, String answ3, String answ4){
//        ArrayList<String> list = new ArrayList<>();
//        list.add(answ1);
//        list.add(answ2);
//        list.add(answ3);
//        list.add(answ4);
//
//        Collections.shuffle(list);
//    }
}
