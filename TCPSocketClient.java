import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;


/** @noinspection InfiniteLoopStatement*/
public class TCPSocketClient {
    public static void main(String [] args) throws IOException {
        //create a socket and handle the IOException
        //localhost because server and client are on the same machine
        Socket sk = new Socket("localhost", 9999);

        //create a data output stream converts raw data from client to server into streams
        //pass the socket object to send the data
        //buffer reader takes input from the  user
        DataOutputStream dout = new DataOutputStream(sk.getOutputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            //while loop will allow data to be sent continuously between client and server
            String userInput = br.readLine(); // take user input
            dout.writeUTF(userInput); //write user input into the stream object
            if (userInput.equalsIgnoreCase("exit")){
                break;
            }
            //close the socket
            sk.close();
        }
    }
}