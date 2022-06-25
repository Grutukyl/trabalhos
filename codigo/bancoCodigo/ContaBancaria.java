package bancoCodigo;

public abstract class ContaBancaria{

    protected Pessoa titular;
    protected Banco banco;
    protected int nroConta;
    protected double saldo;
    protected String senha;

    public abstract void novoMes();

    public abstract void saque();

    public abstract void deposito();

    public abstract boolean verificaSenha(String senha);

    public abstract boolean verificaSenha();


    public void info() {
    }
}