package po.week.one;

import java.util.*;

//+ In order to determine if a linked list is corrupted and loops, we need to know if any node has multiple pointers.
//+ This code compares each pointer from list1 against every other pointer from list1 in order to identify any duplicates.

// * I couldn't figure out how to get the reference numbers from the linked list, so I will use the values to store the IDs & Pointers.

public class LoopChallenge {
	public static String LoopDetection(LinkedList<String> list1) {

		String result = "";
		String spacer = "";
		int removeDuplicateComparisons = 1;

		// iterate through each entry in the list
		for (int i = 0; i < list1.size(); i++) {

			// iterate through each uncompared entry in the list
			for (int j = removeDuplicateComparisons; j < list1.size(); j++) {

				// select pointers from String
				String pointer1 = list1.get(i).substring(list1.get(i).indexOf("|") + 1, list1.get(i).length());
				String pointer2 = list1.get(j).substring(list1.get(j).indexOf("|") + 1, list1.get(j).length());

				// compare each entry pointer in list1 against every other pointer in list1
				if (pointer1.equals(pointer2)) {
					// set variable "result" to the duplicate pointer
					result = result.concat(spacer + pointer1);
					spacer = ",";
				}
			}
			removeDuplicateComparisons++;
		}

		if (result.equals("")) {
			return "No duplicate pointers*";
		} else if (result.contains(spacer)) {
			return "Ids with multiple pointers: " + result;
		} else {
			return "Id with multiple pointers: " + result;
		}
	}

	public static void main(String[] args) {

		// Add a linked list with a circular reference
		LinkedList<String> list1 = new LinkedList<String>();

		// * Organized as such: ID|Pointer
		list1.add("A|B");
		list1.add("B|C");
		list1.add("C|D");
		list1.add("D|E");
		list1.add("E|C");

		// run the Loop Detection method to check for multiple pointers
		System.out.println(LoopDetection(list1));

		// Update list1 to fix looping reference
		list1.set(4, "E|F");

		// run the Loop Detection method to check for multiple pointers
		System.out.println(LoopDetection(list1));
	}
}

/*
 * Challenge:  
 *
 * b) Loop Detection: Given a circular linked list, implement an algorithm that
 * returns the node at the beginning of the loop. DEFINITION: Circular linked
 * list: A (corrupt) linked list in which a node's next pointer points to an
 * earlier node, so as to make a loop in the linked list. EXAMPLE Input: A -> B
 * -> C -> D -> E -> C [the same C as earlier] Output: C
 */