package codigo;

public class Aviao {
    protected  String prefixo;
    protected  String Empresa;
    protected  String Modelo;

    public Aviao(String prefixo, String empresa, String modelo) {
        this.prefixo = prefixo;
        this.Empresa = empresa;
        this.Modelo = modelo;
    }

    public  void info(){
        System.out.println("=========Informações do Avião ============");
        System.out.println("Prefixo: "+ this.prefixo
                +"\nEmpresa: " + this.Empresa
                +"\nModelo: " + this.Modelo);
    }

}
