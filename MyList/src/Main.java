
public class Main {

	public static void main(String[] args) {
		MyList<Object> list = new MyList<Object>();
		
		list.add("Berkan");
		list.add("Burak");
		list.add("Ali");
		//list.add(2);
		
		//list.remove(2);
		list.remove("Berkan");
		list.list();
		//boolean result = list.contains("Ali");
		//System.out.println(result);
	}

}
