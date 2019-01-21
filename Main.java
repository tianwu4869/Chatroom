package chatroom;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main{
    public static void main(String[] args) {
        Listener listener = new Listener();
        listener.start();
        String ip = null, port = null;
        while(true){
            if (listener.isReady()) {
                System.out.println("Allocated with port " + listener.getPort() + ".");
                break;
            }
            else{
                System.out.print("");
            }
        }
        try {
            System.out.print("Type in the IP address of the receiver: ");
            BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
            ip = br.readLine();
            System.out.print("Type in the port of the receiver: ");
            port = br.readLine();
        } catch (IOException e) {
            //TODO: handle exception
            e.printStackTrace();
        }
        new Publisher(ip, Integer.parseInt(port)).start();
    }
}