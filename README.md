# Tarefa Modulo 3 - Sistemas Distribuídos
Trabalho desenvolvido por Melissa Kunst

Este repositório conta com o desenvolvimento de uma aplicação RMI onde um objeto remoto é uma conta bancária e vários clientes podem acessar essa conta.
O objeto remoto implementa os métodos de deposita, retira e saldo, mostrando isso em formato de menu no lado do cliente.

## Passos para executar o programa
1. Abra o terminal dentro da pasta do projeto, neste caso o src;
2. Dentro do terminal, compile os arquivos usando: javac *.java
3. No mesmo terminal, inicie o RMI: rmiregistry 1099;
4. Abra dois outros terminais;
5. No primeiro, dentro da pasta src, execute o Servidor: java Servidor;
6. No segundo, dentro da pasta src, execute o Cliente: java Cliente;
7. Assim tu poderá depositar, retirar e verificar o saldo no lado do cliente e verificar a movimentação no lado do servidor.