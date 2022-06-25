package bancoCodigo;

import javax.swing.*;

class ContaPoupanca extends ContaBancaria{
    private final double rendimento = 0.05;
    private int SaquesMensais = 3;

    public void info(){
        System.out.println("========== Info Conta Bancaria ==========");
        System.out.println("Banco : " + this.banco.getNome()
                +"\nNº da Conta: " + this.nroConta
                +"\nTipo de conta: Poupança(013)"
                +"\nNome do Cliente: " + this.titular.nome
                +"\nSaldo: " + this.saldo
                +"\nRendimento Mensal: " + this.rendimento + "%"
                +"\nSaques Mensais: " + this.SaquesMensais + "\n");

    }

    public void novoMes(){
        this.SaquesMensais = 3;
        this.saldo = saldo + (rendimento * saldo);
    }


    //saque direto
    public void saque(double valor) {
        if(verificaSenha()) {
            if (this.saldo < valor) {
                System.out.println("Saldo insuficiente!");
            } else {
                this.saldo -= valor;
                System.out.println("\n Saque efetuado! \n");
            }
        }else{
            System.out.println("Senha não coincide!!");
        }
    }

    //saque questionado
    public void saque() {
        if(verificaSenha()) {
            double valor = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor"));
            if (this.saldo < valor) {
                System.out.println("Saldo insuficiente!");
            } else {
                this.saldo -= valor;
                System.out.println("\n Saque efetuado! \n");
            }
        }else{
            System.out.println("Senha não coincide!!");
        }
    }

    //deposito direto
    public void deposito(double depositar){
        this.saldo += depositar;
        System.out.println("\nValor depositado com sucesso!\n");
    }

    //deposito questionado
    public void deposito(){
        double depositar = Double.parseDouble(JOptionPane.showInputDialog("Digite o valor a ser depositado"));
        this.saldo += depositar;
        System.out.println("\nValor depositado com sucesso!\n");
    }

    //verifica senha direto;
    public boolean verificaSenha(String senha) {
        if(this.senha.equals(senha)){
            return true;
        }
        else{
            System.out.println("ERRO: Senha!");
            return false;
        }
    }

    //verifica senha questionado
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