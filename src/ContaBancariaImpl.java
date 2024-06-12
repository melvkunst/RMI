import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
    private double saldo;

    //Construtor padrão que pode lançar uma RemoteException
    protected ContaBancariaImpl() throws RemoteException {
        //Chama o construtor da superclasse UnicastRemoteObject
        super();
        //Inicia o saldo como 0
        this.saldo = 0.0;
    }

    //Metodo para depositar
    @Override
    public synchronized void deposita(double valor) throws RemoteException {
        saldo += valor;
        System.out.println("\nDepositado: " + valor + "\nSaldo atual: " + saldo);
    }

    //Metodo para retirar
    @Override
    public synchronized void retira(double valor) throws RemoteException {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("\nRetirado: " + valor + "\nSaldo atual: " + saldo);
        } else {
            System.out.println("\nSaldo insuficiente");
        }
    }

    @Override
    public synchronized double saldo() throws RemoteException {
        return saldo;
    }
}
