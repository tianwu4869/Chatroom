package chatroom;

import java.io.DataInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.IOException;


public class Listener extends Thread{
    private ServerSocket listen;
    private boolean ready;
    private int port;

    public Listener(){
        this.ready = false;
    }

    public boolean isReady(){
        return this.ready;
    }

    public int getPort(){
        return this.port;
    }

    public void run(){
        try {
            listen = new ServerSocket(0);
            this.port = listen.getLocalPort();
            this.ready = true;
            while(true){
                Socket opponent = listen.accept();
                DataInputStream in = new DataInputStream(opponent.getInputStream());
                System.out.println("Port " + opponent.getPort()+ ": " + in.readUTF());
            }
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}