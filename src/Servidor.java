import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            // Cria uma instância da conta bancária
            ContaBancaria conta = new ContaBancariaImpl();
            
            // Cria e exporta o registro na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);
            
            // Registra a conta bancária no registro RMI
            registry.rebind("ContaBancaria", conta);
            
            System.out.println("Servidor pronto.");
        } catch (Exception e) {
            System.err.println("Exceção no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
