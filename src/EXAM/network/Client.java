package EXAM.network;

import EXAM.data.Packet;
import EXAM.data.Question;
import EXAM.data.User;
import com.sun.jdi.event.ExceptionEvent;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;

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

    public boolean Profile(User user){
        String str="";
        try {
            Packet packet=new Packet("Profile");
            oos.writeObject(packet);

            Packet answerPacket= (Packet) ois.readObject();
            str=answerPacket.getCode();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        if(str.equals("ANSWER"))
            return true;
        return false;
    }

    public User getInfoStudent(){
        User users=null;
        Packet packet=new Packet("GET_INFO",null);
        try{
            oos.writeObject(packet);
            Packet packet1=(Packet)ois.readObject();
            users=(User) packet1.getInfo();
        }
        catch (Exception e){e.printStackTrace();}
        return users;
    }

    public Question getQuestion(){
        Question question=null;
        Packet packet=new Packet("GET_QUES",null);
        try{
            oos.writeObject(packet);
            Packet packet1=(Packet) ois.readObject();
            question=(Question)packet1.getInfo();
        }catch (Exception e){e.printStackTrace();}
        return question;
    }

}
