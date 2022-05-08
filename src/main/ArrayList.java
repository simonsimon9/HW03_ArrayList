package main;


public class ArrayList<T> implements List<T> {
	private static final int DEFAULT_INITIAL_CAPACITY = 4;
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
	public void regrow() {
		@SuppressWarnings("unchecked")
		T[] growArray = (T[]) new Object[this.data.length * 2];
		for(int i = 0; i< data.length;i++) {
			growArray[i] = data[i];
		}
		
		this.data = growArray;
	}
	@Override
	public void add(T item, int index) {
		// TODO Auto-generated method stub
		size++;
		if(index < 0 || index >= data.length) {
			System.out.println("nata");
		
		}else if(data[data.length-1] != null || data[index] != null || size > data.length) {
			
			regrow();
			for(int i = data.length - 1; index < i; i--) {
				data[i] = data[i-1];
			}
			data[index] = item;
			
		}else {
			data[index] = item;
		}
		
		
	}

	@Override
	public void clear() {
		// TODO Auto-generated method stub
		for(int i = 0; i < data.length; i++) {
			data[i] = null;
		}
	}

	@Override
	public boolean contains(Object item) {
		// TODO Auto-generated method stub
		for(int i = 0; i<data.length;i++) {
			if(data[i].equals(item)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public T get(int index) {
		// TODO Auto-generated method stub
		if(data[index].equals(null)) {
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
		ArrayList<Integer> hi = new ArrayList<>();
		hi.add(1, 0);
		hi.add(2, 1);
		hi.add(3, 2);
		hi.add(4,3);
		hi.check();
		hi.add(5, 3);
		hi.add(10, 0);
		hi.add(20,15);
		//hi.add(19, 14);
		hi.check();
		
		
	}

}
