import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Scanner;

public class Cliente {
    public static void main(String[] args) {
        try {
            //Obtém a referência ao registro RMI
            Registry registry = LocateRegistry.getRegistry("localhost", 1099);
            
            //Procura pelo objeto remoto "ContaBancaria"
            ContaBancaria conta = (ContaBancaria) registry.lookup("ContaBancaria");

            //Inicializa o metodo scanner
            Scanner sc = new Scanner(System.in);
            boolean continuar = true;

            while (continuar) {
                //Menu do banco para o cliente
                System.out.println("Escolha uma opcao: ");
                System.out.println("1. Depositar");
                System.out.println("2. Retirar");
                System.out.println("3. Ver Saldo");
                System.out.println("4. Sair");
                System.out.println("Opcao: ");
                
                int opcao = sc.nextInt();

                System.out.println("\n");
                switch (opcao) {
                    case 1: //Depositar
                        System.out.println("\n");
                        System.out.print("Digite o valor para depositar: ");
                        double valorDeposito = sc.nextDouble();
                        conta.deposita(valorDeposito);
                        System.out.println("Saldo atual: " + conta.saldo());
                        System.out.println("\n");
                        break;
                    case 2:
                        //Retira
                        System.out.println("\n");  
                        System.out.print("Digite o valor para retirar: ");
                        double valorRetirada = sc.nextDouble();
                        conta.retira(valorRetirada);
                        System.out.println("Saldo atual: " + conta.saldo());
                        System.out.println("\n");
                        break;
                    case 3:
                        //Mostra o saldo
                        System.out.println("\n");
                        System.out.println("Saldo atual: " + conta.saldo());
                        System.out.println("\n");
                        break;
                    case 4:
                        //Sai do menu
                        continuar = false;
                        break;
                    default:
                        System.out.println("Opcao invalida.");
                        break;
                }
            }

        //Fecha metodo Scanner
        sc.close();
        } catch (Exception e) {
            //Tratamento de exceção
            System.err.println("Excecao no Cliente: " + e.toString());
            e.printStackTrace();
        }
    }
}
