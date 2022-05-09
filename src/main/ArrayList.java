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
	 * method adds an element at index.
	 * if the index is larger then array size or index is less than 0, the method does nothing.
	 * 
	 * @param item   	the element to be added to array
	 * @param index		index of array where new element is added.
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

	@Override
	public T get(int index) {
		if(data[index] == null) {
			return null;
		}else {
			return data[index];
		}
		
		
	}

	@Override
	public int indexOf(Object item) {
		
		for(int i = 0; i < data.length; i++) {
			if(data[i] == item) {
				return i;
			}
		}
		return -1;
	}

	@Override
	public boolean isEmpty() {
		
		if(this.size == 0) {
			return true;
		}else {
			return false;
		}
		
	}

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
