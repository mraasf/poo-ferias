package poo.banco;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.lang.reflect.Constructor;

public class BancoApp {
    private List<AConta> contas;
    Class<? extends AConta> contaClass;

    public BancoApp(Class<? extends AConta> contaClass) {
        this.contas = new ArrayList<>();
        this.contaClass = contaClass;
    }

    public Integer criarConta(String nome) {
        AConta novaConta = this.criarConta();
        if (novaConta==null) return null;
        else {
            novaConta.setTitular(nome);
            contas.add(novaConta);
            return contas.size()-1;
        }
    }

    public boolean saque(Integer id, Integer valor) {
        return contas.get(id).saque(valor);
    }

    public Integer saldo(Integer id) {
        return contas.get(id).saldo();
    }

    public boolean transferencia(Integer ido, Integer idd, Integer valor) {
        AConta destino;
        try {
            destino = contas.get(idd);
        } catch (ArrayIndexOutOfBoundsException e){
            destino = null;
        }
        return contas.get(ido).transferencia(destino, valor);
    }

    public boolean deposito(Integer id, Integer valor) {
        return contas.get(id).deposito(valor);
    }

    private AConta criarConta() {
        try {
            Constructor<? extends AConta> c = contaClass.getConstructor();
            return c.newInstance();
        } catch (NoSuchMethodException | InstantiationException | IllegalAccessException | InvocationTargetException e) {
            e.printStackTrace();
        }
        return null;
    }

    public void consulta(Integer id) {
        AConta c = contas.get(id);
        if (c!=null) {
            System.out.println("Nome do titular: "+c.titular());
            System.out.println("Saldo: "+c.saldo());
        }
    }
}
