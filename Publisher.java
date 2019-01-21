package chatroom;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class Publisher extends Thread{
    private int port;
    private String ip;

    public Publisher(String ip, int port){
        this.port = port;
        this.ip = ip;
    }

    public void run(){
        try {
            BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
            String content = null;
            System.out.println("You can start chatting.");
            while(true){
                if ((content = in.readLine()) != null) {
                    Socket socket = new Socket(ip, port);
                    DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                    out.writeUTF(content);
                    socket.close();
                }
            }    
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
    }
}