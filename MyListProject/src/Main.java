
public class Main {

	public static void main(String[] args) {
		// ODEV - 1
		
		MyList list = new MyList();
		list.add("Balıkesir");
		list.add("İzmir");
		list.add("Edirne");
		list.add("Ankara");
		
		//boolean sonuc = list.contain("Sarsada");
		//System.out.println(sonuc);
		
		//list.remove(1);
		list.remove("Edirne");
		list.getAlllist();
		//System.out.println(list.get(2));
	
	}

}
