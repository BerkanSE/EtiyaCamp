
public class Main {

	public static void main(String[] args) {
		MyHashMap<Double, Integer> asd = new MyHashMap<Double, Integer>();
		asd.put(1.5, 2);
		asd.put(0.22, 3);
		asd.put(0.78988, 5);
		// asd.remove("Halit", 3);
		// asd.remove("Erdi");
		System.out.println(asd.size());

		asd.list();

		asd.clear();

		asd.list();

	}

}
