import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;

public class TCPSocketServer {

    public static void main(String[] args) throws IOException {
        //create a server socket - takes port number as a paramenter
        ServerSocket svSk = new ServerSocket(9999);
        Socket sk = svSk.accept(); //allows the server to accept the connect
        System.out.println("Connected to Server");

        //create a data input stream to accept data from the client
        DataInputStream din = new DataInputStream(sk.getInputStream());
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        while(true){
            //allows us to keep getting the message as long as the client is broadcasting
            //read the data
            String dataIn = din.readUTF();
            System.out.println("client: "+dataIn);
            if (dataIn.equalsIgnoreCase("exit")){
                //close the socket
                sk.close();
                break;
            }

        }
    }


}