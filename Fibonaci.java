package arquivosJava;
import java.util.Scanner;

import javax.swing.JOptionPane;

public class Fibonaci {
	
	

	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);
		int x = 1,b = 0;
		
//0  1  1  2  3  5  8  13  21  34
		
		for(int i = 0; i <  5; i++) {
			
			
			System.out.println(b + "\n"+ x);
			b = b + x;
			x = b +x;
			
			
		}
		
	
		

		
	}//pm

}//class
