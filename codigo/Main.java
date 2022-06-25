package codigo;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Funcionario f1 = new Funcionario("Pamela Anderson","Aeromoça",2500);
        Piloto p1 = new Piloto("Samuel Jacks","LP5528", 5700);
        Aviao a1 = new Aviao("TF-2014","QANTAS jet","Boeing 747-400");
        Voo v1 = new Voo("LA303","Hawaii","Los Angeles",p1,a1);

        f1.Info();
        a1.info();
        p1.Info();
        v1.info();
        f1.NovoSalario();
        f1.NovoSalario(3000);
        p1.ModHorasVoo(1000);




    }

}
