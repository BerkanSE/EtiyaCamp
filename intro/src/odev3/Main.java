package odev3;

import java.util.Random;

public class Main {

	public static void main(String[] args) {
		// ODEV - 3

		// Random sınıf instance:
		Random random = new Random();

		// 5 Elemanlı Tek Boyutlu Dizi Tanımlaması
		int[] randomDizi = new int[5];

		System.out.println("Random oluşturulan dizi: ");

		System.out.print("{");
		// Diziye random değerler atanması:
		for (int i = 0; i < randomDizi.length; i++) {
			// 0 atamaması için 1 ile topladık
			randomDizi[i] = random.nextInt(100) + 1;
			System.out.print(randomDizi[i] + ", ");
		}
		System.out.print("}");

		// Büyükten --> Küçüğe algoritmik sıralama işlemi:

		// Sonuncusu için işlem yapılmadığından k'yı 1 den başlatırız.
		for (int k = 1; k < randomDizi.length; k++) {
			int kücükOlanSayi;
			// Burada 5 - k yazmamızın nedeni k=1 iken en küçük sayının son indise (4.indis)
			// yerleşmesinden dolayı
			// İkili karşılaştırma ve yer değiştirme sonrası 3.indis, 2.indis, 1. indis
			// değerleri belli olarak yerleşir.
			for (int j = 0; j < 5 - k; j++) {
				if (randomDizi[j] < randomDizi[j + 1]) {
					kücükOlanSayi = randomDizi[j];
					randomDizi[j] = randomDizi[j + 1];
					randomDizi[j + 1] = kücükOlanSayi;
				}
			}
		}
		System.out.println("");
		System.out.println("Büyükten küçüğe sıralanmış dizi: ");
		// Dizi elemanlarını ekrana yazdırma
		for (int x = 0; x < randomDizi.length; x++) {
			System.out.print(randomDizi[x] + " ");
		}

	}

}
