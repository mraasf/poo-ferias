package poo.banco;

import java.util.Scanner;

public class UI {
    Scanner in;
    BancoApp banco;

    public UI(Class<? extends AConta> contaClass) {
        in = new Scanner(System.in);
        banco = new BancoApp(contaClass);
    }

    public void start(){
        while (true) {
            print("Bem vindo ao app do banco, selecione a opção");
            print("1 - Criar nova conta");
            print("2 - Saque");
            print("3 - Depósito");
            print("4 - Transferência");
            print("5 - Consultar Conta");
            print("0 - Sair");

            int opcao = in.nextInt();

            switch (opcao) {
                case 1: this.criarConta(); break;
                case 2: this.saque(); break;
                case 3: this.deposito(); break;
                case 4: this.transferencia(); break;
                case 5: this.consulta(); break;
                case 0: return;
                default: this.opcaoInvalida();
            }
        }
    }

    private void consulta() {
        print("Digite o ID da conta:");
        Integer id = in.nextInt();
        banco.consulta(id);
    }

    private void opcaoInvalida() {
        print("Opção inválida, tente novamente.");
    }

    private void deposito() {
        print ("Opção 3 - Depósito");
        print("Digite o ID da conta:");
        Integer id = in.nextInt();

        print("Digite o valor a ser depositado:");
        Integer valor = in.nextInt();
        if (banco.deposito(id, valor)) {
            print("Depósito realizado com sucesso");
            print("Novo saldo da conta "+id+":" + banco.saldo(id));
        } else {
            print("Ocorreu um erro e o depósito não pôde ser realizado, tente novamente.");
        }
    }

    private void transferencia() {
        print("Opção 4 - Transferência");
        print("Digite o ID da origem:");
        Integer ido = in.nextInt();
        print("Digite o ID da destino:");
        Integer idd = in.nextInt();
        print("Digite o valor a ser transferido:");
        Integer valor = in.nextInt();

        if (banco.transferencia(ido, idd, valor)) {
            print("Transferência realizada com sucesso");
            print("Novo saldo da conta "+ido+":" + banco.saldo(ido));
            print("Novo saldo da conta "+idd+":" + banco.saldo(idd));
        }
        else {
            print("Ocorreu um erro e a transferência não pôde ser realizada, tente novamente.");
        }
    }

    private void saque() {
        print("Opção 2 - Saque");
        print("Digite o ID da conta:");
        Integer id = in.nextInt();
        print("Digite o valor a ser sacado: ");
        Integer valor = in.nextInt();

        if (banco.saque(id, valor)) {
            print("Saque realizado com sucesso, novo saldo: ");
            Integer saldo = banco.saldo(id);
            print(saldo.toString());
        } else {
            print("Ocorreu um erro e o saque não pôde ser realizado, tente novamente.");
        }
    }

    private void criarConta() {
        print("Opção 1 - Criar nova conta");
        print("Digite o nome do titular: ");
        String nome = in.next();

        Integer idNovaConta = banco.criarConta(nome);
        if (idNovaConta!=null) {
            print("Conta criada com sucesso, ID: "+idNovaConta);
        } else {
            print("Ocorreu um erro e a conta não pôde ser criada, tente novamente.");
        }
    }


    private void print(String msg) {
        System.out.println(msg);
    }
}
