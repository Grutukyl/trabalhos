package arquivosJava;

import javax.swing.JOptionPane;

public class SobraDeCedulas {
	
	
	public static void main(String[] args) {
		
		
		int a,b,c;
		
		
		a = Integer.parseInt(JOptionPane.showInputDialog(null,"Digite o numero: "));
		JOptionPane.showMessageDialog(null, "Seu valor � " + a);
		
		
		b = a / 100;
		c = a % 100;
		JOptionPane.showMessageDialog(null, "Seu n�mero em notas de 100 �:  " + b);
		
		b = c / 20;
		a = c % 20;
		JOptionPane.showMessageDialog(null, "Seu n�mero em notas de 20 �:  " + b);
		
		c = a / 5;
		b = c % 5;
		JOptionPane.showMessageDialog(null, "Seu n�mero em notas de 5 �:  " + c);

		a = b / 1;
		JOptionPane.showMessageDialog(null, "Seu n�mero em notas de 1 �:  " + a);
				
		
		
		
		
		
		
		
	}
	
	

}
