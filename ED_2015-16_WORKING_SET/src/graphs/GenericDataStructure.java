package graphs;
import java.util.Collections;
import java.util.LinkedList;


public class GenericDataStructure<T extends Comparable<T>> {
	
	private LinkedList<T> collection;
	
	public void add(T e) {
		if(collection == null)
			collection = new LinkedList<T>();
		collection.add(e);
	}
	
	public String toString() {
		sort();
		StringBuilder aux = new StringBuilder();
		for(T s : collection)
			aux.append(s.toString()+".");
		return aux.toString();
	}
	
	public int CompateTwoElements(int firstPos, int secondPos) {
		return (collection.get(firstPos).compareTo(collection.get(secondPos)));
	}
	
	private void sort() {
		Collections.sort(collection);
	}

}
