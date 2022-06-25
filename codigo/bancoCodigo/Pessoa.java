package bancoCodigo;

import java.util.ArrayList;

public class Pessoa {
    public String nome;
    public String sobrenome;
    public int idade;
    private String cpf;
    private ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();

    //retorna cpf
    public String getCpf() {
        return cpf;
    }

    //retorna lista de contas
    public ArrayList<ContaBancaria> getContasBancarias() {
        return contasBancarias;
    }

    //adiona um conta bancaria a lista de contas da pessoa
    public void addPoupanca(ContaBancaria c){
        this.contasBancarias.add(c);
    }


    //procurar conta bancaria da lista de contas da pessoa
    public ContaBancaria returnConta(int nrmconta){
        ContaBancaria atual = null;
        for (ContaBancaria contasBancaria : this.contasBancarias) {
            if (contasBancaria.nroConta == nrmconta) {
                atual = contasBancaria;
            }
        }
        if(atual == null){
            System.out.println(" Nª da conta não existe ou não encontrado!\n");
            return  null;
        }
        else{
            return atual;
        }
    }

    //construtor
    public Pessoa(String nome, String sobrenome, int idade, String cpf) {
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.idade = idade;
        this.cpf = cpf;
    }

    //info pessoa sem cpf
    public void Info(){
        System.out.println("\n========== Info Pessoa ==========");
        System.out.println("Nome da Pessoa: " + this.nome +
                "\nSobrenome: : " + this.sobrenome +
                "\nIdade: " + this.idade +"\n");
    }

    public void InfoContas(){
        if(!contasBancarias.isEmpty()) {
            for (ContaBancaria contasBancaria : contasBancarias) {
                contasBancaria.info();
            }
        }
        else{
            System.out.println("\n Essa pessoa não tem contas \n");
        }
    }


}