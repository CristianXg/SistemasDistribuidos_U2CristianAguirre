import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
public class ImplementacionRMI extends UnicastRemoteObject implements InterfazRMI{
    public ImplementacionRMI() throws RemoteException{
        super();
    }
    public String saludar(String nombre) throws RemoteException{
        return "hola"+nombre;
    }
}
