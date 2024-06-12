import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            ContaBancaria conta = new ContaBancariaImpl();
           // Cria e exporta o registro na porta 1099
            LocateRegistry.createRegistry(1100);
            
            // Registra a conta bancária no registro RMI usando Naming.rebind
            Naming.rebind("rmi://localhost:1100/ContaBancaria", conta);
            System.out.println("Servidor pronto.");
        } catch (Exception e) {
            System.err.println("Exceção no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
