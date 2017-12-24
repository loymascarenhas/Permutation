import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

public class Main {
	static int count = 0;
	static Set<ArrayList<Integer>> set;
	
	public static void main(String[] args) {
		set = new HashSet<ArrayList<Integer>>();
		ArrayList<Integer> listElem;
		ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();
		listElem = new ArrayList<Integer>();
		listElem.add(1);
		listElem.add(2);
		listElem.add(3);
		list.add(listElem);
		listElem = new ArrayList<Integer>();
		listElem.add(4);
		list.add(listElem);
		listElem = new ArrayList<Integer>();
		listElem.add(5);
		listElem.add(6);
		list.add(listElem);
		ArrayList<Integer> prefixElem = new ArrayList<Integer>();
		permute(prefixElem, list, list.size());
		Iterator<ArrayList<Integer>> iter = set.iterator();
		while(iter.hasNext()) {
			count++;
			System.out.println(iter.next());
		}

		System.out.println("Count: " + count);
	}
	
	static void permute(ArrayList<Integer> prefix, List<ArrayList<Integer>> list, int listSize) {
		if(listSize == prefix.size()) {
			set.add(prefix);
		}
		else {
			for(int i=0; i<list.size(); i++) {
				ArrayList<Integer> tempPrefix = list.get(i);
				for(int j=0; j<tempPrefix.size(); j++) {
					ArrayList<Integer> newPrefix = new ArrayList<Integer>();
					newPrefix.addAll(prefix);
					newPrefix.add(tempPrefix.get(j));
					permute(newPrefix, list.subList(i+1, list.size()), listSize);
				}
			}
		}
	}
}
