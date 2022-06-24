import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.ServerSocket;

public class Cliente{
    static String host = "127.0.0.1";
    static int port = 5000;

    static int port2 = 4000;

    static ServerSocket serverCliente;
    public static void main(String args[])throws IOException, ClassNotFoundException{ 
        serverCliente = new ServerSocket(port2);

        System.out.println("Inicializando el socket para comunicarnos");
        Socket socket = new Socket(host, port);
        ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
        oos.writeObject("Hola soy el Cliente");

        System.out.println("Servidor en Linea");
        Socket socketRecive = serverCliente.accept();
        ObjectInputStream ois = new ObjectInputStream(socketRecive.getInputStream());
        String message = (String)ois.readObject();
        ois.close();
        socket.close();
        System.out.println("Mensaje recivido desde el Servidor: " + message);

        serverCliente.close();
    }
}