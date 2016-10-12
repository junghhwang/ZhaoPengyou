package client;

import java.io.DataOutputStream;
import java.net.Socket;

/**
 * Created by solmoms on 10/11/2016.
 */
public class ZhaoDriver {

    public static void main(String [] args) {
        try{
            Socket socket=new Socket("localhost",4444);
            DataOutputStream dataOutputStream=new DataOutputStream(socket.getOutputStream());
            dataOutputStream.writeUTF("Hello");
            dataOutputStream.flush();
            while(isDone()) {

            }
            dataOutputStream.close();
            socket.close();
        }catch(Exception e){
            e.printStackTrace();}

    }

    public static boolean isDone() {
        // NEEDS TO BE FIXED
        return true;
    }
}
