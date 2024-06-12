import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Obtém a referência ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            // Procura pelo objeto remoto "ContaBancaria"
            ContaBancaria conta = (ContaBancaria) registry.lookup("ContaBancaria");

            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("Escolha uma opção: ");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Ver Saldo");
                System.out.println("4. Sair");
                
                int opcao = scanner.nextInt();

                switch (opcao) {
                    case 1:
                        System.out.print("Digite o valor para depositar: ");
                        double valorDeposito = scanner.nextDouble();
                        conta.deposita(valorDeposito);
                        System.out.println("Saldo após depósito: " + conta.saldo());
                        break;
                    case 2:
                        System.out.print("Digite o valor para retirar: ");
                        double valorRetirada = scanner.nextDouble();
                        conta.retira(valorRetirada);
                        System.out.println("Saldo após retirada: " + conta.saldo());
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + conta.saldo());
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opção inválida.");
                        break;
                }
            }

            scanner.close();
        } catch (Exception e) {
            System.err.println("Exceção no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
