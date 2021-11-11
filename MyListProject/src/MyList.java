import java.util.Iterator;

public class MyList {
	//Tek boyutlu dizi tanımlası: 
	String[] list; //Reference type
	
	//Default constructor
	public MyList() {
		this.list = new String[0];//101
	}
	
	//Parametreli constructor
	public MyList(String[] list) {
		this.list = list;
	}
	
	public String[] add(String city) {
		String[] newList = list; //101
		//Dizinin eleman sayısını arttırma:
		list = new String[list.length + 1]; //102 --> 1 Elemanlı
		//Elemanları geçirme
		for (int i = 0; i < newList.length; i++) {
			list[i] = newList[i];
		}
		//Eklenmek istenen değeri son indise atama:
		list[list.length - 1] = city;
		newList = list;
		return list;
	}
	
	/*public String[] add(String city) {
		String[] newList = new String[list.length + 1 ]; //102
		for (int i = 0; i < list.length; i++) {
			newList[i] = list[i];
		}
		newList[newList.length - 1] = city;
		
		list = new String[newList.length]; //103
		for (int i = 0; i < newList.length; i++) {
			list[i] = newList[i];
		}
		return list;
	}*/
	
	public void getAlllist() {
		for (String city : list) {
			System.out.println(city);
		}
	}
	
	public boolean contain(String item) {
		boolean result = false;
		for (int i = 0; i < list.length; i++) {
			if (list[i] != item) 
				result = true;
			else 
				result = false;
			break;
			
		}
		return result;
	}
	
	public String get(int index) {
		return list[index];
	}
	
	public void remove(int index) {
		String[] newList = new String[list.length];
		for (int i = 0; i < newList.length; i++) {
			newList[i] = list[i];
		}
		list = new String[newList.length - 1];
		int counter = 0;
		for (int i = 0; i < list.length; i++) {
			if (i == index) {
				continue;
			}else {
				list[counter] = newList[i];
			}
			counter++;
		}
		
	}
	
	public void remove(String city) {
		String[] newList = new String[list.length];//102
		for (int i = 0; i < newList.length; i++) {
			newList[i] = list[i];
		}
		
		for (int i = 0; i < newList.length; i++) {
			if (newList[i] == city) {
				newList[i] = null;
			}else {
				continue;
			}
		}
		
		list = new String[newList.length - 1];
		for (int i = 0; i < list.length; i++) {
			if (newList[i] == null) {
				continue;
			}
			else {
				list[i] = newList[i];
			}
		}
	
	}
	
}
