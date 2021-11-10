package odev2;

public class Main {

	public static void main(String[] args) {
		// ODEV - 2

		//Dizi Tanımlaması:
		int[] dizi = {5, 9, 2, 5, 8, 3, 4, 8, 1, 7, 6, 9, 5, 6}; //14
		
		//Beklenilen yeni dizi çıktısı: {5, 9, 2, 8, 3, 4, 1, 7, 6}
		
		int[] tekrar = new int[9];
		
		//System.out.println(tekrar[4]); //0
		
		for (int i = 0; i < dizi.length; i++) {
			tekrar[dizi[i]-1] = tekrar[dizi[i]-1] + 1;
			//i = 0 için tekrar[4] = 1;
			//i = 1 için tekrar[8] = 1;
			//i = 2 için tekrar[1] = 1;
			//i = 3 için tekrar[4] = 2;
			//i = 4 için tekrar[8] = 1;
			//i = 5 için tekrar[1] = 2;
			//Yani tekrar etmeyenler 1 tekrar edenler 1+ olur. 
			if (tekrar[dizi[i]-1] > 1) {
				dizi[i] = 0;
			}
		}
		
		for (int i = 0; i < dizi.length; i++) {
			if (dizi[i] != 0 ) {
				System.out.println(dizi[i] + " ");
			}
		}
		
	}

}
