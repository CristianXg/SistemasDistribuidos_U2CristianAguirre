import java.rmi.Naming;
import java.io.InputStreamReader;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try{
            InterfazRMI interfaz =(InterfazRMI)Naming.lookup("rmi://localhost/saludo");
            System.out.println(interfaz.saludar("Hola MUNDO RMI"));
        }catch(Exception ex){
        }
    }
}
