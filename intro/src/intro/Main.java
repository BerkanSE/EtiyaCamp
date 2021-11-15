package intro;

import java.util.Iterator;

public class Main {

	public static void main(String[] args) {
		//Veri Tipleri
		
		//Metinsel veri tipi
		//Çift tırnak ve String ilk harfi büyük olmalı
		String news1 ="Yeni kredi geldi";
		
		//Tam sayı tipi
		int age = 23;
		
		//Ondalıklı sayı tipi
		double dollarYesterday = 9.55;
		double dollarToday = 9.65;
		
		//Mantıksal veri tipi
		//Çoğunlukla karşılaştırma yapmak için kullanılır
		boolean increased = true;
		
		//Karekter veri tipi
		//Tek tırnak ile yazılır
		//Genelde char yerine String olarak kullanılır.
		//String aslında bellekteki tutumuna göre char dan oluşur
		char firstLetter = 'A';
		
		//3 durumdan sadece 1 tanesi çalışır
		if (dollarToday > dollarYesterday) {
			//System.out.println("up.svg");
		}
		else if (dollarToday < dollarYesterday) {
			//System.out.println("down.svg");
		}
		else {
			//System.out.println("equal.svg");
		}
		
		//Array
		String[] credits = {"Emekli Kredisi","Çalışan Kredisi"
				,"Genel İhtiyaç Kredisi"};
		
		//Döngüler
		
		//For (Çoğunlukla)
		//i --> index : Sayac
		//Dinamiklestirme: credits.length,
		//System.out.println("for");
		for (int i = 0; i < credits.length; i++) {
			//System.out.println(credits[i]);
		}
		
		//Foreach Döngüsü
		//System.out.println("foreach");
		for (String credit : credits) {
			//System.out.println(credit);
		}
		
		//While
		//System.out.println("while");
		//Sayaci döngünün dışında tanımlıyoruz.
		int index = 0;
		while (index<credits.length) {
			//System.out.println(credits[index]);
			index++; //Artırırsak sonsuz döngüye girmez
		}
		
		//Do while (Az kullanım)
		//System.out.println("do while");
		int index2 = 0;
		do {
			//System.out.println(credits[index2]);
			index2++;
		} while (index2 < credits.length);
	
	
		for (int i = 1; i <= 10; i++ ) {
			if(i==5) {
				//break; //Döngüyü bitirir (5'e kadar yazar)
				continue; //Sadece 5'i yazmaz
			}
			//System.out.println(i);
		}
		
		for (int x = 0, y = 0; y < 7; x++, y++) {
			x *= y;
			System.out.println("x: " + x + " y: " + y);
		}
		
		
	}
}
