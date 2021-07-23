package arquivosJava;

import java.util.Scanner;

import javax.swing.JOptionPane;

public class c01 {
	
	
	
	
	public static void main(String[] args) {
		
		Scanner sc = new Scanner(System.in);

		int x, x1, a ,a2 ,t = 0;
		
		System.out.println("Insira a altura  da primeira arvore e depois o crescimento por ano: ");
		x = sc.nextInt();
		x1 = sc.nextInt();
		System.out.println("Insira a altura  da segunda  arvore e depois o crescimento por ano: ");
		a = sc.nextInt();
		a2 = sc.nextInt();
		
		
		if(x < a) {

				do{
					x = x + x1;
					a = a + a2;
					t++;
				}while(a >= x);
				
				if(a2 > x1){
					System.out.println("nunca");
				}else {
					System.out.println(t);
				}
		}
		
		else if(x > a) {

				do{
					x = x + x1;
					a = a + a2;
					t++;
				}while(a <= x);
				
				if(x1 > a2) { 
					System.out.println("nunca");
				}
				else {
					System.out.println(t);
				}
		}
		
		if(a == x && a2 != x1) {
			System.out.println("1");
		}
		else if(a2== x1) {
			System.out.println("nunca");
		}
		
	
			
			
		
		
	
		

		
	}//pm

}//class
