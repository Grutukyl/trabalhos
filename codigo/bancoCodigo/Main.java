package bancoCodigo;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcode, opcaoconta;
        Scanner sc = new Scanner(System.in);
        ArrayList<Banco> bancolista = new ArrayList<>();
        ArrayList<Pessoa> pessoalista = new ArrayList<>();


        //entradas para teste
        Banco testebanco1 = new Banco("Santander SA","123456890",23);
        bancolista.add(testebanco1);
        Pessoa testepessoa1 = new Pessoa("Eugenio","Cartagena",20,"02311185039");
        pessoalista.add(testepessoa1);
        Pessoa testepessoa2 = new Pessoa("Elisete","Rosa",46,"66644433322");
        pessoalista.add(testepessoa2);
        testebanco1.criarConta(testepessoa1, 1, 111, 1000, "1010");
        testebanco1.criarConta(testepessoa1, 2, 222, 2000, "1010");
        testebanco1.criarConta(testepessoa2, 2, 232, 5500, "1010");
        testebanco1.criarConta(testepessoa2, 1, 333, 3000, "1010");
        //outro banco
        Banco testebanco2 = new Banco("Bradesco SA","987236123",24);
        bancolista.add(testebanco2);
        testebanco2.criarConta(testepessoa1,1,111,100000,"1010");
        testebanco2.criarConta(testepessoa1,2,121,100,"1010");
        testebanco2.criarConta(testepessoa2,2,222,9999,"1010");
        testebanco2.criarConta(testepessoa2,1,332,199,"1010");


        do{
            Banco atualbanco = null;
            Pessoa atualpessoa = null;
            ContaBancaria atualconta = null;

            System.out.println("""

                    Digite a opção:\s
                    1 para cadastrar um banco;
                    2 para listar todos bancos cadastrados
                    3 para listar contas cadastradas em um banco
                    ==============================================
                    4 para cadastrar uma Pessoa
                    5 para listar todas pessoas cadastradas
                    6 para listar todas as contas de uma pessoa.
                    ===============================================
                    7 para cadastrar uma conta.
                    8 para fechar uma conta
                    9 para AÇOES EM UMA CONTA
                    0 para sair.""");
            opcode = sc.nextInt();

            switch (opcode){
                //cadastra um banco.
                case 1:
                    System.out.print("\nDigite o CNPJ do banco: ");
                    String bancocnpj = sc.next();
                    System.out.print("\nDigite o Nª do banco: ");
                    int banconrm = sc.nextInt();
                    sc.nextLine();
                    System.out.print("\nDigite o nome do banco: ");
                    String banconome = sc.nextLine();
                    //if para ver se já tem um banco com esse numero.
                    if(!Main.checarNumeroBanco(banconrm,bancolista)){
                        Banco banco = new Banco(banconome, bancocnpj, banconrm);
                        bancolista.add(banco);
                        System.out.println("\nBanco cadastrado!\n");
                    }
                    else {
                        System.out.println("\nBanco já cadastrado com esse número!!!\n");
                    }
                    break;



                    //lista todos os bancos.
                case 2:
                    for (Banco banco1 : bancolista) {
                        banco1.infoBanco();
                    }
                    break;



                    //lista todas contas em um bancos
                case 3:
                    System.out.println("Digite o nª do Banco: ");
                    banconrm = sc.nextInt();
                    atualbanco = Main.procurarBanco(banconrm, bancolista);
                    if(atualbanco == null){
                        System.out.println("\n Digite um nª de banco valido! ");
                    }
                    else {
                        atualbanco.infoContas();
                    }
                    break;



                    //cadastra uma pessoa
                case 4:
                    System.out.println("Digite o nome da pessoa: ");
                    String pessoanome = sc.next();
                    System.out.println("Digite o sobrenome da pessoa: ");
                    String pessoasobrenome = sc.next();
                    System.out.println("Digite a idade da pessoa: ");
                    int pessoaidade = sc.nextInt();
                    System.out.println("Digite o CPF  da pessoa");
                    String pessoacpf = sc.next();

                    Pessoa pessoa = new Pessoa(pessoanome,pessoasobrenome,pessoaidade,pessoacpf);
                    pessoalista.add(pessoa);
                    System.out.println("\nPessoa cadastrada!\n");
                    break;



                    //lista todas pessoas com cadastro
                case 5:
                    for (Pessoa pessoa1 : pessoalista) {
                        pessoa1.Info();
                    }
                    break;



                    //listar contas de uma pessoa.
                case 6:
                    System.out.println("\nDigite o CPF do titular das contas!");
                    atualpessoa = Main.procurarPessoa(sc.next(), pessoalista);
                    if(atualpessoa == null){
                        System.out.println("\n Insira um CPF valido!\n");
                    }
                    else {
                        atualpessoa.InfoContas();
                    }
                    break;



                    //abre conta
                case 7:
                    //pergunta cpf e banco
                    System.out.println("Digite o CPF da pessoa titular já cadastrada: ");
                    String titularcpf = sc.next();
                    System.out.println("Digite o nª do banco já cadastrado que queira abrir a conta: ");
                    int nrobanco = sc.nextInt();

                    //procura banco e pessoa
                    atualpessoa = Main.procurarPessoa(titularcpf,pessoalista);
                    atualbanco = Main.procurarBanco(nrobanco, bancolista);
                    if(atualpessoa == null || atualbanco == null) {
                        System.out.println("\nConfira o nª do banco ou cpf da pessoa\n");
                    }
                    else{
                        //tipo conta
                        System.out.println("Digite 1 para conta poupanta e 2 para conta corrente! ");
                        int contatipo = sc.nextInt();
                        //dados conta
                        System.out.println("Digite o nª da nova conta");
                        int nroconta = sc.nextInt();
                        System.out.println("Digite o saldo inicial da conta: ");
                        double saldoconta = sc.nextDouble();
                        System.out.println("Digite a senha da conta: ");
                        String senhaconta = sc.next();
                        //cria conta
                        if(!Main.checarNumeroConta(nroconta,atualbanco.getContasBancarias())) {
                            atualbanco.criarConta(atualpessoa, contatipo, nroconta, saldoconta, senhaconta);
                        }
                        else{
                            System.out.println("\nEsse banco já tem uma pessoam com esse número de conta!!!\n");
                        }
                    }
                    break;



                    //fecha conta
                case 8:
                    //pergunta nª do banco, cpf e n ª da conta e senha
                    System.out.println("Digite o CPF da pessoa titular já cadastrada: ");
                    titularcpf = sc.next();
                    System.out.println("Digite o nª do banco já cadastrado que queira fechar a conta: ");
                    nrobanco = sc.nextInt();
                    System.out.println("Digite o nª da que queira fechar conta");
                    int nroconta = sc.nextInt();
                    System.out.println("Digite a senha da conta: ");
                    String senhaconta = sc.next();
                    //procura banco e pessoa
                    atualpessoa = Main.procurarPessoa(titularcpf,pessoalista);
                    atualbanco = Main.procurarBanco(nrobanco, bancolista);
                    //fecha conta
                    if(atualpessoa == null  || atualbanco == null ){
                        System.out.println("\n Confira o nª do banco ou CPF! \n");
                    }
                    else {
                        atualbanco.fecharConta(atualpessoa, nroconta, senhaconta);
                    }
                    break;



                    //ações em conta.
                case 9:
                    System.out.println("Digite o CPF da pessoa titular: ");
                    String titularcpf2 = sc.next();
                    System.out.println("Digite o Nª do banco que a conta se encontra");
                    nrobanco = sc.nextInt();
                    atualbanco = Main.procurarBanco(nrobanco,bancolista);
                    atualpessoa = Main.procurarPessoa(titularcpf2,pessoalista);
                    if(atualpessoa == null || atualbanco == null){
                        System.out.println("\n Confira o nª do banco ou cpf do titular! \n");
                    }
                    else {
                        System.out.println("Digite o Nª da conta: ");
                        int nrmconta = sc.nextInt();
                        atualconta = atualbanco.returnConta(nrmconta);
                        if(atualconta == null){
                            System.out.println("\n Digite um nº de conta existente! \n");
                        }
                        else {
                            System.out.println("\n ====== BEM VINDO ======");
                            do {
                                System.out.println("""

                                        Digite 1 para fazer um saque
                                        Digite 2 para fazer um deposito
                                        Digite 3 para verificar saldo
                                        Digite 4 para girar o mês (testar)
                                        Digite 5 para retornar as Informações da conta
                                        Digite 0 para sair""");
                                opcaoconta = sc.nextInt();
                                switch (opcaoconta) {
                                    case 1:
                                        atualconta.saque();
                                        break;
                                    case 2:
                                        atualconta.deposito();
                                        break;
                                    case 3:
                                        System.out.println("\nO saldo atual é " + atualconta.saldo + "\n");
                                        break;
                                    case 4:
                                        atualconta.novoMes();
                                        break;
                                    case 5:
                                        atualconta.info();
                                        break;
                                    default:
                                        if (opcaoconta != 0)
                                            System.out.println("\nOp invalida!");
                                        break;
                                }
                            } while (opcaoconta != 0);
                        }
                    }
                    break;
                default:
                    if (opcode != 0)
                        System.out.println("\nOpção invalida");
                    break;
            }
        }while(opcode != 0);
    }

    //procura uma pessoa na lista
    public static Pessoa procurarPessoa(String cpf , ArrayList<Pessoa> pessoalista){
        Pessoa atual = null;
        for (Pessoa pessoa : pessoalista) {
            if (cpf.equals(pessoa.getCpf())) {
                atual = pessoa;
            }
        }
        if(atual == null){
            System.out.println("\nCPF Não encontrado!");
            return null;
        }
        else{
            System.out.println("\nCPF Encontrado! nome do titular: " + atual.nome);
            return atual;
        }
    }

    //verifica se ja tem um banco cadastrado com o número do banco.
    public static boolean checarNumeroBanco(int nmr, ArrayList<Banco> bancolista){
        boolean check = false;
        for (Banco banco : bancolista) {
            if (banco.getNroBanco() == nmr) {
                check = true;
                break;
            }
        }
        return check;
    }

    //verifica se ja tem uma conta cadastrada com o numero informado.
    public static boolean checarNumeroConta(int nmr,ArrayList<ContaBancaria> contaslista){
        boolean check = false;
        for (ContaBancaria contaBancaria : contaslista) {
            if (contaBancaria.nroConta == nmr) {
                check = true;
                break;
            }
        }
        return check;
    }

    //procura um banco na lista
    public static Banco procurarBanco(int nbanco, ArrayList<Banco> bancolista){
        Banco atual = null;
        for (Banco banco : bancolista) {
            if (banco.getNroBanco() == nbanco) {
                atual = banco;
            }
        }
        if(atual == null){
            System.out.println("\nBanco Não encontrado!");
            return null;
        }
        else{
            System.out.println("\nBanco Encontrado! nome do banco: " + atual.getNome() + "\n");
            return atual;
        }
    }
}
