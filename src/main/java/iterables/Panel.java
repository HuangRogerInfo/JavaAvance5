package iterables;

import java.util.List;
import java.util.AbstractList;
import java.util.Iterator;
import java.util.NoSuchElementException;

public class Panel {
	
	public static Iterator<Integer> panel1(final int a, final int b) {
		return new Iterator<Integer>() {
			int i = a;
			
			public boolean hasNext() {
				return i <= b;
			}
			
			public Integer next() {
				if(!hasNext()) {
					throw new NoSuchElementException();
				}
				i++;
				return i;
			}
		};
	}
	
	public static Iterable<Integer> panel2(final int a, final int b){
		return new Iterable<Integer>() {

			public Iterator<Integer> iterator() {
				return new Iterator<Integer>() {
					int i = a;
					
					public boolean hasNext() {
						return i <= b;
					}
					
					public Integer next() {
						if(!hasNext()) {
							throw new NoSuchElementException();
						}
						int nb = i;
						i++;
						return nb;
					}
				};
			}
		};	
	}
	
	public static List<Integer> panel(final int a, final int b){
		
		if(!(b>=a)) {
			throw new IllegalArgumentException();
		}
		
		return new AbstractList<Integer>() {
			@Override
			public Integer get(int index) {
				int retour = a;
				for(int i = 0; i<index; i++) {
					retour++;
				}
				return retour;
			}

			@Override
			public int size() {
				// TODO Auto-generated method stub
				return b-a+1;
			}
			
		};
	}
	
	public static void main(String[] args) {
		 //Iterator<Integer> it=panel1(1,5);
		 //for(;it.hasNext();)
		 //System.out.println(it.next());
		 
		 //for(int i:panel2(1,5))
		 //System.out.println(i);
		 
		 List<Integer> l = panel(3,6);
		 for(int i:l) {
		 System.out.println(i);
		 }
		 System.out.println(l.get(1)); 

	}
}
