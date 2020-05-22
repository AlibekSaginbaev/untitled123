package EXAM.network;


import EXAM.data.Packet;
import EXAM.data.Question;
import EXAM.data.User;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class ServerThread extends Thread {
    private Socket socket;
    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Packet packet = null;

            while ((packet = (Packet) ois.readObject()) != null) {
                if (packet.getCode().equals("REG")) {
                    User user = (User) packet.getInfo();
                    boolean reged = Server.toRegister(user);

                    Packet packet2 = null;

                    if (reged == true)
                        packet2 = new Packet("SUCCESS");
                    else
                        packet2 = new Packet("FAIL");

                    oos.writeObject(packet2);
                } else if (packet.getCode().equals("LOGIN")) {
                    User user = (User) packet.getInfo();
                    User authUser = Server.toLogin(user);

                    Packet packet2 = new Packet("ANSWER", authUser);
                    oos.writeObject(packet2);
                } else if (packet.getCode().equals("QUESTION")) {
                    Question question = (Question) packet.getInfo();
                    boolean quest = Server.toWriteQuestion(question);

                    Packet packet2 = null;

                    if (quest == true)
                        packet2 = new Packet("SUCCESS");
                    else
                        packet2 = new Packet("FAIL");

                    oos.writeObject(packet2);
                }
                else if(packet.getCode().equals("GET_USER")) {
                    Packet packet2 = new Packet("ANSWER_LIST", Server.getUser((Long) packet.getInfo()));
                    oos.writeObject(packet2);
                }
                else if(packet.getCode().equals("GET_QUESTIONS")) {
                    Packet packet2 = new Packet("ANSWER_LIST", Server.question());
                    oos.writeObject(packet2);
                }

//                if(packet.getCode().equals("GET_QUES")){
//                    //Question question=(Question) packet.getInfo();
//                    //Question question1=Server.getQuestions();
//                    ArrayList<Question> question1=Server.getQuestions();
//                    Packet packet1=new Packet("ANSWER",question1);
//                    oos.writeObject(packet1);
//                }
             }

            ois.close();
            oos.close();
        }
        catch(Exception ignored){}
    }
        }

