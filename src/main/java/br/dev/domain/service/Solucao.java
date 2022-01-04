package br.dev.domain.service;

import java.util.Scanner;

public class Solucao {
	
	 
	
   public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int total = 0;
		int i = 0;
		int num = 0;
	    int min = 0;
	    int max = 0;
		
		while(sc.hasNext()) {
		
		  if (i == 0){
		  
	
		   num = sc.nextInt();
		    min = sc.nextInt();
		    max = sc.nextInt();
		   i++;
		  } else if (i > num){
		    break;
		  }
		  int current = sc.nextInt();
		  if (current >= min && current <= max){
			  total++;
		  }
	  
				 
				
			}
			sc.close();
			System.out.println(total);
		}

}
