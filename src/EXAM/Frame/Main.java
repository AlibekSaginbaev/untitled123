package EXAM.Frame;

import EXAM.data.User;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        BossFrame frame=new BossFrame();
        frame.setVisible(true);

    }
}
