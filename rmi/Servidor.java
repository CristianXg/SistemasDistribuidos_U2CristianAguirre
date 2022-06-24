import java.rmi.Naming;

public class Servidor {
    public Servidor(){
        try{
            InterfazRMI objetoD = new ImplementacionRMI();
            Naming.rebind("rmi://localhost/oyente", objetoD);
        }catch(Exception ex){
        }
    }
    public static void main(String[] args) {
        new Servidor();
    }
}
