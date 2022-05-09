package main;


public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 11;
	private T[] data;
	private int size;

	/**
	 * Constructs an ArrayList using the default capacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayList() {
		// TODO Complete Constructor
		this.size = 0;
		this.data = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
	}

	/**
	 * Constructs an ArrayList with an 'initialCapacity'
	 * 
	 * If 'initalCapacity' is non-positive use the default capacity
	 * 
	 * @param initialCapacity
	 */
	@SuppressWarnings("unchecked")
	public ArrayList(int initialCapacity) {
		this.size = 0;
		if(initialCapacity < 0) {
			this.data = (T[]) new Object[DEFAULT_INITIAL_CAPACITY];
		}else {
			this.data = (T[]) new Object[initialCapacity];

		}

	}
	/**
	 * Create a new array that is twice the length of current array. 
	 * Method copies over the old array to the new array. 
	 */
	public void regrow() {
		@SuppressWarnings("unchecked")
		T[] growArray = (T[]) new Object[this.data.length * 2];
		for(int i = 0; i< data.length;i++) {
			growArray[i] = data[i];
		}
		
		this.data = growArray;
	}
	/**
	* Method adds an item at index position. 
	* There are several edge cases to consider before adding item.
	* 
	* For first case, if the parameter index is negative or greater 
	* than the array, method will do nothing.
	* 
	* For second case, if the array is not full and the parameter 
	* index is empty in the array, the method will 
	* add the item to the index position. 
	* 
	* For third case, if the last index position is empty and there's
	* no item already in the parameter index, then shift all items
	* to the right by 1 position. At the position index, add the item. 
	* 
	* For all other cases, call the method regrow for a new array that 
	* is double the size. Shift all the items to the right, and add
	* the item to the index position. 
	* 
	* @param item   the element to be added to array
	* @param index index of array where new element is added.
	*/

	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		int lastElement = data.length - 1;
		
		if(index < 0 || index >= data.length) {
			// do nothing
		
		}else if(size <= data.length && data[index] == null) {
			data[index] = item;
			size++;
		}else if(data[lastElement] == null && data[index] != null) {
			for(int i = data.length - 1; index < i; i--) {
				data[i] = data[i-1];
			}
			data[index] = item;
			size++;
		}
		else {
			regrow();
			for(int i = data.length - 1; index < i; i--) {
				data[i] = data[i-1];
			}
			data[index] = item;
			size++;
		}
		
		
	}
	/**
	 * Method for loops through the entire array and replaces the indexes with null. 
	 */
	@Override
	public void clear() {
		for(int i = 0; i < data.length; i++) {
			data[i] = null;
		}
	}
	/**
	* Method searches each index in the array until it finds the item
	* 
	* @param item the item 
	* @return if item is found in the array
	*/

	@Override
	public boolean contains(Object item) {
		for(int i = 0; i<data.length;i++) {
			if(data[i]==null) {
				//do nothing if null
			}
			else if(data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}
	/**
	* Method gets the element from array
	* @param index    the index of the element 
	* @return the element from index
	*/

	@Override
	public T get(int index) {
		if(data[index] == null) {
			return null;
		}else {
			return data[index];
		}
		
		
	}
	/**
	* Method searches the array for item and return index of the element
	* 
	* @param item the item needed to be found for the index 
	* @return index of the item
	*/

	@Override
	public int indexOf(Object item) {
		
		for(int i = 0; i < data.length; i++) {
			if(data[i] == item) {
				return i;
			}
		}
		return -1;
	}
	/**
	* Method checks if the array has any elements
	* @return true or false if array is empty
	*/

	@Override
	public boolean isEmpty() {
		
		if(this.size == 0) {
			return true;
		}else {
			return false;
		}
		
	}
	/**
	* method returns the size of array
	*/

	@Override
	public int size() {
		return this.size;
	}
	
	/* used for testing
	
	public void check() {
		// TODO Auto-generated method stub
		System.out.println("\nCheck:");
		for(int i =0 ; i<data.length; i++) {
			if(data[i] == null) {
				System.out.print("n ");
			}else {
				System.out.print(data[i]+" ");

			}
			
		}
		
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		ArrayList<String> hi = new ArrayList<>();
		hi.add("hey",1);
		
		System.out.println(hi.indexOf(5));
		hi.check();
		
		
	}*/

}
