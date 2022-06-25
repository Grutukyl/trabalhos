package bancoCodigo;

import java.util.ArrayList;

public class Banco {

        private String nome;
        private String CNPJ;
        private int nroBanco;
        private ArrayList<ContaBancaria> contasBancarias = new ArrayList<>();

        //construtor
        public Banco(String nome, String CNPJ, int nroBanco) {
                this.nome = nome;
                this.CNPJ = CNPJ;
                this.nroBanco = nroBanco;

        }


        //procurar conta bancaria da lista de contas do banco
        public ContaBancaria returnConta(int nrmconta){
                ContaBancaria atual = null;
                for (int i = 0; i < this.contasBancarias.size(); i++) {
                        if(this.contasBancarias.get(i).nroConta == nrmconta){
                                atual = this.contasBancarias.get(i);
                        }
                }
                if(atual == null){
                        System.out.println(" Nª da conta não existe ou não encontrado! ");
                        return  null;
                }
                else{
                        return atual;
                }
        }


        //adiciona uma conta bancaria a lista de contas do banco.
        public void addConta(ContaBancaria conta){
                this.contasBancarias.add(conta);
        }

        // gets nome, cnpj , nrobanco, listacontas
        public String getNome() {
                return nome;
        }
        public String getCNPJ() {
                return CNPJ;
        }
        public int getNroBanco() {
                return nroBanco;
        }
        public ArrayList<ContaBancaria> getContasBancarias() {
                return contasBancarias;
        }

        //info dados do banco.
        public void infoBanco(){
                System.out.println("\n========== Info Banco ==========");
                System.out.println("Nome do banco: " + this.getNome() +
                        "\nCNPJ: " + this.getCNPJ() +
                        "\nNª do Banco: " + this.getNroBanco() + "\n");
        }

        //retorna as contas do banco
        public void infoContas(){
                if(!contasBancarias.isEmpty()) {
                        for (int i = 0; i < contasBancarias.size(); i++) {
                                contasBancarias.get(i).info();
                        }
                }else {
                        System.out.println("\n Esse banco não possui contas \n");
                }
        }

        //cria conta no banco
        public void criarConta(Pessoa titular, int contatipo, int nroconta, double saldo, String senha){
                if(contatipo == 1){
                        ContaPoupanca contap = new ContaPoupanca();
                        contap.titular = titular;
                        contap.banco = this;
                        contap.nroConta = nroconta;
                        contap.saldo = saldo;
                        contap.senha = senha;

                        titular.addPoupanca(contap);
                        this.addConta(contap);
                        System.out.println("\nConta adicionada!\n");
                }
                else if(contatipo == 2){
                        ContaCorrente contap = new ContaCorrente();
                        contap.titular = titular;
                        contap.banco = this;
                        contap.nroConta = nroconta;
                        contap.saldo = saldo;
                        contap.senha = senha;

                        titular.addPoupanca(contap);
                        this.addConta(contap);
                        System.out.println("\nConta adicionada!\n");
                }
                else{
                        System.out.println("\nTipo de conta invalido\n");
                }
        }

        //fecha conta no banco verifficando senha
        public void fecharConta(Pessoa titular, int nroconta, String senha){
                boolean check = false;
                ContaBancaria atualconta = null;
                for (int i = 0; i < contasBancarias.size(); i++) {
                        if (nroconta == contasBancarias.get(i).nroConta){
                                atualconta = contasBancarias.get(i);
                                if(contasBancarias.get(i).verificaSenha(senha) == true) {
                                        titular.getContasBancarias().remove(atualconta);
                                        contasBancarias.remove(i);
                                        break;
                                }else {
                                        check = true;
                                        break;
                                }
                        }
                }
                if(check == true && atualconta == null  || atualconta == null){
                        System.out.println("\n Conta não encontrada no banco Informado! \n");
                }
                else if(check == true){
                        System.out.println("\nSenha invalida\n");
                }
                else{
                        System.out.println("\n Conta fechada!\n");
                }
        }


}
