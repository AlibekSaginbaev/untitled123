package EXAM.network;

import EXAM.data.Packet;
import EXAM.data.Question;
import EXAM.data.User;
import com.sun.jdi.event.ExceptionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Client {
    private Socket socket=null;
    private ObjectOutputStream oos=null;
    private ObjectInputStream ois=null;

    public Client(){
        try {
            socket = new Socket("localhost", 1999);
            oos = new ObjectOutputStream(socket.getOutputStream());
            ois = new ObjectInputStream(socket.getInputStream());
        }
        catch (Exception e){e.printStackTrace();}
    }

    public void interrupt(){
        try{
            oos.close();
            ois.close();
            socket.close();
        }
        catch (Exception e){e.printStackTrace();}
    }

    public boolean registr(User user){
        String str="";

        try{
            Packet packet=new Packet("REG", user);
            oos.writeObject(packet);

            Packet pc=(Packet)ois.readObject();
            str=pc.getCode();
        }

        catch (Exception e){e.printStackTrace();}

        if(str.equals("SUCCESS"))
            return true;

        return false;
    }
    public User login(User user){
        User authorization = null;
        try{
            Packet packet = new Packet("LOGIN", user);
            oos.writeObject(packet);

            Packet answerPacket = (Packet)ois.readObject();
            authorization = (User)answerPacket.getInfo();
        }
        catch(Exception e){e.printStackTrace();}

        return authorization;
    }

    public boolean question(Question question){
        String str="";

        try{
            Packet packet=new Packet("QUESTION", question);
            oos.writeObject(packet);

            Packet pc=(Packet)ois.readObject();
            str=pc.getCode();
        }

        catch (Exception e){e.printStackTrace();}

        if(str.equals("SUCCESS"))
            return true;

        return false;
    }


//    public ArrayList<Question> getQuestion(){
//        ArrayList<Question> question=new ArrayList<>();
//        Packet packet=new Packet("GET_QUES");
//        try{
//            oos.writeObject(packet);
//            Packet packet1=(Packet) ois.readObject();
//            question=(ArrayList<Question>)packet1.getInfo();
//        }catch (Exception e){e.printStackTrace();}
//        return question;
//    }

    public User getAllUser(Long id){
        User user= null;
        Packet packet1= new Packet("GET_USER", id);
        try{
            oos.writeObject(packet1);
            Packet response= (Packet)ois.readObject();
            user= (User)response.getInfo();
        }catch (Exception e){e.printStackTrace();}
        return user;
    }

    public ArrayList<Question> getAllQuestion(){
        ArrayList<Question> question= null;
        Packet packet1= new Packet("GET_QUESTIONS");
        try{
            oos.writeObject(packet1);
            Packet response= (Packet)ois.readObject();
            question= (ArrayList<Question>) response.getInfo();
        }catch (Exception e){e.printStackTrace();}
        return question;
    }


}
