import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Servidor {
    public static void main(String[] args) {
        try {
            //Cria uma instância do objeto remoto ContaBancariaImpl
            ContaBancaria conta = new ContaBancariaImpl();

            //Cria e exporta o registro RMI na porta 1099
            Registry registry = LocateRegistry.createRegistry(1099);

            //Liga o nome "ContaBancaria" ao objeto remoto conta no registro RMI
            registry.rebind("ContaBancaria", conta);

            //Mostra quando o servidor está pronto para receber conexões
            System.out.println("Servidor pronto.");
        } catch (Exception e) {
            System.err.println("Excecao no Servidor: " + e.toString());
            e.printStackTrace();
        }
    }
}
