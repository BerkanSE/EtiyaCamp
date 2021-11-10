package deneme;

public class Main {

	public static void main(String[] args) {
		
		int[] dizi = {5, 4, 8, 5, 2, 4};
		int[] yeniDizi = new int[4];
		//int[] ekDizi = new int[dizi.length];
		//int elemanSayisi = 1;
		yeniDizi[0] = dizi[0];
		
		for (int i = 1; i < dizi.length; i++) {
			boolean repeat = false;
			for (int j = 0; j < i; j++) {
				if (dizi[i] == dizi[j]) {
					repeat = true;
					break;
				}
		//		else if (dizi[i] != dizi[j] && i == j - 1) {
		//			ekDizi[elemanSayisi] = dizi[i];
		//			elemanSayisi++;
		//		}
			
			}
			if (repeat == false) {
				for (int k = 1; k < 4; i++) {
					yeniDizi[k] = dizi[k];
					System.out.println(yeniDizi[k]);
				}
			}
		}
		
	
		//for (int i = 0; i < yeniDizi.length; i++) {
		//	yeniDizi[i] = ekDizi[i];
		//	System.out.println(ekDizi[i]);
		//}
		
		
			
	}

}
