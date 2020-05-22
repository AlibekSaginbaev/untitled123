package EXAM.Frame;

import EXAM.data.Question;
import EXAM.network.Client;
import EXAM.network.Server;

import javax.swing.*;
import java.util.ArrayList;

public class BossFrame extends JFrame {
    public Login login;
    public Window1 window1;
    public Authorization authorization;
    public Registration registration;
    public Profile profile;
    public Test test;
    public Client client;
    public AdminPage adminPage;

    public BossFrame(){
        client=new Client();

        setSize(800,600);
        setTitle("Test");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(null);
        setVisible(true);

        login=new Login(this);
        login.setVisible(true);
        add(login);

        window1=new Window1(this);
        window1.setVisible(false);
        add(window1);

        authorization=new Authorization(this);
        authorization.setVisible(false);
        add(authorization);

        registration=new Registration(this);
        registration.setVisible(false);
        add(registration);

        profile=new Profile(this);
        profile.setVisible(false);
        add(profile);

        adminPage= new AdminPage(this);
        adminPage.setVisible(false);
        add(adminPage);

        test=new Test();
        test.setVisible(false);
        add(test);

        ArrayList<Question> list= Server.getQuestions();
        test.showQuestions(list);


    }
}
