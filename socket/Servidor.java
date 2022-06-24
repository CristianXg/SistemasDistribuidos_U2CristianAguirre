import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.io.ObjectOutputStream;

public class Servidor{
    static ServerSocket server;
    static int port = 5000;
    static int port2 = 4000;

    static String host = "127.0.0.1";
    public static void main(String args[])throws IOException, ClassNotFoundException{ 
        server = new ServerSocket(port);
        
        while(true){
            System.out.println("Servidor en Linea");
            Socket socket = server.accept();
            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            String message = (String)ois.readObject();
            ois.close();
            System.out.println("Mensaje recivido desde el Cliente: " + message);

            System.out.println("Inicializando el socket para comunicarnos");
            Socket socketServer = new Socket(host, port2);
            ObjectOutputStream oos = new ObjectOutputStream(socketServer.getOutputStream());
            oos.writeObject("Hola soy el Servidor");
            socket.close();
            
            socketServer.close();
        }
        //server.close();
    }
}