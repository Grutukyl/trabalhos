package codigo;

import javax.swing.*;
import java.awt.*;

public class Funcionario {

    protected String nome;
    protected String cargo;
    protected double salario;


    public Funcionario(String nome, String cargo, double salario){
        this.cargo = cargo;
        this.nome = nome;
        this.salario = salario;
    }

    public void Info(){
        System.out.println("========= Info Funcionário ==========");
        System.out.println("Nome: " + this.nome
                +"\nCargo: " + this.cargo
                +"\nSalário: " + this.salario);
    }

    public void NovoSalario(double novosalario){
        this.salario = novosalario;
        System.out.println("\n====== Atualização Salario ======");
        System.out.println("Salário de " + this.nome + " atualizado para : " + this.salario);
    }

    public void  NovoSalario(){
        this.salario = Double.parseDouble(JOptionPane.showInputDialog("Digite o novo salário"));
        System.out.println("\n====== Atualização Salario ======");
        System.out.println("Salário de " + this.nome + " atualizado para : " + this.salario);
    }

}
