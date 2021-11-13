
public class MyHashMap<K,V> {
	Object[] keysArray;
	Object[] valuesArray;
	Object[] array;

	public MyHashMap() {
		this.array = new Object[0];
		this.keysArray = new Object[0];
		this.valuesArray = new Object[0];
	}

	public void put(K key, V value) {
		Object[] tempArray = new Object[array.length + 1];

		for (int i = 0; i < tempArray.length - 1; i++) {
			tempArray[i] = array[i];
		}

		Object[] tempKeysArray = new Object[array.length + 1];

		for (int i = 0; i < tempKeysArray.length - 1; i++) {
			tempKeysArray[i] = keysArray[i];
		}

		Object[] tempValuesArray = new Object[array.length + 1];

		for (int i = 0; i < tempValuesArray.length - 1; i++) {
			tempValuesArray[i] = valuesArray[i];
		}

		tempArray[tempArray.length - 1] = key + "=" + value;
		tempKeysArray[tempArray.length - 1] = key;
		tempValuesArray[tempArray.length - 1] = value;

		array = new Object[tempArray.length];

		for (int i = 0; i < tempArray.length; i++) {
			array[i] = tempArray[i];
		}

		keysArray = new Object[tempKeysArray.length];

		for (int i = 0; i < tempKeysArray.length; i++) {
			keysArray[i] = tempKeysArray[i];
		}

		valuesArray = new Object[tempValuesArray.length];

		for (int i = 0; i < tempValuesArray.length; i++) {
			valuesArray[i] = tempValuesArray[i];
		}
	}

	public Object get(K key) {
		int x = 0;
		for (int i = 0; i < keysArray.length; i++) {
			if (key == keysArray[i]) {
				x = i;
				break;
			}
		}
		for (int i = 0; i < valuesArray.length; i++) {
			if (x == i) {
				return valuesArray[i];
			}
		}
		return null;
	}

	public void remove(K key) {
		Object[] tempArray = new Object[array.length];
		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i];
		}
		Object[] tempKeysArray = new Object[keysArray.length];

		for (int i = 0; i < tempKeysArray.length; i++) {
			tempKeysArray[i] = keysArray[i];
		}
		Object[] tempValuesArray = new Object[valuesArray.length];

		for (int i = 0; i < tempValuesArray.length; i++) {
			tempValuesArray[i] = valuesArray[i];
		}

		int x = 0;
		int y = -1;
		while (x < keysArray.length) {
			if (keysArray[x] == key) {
				y = x;
				break;
			} else {
				x++;
				continue;
			}
		}

		if (y != -1) {
			keysArray = new Object[tempKeysArray.length - 1];
			int a = 0;
			for (int i = 0; i < keysArray.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					keysArray[a] = tempKeysArray[i];
					a++;
				}
			}
			valuesArray = new Object[tempValuesArray.length - 1];
			a = 0;
			for (int i = 0; i < valuesArray.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					valuesArray[a] = tempValuesArray[i];
					a++;
				}
			}
			array = new Object[tempArray.length - 1];
			a = 0;
			for (int i = 0; i < array.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					array[a] = tempArray[i];
					a++;
				}
			}
		}

	}

	public void remove(K key, V value) {
		Object[] tempArray = new Object[array.length];

		for (int i = 0; i < tempArray.length; i++) {
			tempArray[i] = array[i];
		}
		Object[] tempKeysArray = new Object[keysArray.length];

		for (int i = 0; i < tempKeysArray.length; i++) {
			tempKeysArray[i] = keysArray[i];
		}
		Object[] tempValuesArray = new Object[valuesArray.length];

		for (int i = 0; i < tempValuesArray.length; i++) {
			tempValuesArray[i] = valuesArray[i];
		}

		int x = 0;
		int y = -1;
		while (x < keysArray.length) {
			if (keysArray[x] == key && valuesArray[x] == value) {
				y = x;
				break;
			} else {
				x++;
				continue;
			}
		}

		if (y != -1) {
			keysArray = new Object[tempKeysArray.length - 1];
			int a = 0;
			for (int i = 0; i < keysArray.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					keysArray[a] = tempKeysArray[i];
					a++;
				}
			}
			valuesArray = new Object[tempValuesArray.length - 1];
			a = 0;
			for (int i = 0; i < valuesArray.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					valuesArray[a] = tempValuesArray[i];
					a++;
				}
			}
			array = new Object[tempArray.length - 1];
			a = 0;
			for (int i = 0; i < array.length + 1; i++) {
				if (i == y) {
					continue;
				} else {
					array[a] = tempArray[i];
					a++;
				}
			}
		}

	}

	public int size() {
		return array.length;
	}

	public void clear() {
		array = new Object[0];
		keysArray = new Object[0];
		valuesArray = new Object[0];
	}

	public void list() {
		System.out.print("{");
		for (int i = 0; i < array.length; i++) {
			System.out.print(array[i] + " ");
		}
		System.out.println("}");
	}

}
