/*package Questionpage;
import main.AppServer;
import request.AppRequest;

import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.io.IOException;


public class questions extends AppServer  {
    static String hostname = "127.0.0.1";
    static int port = 3000;
    static ObjectOutputStream questionoutputstream;
    static ObjectInputStream questioninputstream;

    public static void main(String[] args) {
        try{
        Socket questionsocket=new Socket(hostname,port);
        questionoutputstream = new ObjectOutputStream(questionsocket.getOutputStream());
        questioninputstream =  new ObjectInputStream(questionsocket.getInputStream());
            System.out.println("Connected to the server");


    } catch (UnknownHostException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        public static void sendquestionrequest(AppRequest  request);
        {
            try{
                 questionoutputstream.writeObject(request);
                 questionoutputstream.flush();;
                System.out.println("Question request sent to the server");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        public static Object getquestionresponse(){
            try{
                System.out.println("Waiting for response");

                return questioninputstream.readObject();
            }catch(IOException | ClassNotFoundException e){
                e.printStackTrace();
            }
        }



    }


}
*/