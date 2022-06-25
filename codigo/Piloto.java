package codigo;

import javax.swing.*;

public class Piloto extends Funcionario{
    private String brevet;
    private int horasVoo;


    public Piloto(String nome, String brevet, int horasvoo){
        super(nome,"Piloto",0);
        this.nome = nome;
        this.brevet = brevet;
        this.horasVoo = horasvoo;
    }


    public void Info() {
        System.out.println("\n========= Info Piloto =========");
        System.out.println("Nome: " + this.nome
                +"\nBrevet: " + this.brevet
                +"\nHoras voo: " + this.horasVoo
                +"\nSalário: " + this.salario);
    }


    public void NovoSalario() {
        super.NovoSalario(3500 + (horasVoo / 2));
    }

    public void ModHorasVoo(int horasnovas){
        horasVoo += horasnovas;
        this.NovoSalario();

    }


}
