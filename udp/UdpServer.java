import java.net.*;
public class UdpServer {
    public static void main(String[] args)throws Exception {
        DatagramSocket clientSocket = new DatagramSocket();

        byte[] receiveData = new byte[1024];
        byte[] sendData = new byte[1024];
        DatagramSocket serverSocket = new DatagramSocket(9876);

        while(true){
            System.out.println("SERVER ACTIVE");
            DatagramPacket receivePacket = new DatagramPacket(receiveData, receiveData.length);
            serverSocket.receive(receivePacket);
            String sentence = new String(receivePacket.getData());

            //++++++Envío mensaje
            InetAddress IPAddress = receivePacket.getAddress();
            int port = receivePacket.getPort();

            String capitalizedSentence = sentence.toUpperCase();
            sendData = capitalizedSentence.getBytes();

            DatagramPacket sendPacket = new DatagramPacket(sendData, sendData.length,IPAddress,port);
            serverSocket.send(sendPacket);

            System.out.println("MESSAGE: "+ sentence);
            System.out.println("SERVER OUT");
        }
    }
    
}
