package bancoCodigo;

import javax.swing.*;

public class ContaCorrente extends ContaBancaria {
    private final double TaxasMensais = 0.05;


    //retorna dadoosss
    public void info(){
        System.out.println("========== Info Conta Corrente ==========");
        System.out.println("Banco : " + this.banco.getNome()
                +"\nNº da Conta: " + this.nroConta
                +"\nNome do Cliente: " + this.titular.nome
                +"\nSaldo: " + this.saldo
                +"\nTaxas Mensais: " + this.TaxasMensais + "%\n");

    }

    //gira o mes
    public void novoMes(){
        this.saldo = this.saldo - (this.saldo * this.TaxasMensais);
    }

    //saque questionado
    public void saque() {
        if(verificaSenha()) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor"));
            if (this.saldo < valor) {
                System.out.println("Saldo insuficiente!");
            } else {
                this.saldo -= valor;
            }
        }else{
            System.out.println("Senha não coincide!!");
        }
    }

    //deposito com joption
    public void deposito(){
        double depositar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado"));
        this.saldo += depositar;
        //sout
    }

    //verifica senha direto
    public boolean verificaSenha(String senha) {
        if(this.senha.equals(senha)){
            return true;
        }
        else{
            System.out.println("ERRO: Senha!");
            return false;
        }
    }

    //veriffica senha questionado
    public boolean verificaSenha(){
        String senha = JOptionPane.showInputDialog("Digite a senha");
        if(this.senha.equals(senha)){
            return true;
        }
        else{
            System.out.println("ERRO: Senha!");
            return false;
        }
    }
}