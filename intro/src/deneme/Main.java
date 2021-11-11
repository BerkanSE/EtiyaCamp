package deneme;

public class Main {

	public static void main(String[] args) {
		
		String[] cities = {"Ankara", "İstanbul"};
		addCity(cities, "İzmir");
		for (String city : cities) {
			System.out.println(city);
		}	
	}
	public static void addCity(String[] cities, String city) {
		cities = new String[cities.length + 1];
		cities[cities.length] = city;

	}

}
