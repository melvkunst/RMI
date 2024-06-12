import java.rmi.Naming;
// import java.rmi.registry.LocateRegistry;
// import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            // Procura pelo objeto remoto "ContaBancaria" usando Naming.lookup
            ContaBancaria conta = (ContaBancaria) Naming.lookup("rmi://localhost:1100/ContaBancaria");
            Scanner scanner = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                System.out.println("Escolha uma opcao: ");
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
                        System.out.println("Saldo apos deposito: " + conta.saldo());
                        break;
                    case 2:
                        System.out.print("Digite o valor para retirar: ");
                        double valorRetirada = scanner.nextDouble();
                        conta.retira(valorRetirada);
                        System.out.println("Saldo apos retirada: " + conta.saldo());
                        break;
                    case 3:
                        System.out.println("Saldo atual: " + conta.saldo());
                        break;
                    case 4:
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcao invalida.");
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
