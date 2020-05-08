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

    public static User Profile(User user){
        User profile=null;
        try {
            PreparedStatement preparedStatement=connection.prepareStatement("SELECT * FROM users");
            ResultSet rs=preparedStatement.executeQuery();

            ArrayList<User> users = new ArrayList<>();

            while(rs.next()){
                profile=new User();
                user.setId(rs.getLong("id"));
                user.setLogin(rs.getString("login"));
                user.setPassword(rs.getString("password"));
                user.setName(rs.getString("name"));
                user.setRole(rs.getString("role"));

                users.add(user);
            }
            preparedStatement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return profile;

    }

    public static ArrayList<User> getInfoStud(){
        ArrayList<User> users=new ArrayList<>();
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM users");
            ResultSet resultSet=statement.executeQuery();

            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String login=resultSet.getString("login");
                String name=resultSet.getString("name");
                String surname=resultSet.getString("surname");
                users.add(new User(id, login,name, surname));
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return users;
    }
    public static Question getQuestions(){
        Question question= null;
        try {
            PreparedStatement statement=connection.prepareStatement("SELECT * FROM math ");
            ResultSet resultSet=statement.executeQuery();
            while(resultSet.next()){
                Long id=resultSet.getLong("id");
                String questionArea=resultSet.getString("question");
                ArrayList<String> answ=new ArrayList<>();
                String answ1=resultSet.getString("answ1");
                String answ2=resultSet.getString("answ2");
                String answ3=resultSet.getString("answ3");
                String answ4=resultSet.getString("answ4");
                answ.add(answ1);
                answ.add(answ2);
                answ.add(answ3);
                answ.add(answ4);
                Integer subj=resultSet.getInt("subjId");

                question=new Question(id, questionArea, answ1,answ);
            }
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return question;
    }

}
