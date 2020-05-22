package EXAM.network;

import EXAM.data.Question;
import EXAM.data.User;
import EXAM.network.ServerThread;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.*;
import java.util.ArrayList;

public class Server {
    public static Connection connection;

    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/exam?useUnicode=true&serverTimezone=UTC","root", "");
            ServerSocket ss = new ServerSocket(1999);

            while(true){
                Socket s = ss.accept();
                ServerThread st = new ServerThread(s);
                st.start();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean toRegister(User user){
        int rows = 0;

        try{
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users (id, login, password, name, surname, role) VALUES (null, ?,?, ?, ?, ?)");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());
            statement.setString(3, user.getName());
            statement.setString(4,user.getSurname());
            statement.setString(5, "USER");

            rows = statement.executeUpdate();
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        if(rows == 1)
            return true;

        return false;
    }

    public static User toLogin(User user){
        User authorization = null;

        try{
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE login = ? AND password = ?");
            statement.setString(1, user.getLogin());
            statement.setString(2, user.getPassword());

            ResultSet rs = statement.executeQuery();

            if(rs.next()){
                authorization = new User(
                        rs.getLong("id"),
                        rs.getString("login"),
                        rs.getString("password"),
                        rs.getString("name"),
                        rs.getString("surname"),
                        rs.getString("role")
                );
            }
            statement.close();
        }
        catch(Exception e){e.printStackTrace();}

        return authorization;
    }

    public static boolean toWriteQuestion(Question question){
        int rows=0;
        try{
            PreparedStatement statement= connection.prepareStatement("INSERT INTO math (id, question, answ1, answ2, answ3, answ4) VALUES (null, ?,?,?,?,?)");
            statement.setString(1,question.getQuestion());
            statement.setString(2,question.getAnsw1());
            statement.setString(3,question.getAnsw2());
            statement.setString(4,question.getAnsw3());
            statement.setString(5,question.getAnsw4());

            rows = statement.executeUpdate();
            statement.close();
        }
        catch (Exception e){e.printStackTrace();}

        if(rows == 1)
            return true;
         return  false;
    }



//    public static ArrayList<Question> getQuestions(){
//        ArrayList<Question> questions= new ArrayList<>() ;
//        try {
//            PreparedStatement statement=connection.prepareStatement("SELECT * FROM math ");
//            ResultSet resultSet=statement.executeQuery();
//            while(resultSet.next()){
//                Long id=resultSet.getLong("id");
//                String questionArea=resultSet.getString("question");
//
//                String answ1=resultSet.getString("answ1");
//                String answ2=resultSet.getString("answ2");
//                String answ3=resultSet.getString("answ3");
//                String answ4=resultSet.getString("answ4");
//
//
//                questions.add(new Question(id, questionArea, answ1,answ1,answ2,answ3,answ4));
//            }
//            statement.close();
//        } catch (SQLException e) {
//            e.printStackTrace();
//        }
//        return questions;
//    }
    public static User getUser(Long idd){
        User user=new User();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users WHERE id=?");
            statement.setLong(1, idd);
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String login=resultSet.getString("login");
                String password= resultSet.getString("password");
                String name= resultSet.getString("name");
                String surname= resultSet.getString("surname");
                String role= resultSet.getString("role");

                user= new User(id, login, password, name,surname,role);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return user;
    }

    public static ArrayList<Question> question(){
        ArrayList<Question> questions=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM math ");
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String question=resultSet.getString("question");
                String answ1=resultSet.getString("answ1");
                String answ2=resultSet.getString("answ2");
                String answ3=resultSet.getString("answ3");
                String answ4=resultSet.getString("answ4");
                Integer subjectid=resultSet.getInt("subjectid");

                questions.add(new Question(id, question,answ1, answ1, answ2,answ3,answ4));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return questions;
    }

}
