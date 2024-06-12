import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ContaBancariaImpl extends UnicastRemoteObject implements ContaBancaria {
    private double saldo;

    protected ContaBancariaImpl() throws RemoteException {
        super();
        this.saldo = 0.0;
    }

    @Override
    public synchronized void deposita(double valor) throws RemoteException {
        saldo += valor;
        System.out.println("Depositado: " + valor + " | Saldo atual: " + saldo);
    }

    @Override
    public synchronized void retira(double valor) throws RemoteException {
        if (saldo >= valor) {
            saldo -= valor;
            System.out.println("Retirado: " + valor + " | Saldo atual: " + saldo);
        } else {
            System.out.println("Saldo insuficiente para retirada de " + valor);
        }
    }

    @Override
    public synchronized double saldo() throws RemoteException {
        return saldo;
    }
}
