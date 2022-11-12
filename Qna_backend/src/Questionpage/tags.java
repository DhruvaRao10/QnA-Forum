/*package Questionpage;
import main.AppServer;
import request.AppRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;


public class tags {
    static String hostname = "127.0.0.1";
    static int port = 3000;
    static ObjectOutputStream tagoutputstream;
    static ObjectInputStream taginputstream;


    public static void main(String[] args) {
        try{
            Socket questionsocket=new Socket(hostname,port);
            tagoutputstream = new ObjectOutputStream(questionsocket.getOutputStream());
            taginputstream =  new ObjectInputStream(questionsocket.getInputStream());
            System.out.println("Connected to the server");


        } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        public static void sendtagrequest(AppRequest  request);
        {
            try{
                tagoutputstream.writeObject(request);
                tagoutputstream.flush();;
                System.out.println("Question request sent to the server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Object gettagresponse(){
            try{
                System.out.println("Waiting for response");

                return taginputstream.readObject();
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }



    }


}




}
*/