package odev1;

import java.util.Random;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// ODEV - 1
		
		System.out.println("Oynanmak istenen kolon adedi: ");
		Scanner scanner = new Scanner(System.in);
		
		int kolonAdedi = scanner.nextInt();
		
		for (int i = 0; i < kolonAdedi ; i++) {
			//Dizi Tanımlaması: (Bir kolonda 6 sayı olur)
			int[] sayilar = new int[6];
			
			//Random sınıf instance: 
			Random random = new Random();
			System.out.println(i+1 + " kolon:");
			for (int j = 0; j < sayilar.length; j++) {
				do {
					sayilar[i] = random.nextInt(48) + 1;
				}while(sayilar.equals(sayilar[i]));
		
				//0 atamaması için 1 ile topladık.
				System.out.print(sayilar[i] + " ");
			}
			System.out.println(" ");
		}
	}

}
