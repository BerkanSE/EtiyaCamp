import java.util.ArrayList;

public class MyList<T>  {
		
		Object[] items;
	
		public MyList() {
			items = new Object[0] ; 
		}

		public void add(Object item) {
			Object[] tempArray = items; //101
			items = new Object[items.length + 1]; //102
			
			for (int i = 0; i < tempArray.length; i++) {
				items[i] = tempArray[i];
			}
			
			items[items.length - 1] = item;
	    }

	    public void remove(Object item) {
	    	
	    	for (int i = 0; i < items.length; i++) {
				if (items[i] == item) {
					Object a = items[i];
					items[i ] = items[items.length - 1 ]  ;
					items[items.length - 1] = a;	
				}
			}
	    	
	    	Object[] tempArray = new Object[items.length - 1];
	    	for (int i = 0; i < items.length-1; i++) {
	    		
	    		tempArray[i] = items[i];
	    		
	    	}
	    	items = tempArray;
	
	    }
	    
	    public void remove(int index) {
	    	for (int i = 0; i < items.length; i++) {
				if (items[i] == items[index]) {
					Object a = items[i];
					items[i ] = items[items.length - 1 ]  ;
					items[items.length - 1] = a;	
				}
			}
	    	Object[] tempArray = new Object[items.length - 1];
	    	for (int i = 0; i < items.length-1; i++) {
	    		
	    		tempArray[i] = items[i];
	    		
	    	}
	    	items = tempArray;
	    }
	    
	    public void list() {
	        for (Object object : items ) {
				System.out.println(object);
			}
	    }
	    
	    public boolean contains(Object item) {
	        for (int i = 0; i <items.length; i++) {
			if (items[i] == item) {
				return true;
			}	
			}
	        return false;
	    }
}
