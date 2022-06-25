package codigo;

public class Voo {

    private String CodVoo;
    private String origem;
    private String Destino;
    private Piloto Comandante;
    private Aviao aeronave;

    public Voo(String codVoo, String origem, String destino, Piloto comandante, Aviao aeronave) {
        this.CodVoo = codVoo;
        this.origem = origem;
        this.Destino = destino;
        this.Comandante = comandante;
        this.aeronave = aeronave;
    }

    public void info(){
        System.out.println("\n========= Info Voo =========");
        System.out.println("CodVoo: " + this.CodVoo
                +"\nEmpresa: " + aeronave.Empresa
                +"\nOrigem e destino:  de "  + this.origem + " para " + this.Destino
                +"\nAeronave: " + aeronave.Modelo
                +"\nComandante: " + Comandante.nome);
    }


}
