import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.*;
public class UdpClient {
    public static void main(String[] args)throws SocketException,IOException {
        DatagramSocket clientSocket = new DatagramSocket();
        BufferedReader inFromUser = new BufferedReader(new InputStreamReader(System.in));

        Inet4Address IPAddress = (Inet4Address)Inet4Address.getByName("127.0.0.1");
        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];

        System.out.println("Envío un dato al servidor");
        String sentence = inFromUser.readLine();
        sendData = sentence.getBytes();
        DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,9876);
        clientSocket.send(sendPacket);

        System.out.println("El puerto de envío es: "+ sendPacket.getPort());
        clientSocket = new DatagramSocket(9877);

        DatagramPacket receivePacket = new DatagramPacket(receiveData,receiveData.length);
        clientSocket.receive(receivePacket);
        String receiveSentence = new String(receivePacket.getData());
        
        System.out.println("Mensajes: "+receiveSentence);
        System.out.println("Client");  
    }  
}
