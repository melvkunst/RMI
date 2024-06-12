import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = new ContaBancariaImpl();
           Registry registry = LocateRegistry.createRegistry(1099);
            registry.rebind("ContaBancaria", conta);
            System.out.println("Servidor pronto.");
        } catch (Exception e) {
            System.err.println("Exceção no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
