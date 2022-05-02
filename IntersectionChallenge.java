package po.week.one;
import java.util.*;

// + In order to determine if two singly lists intersect, we need to know if any of the pointers are identical.
// + This code compares each pointer from list1 against each pointer from list2 in order to identify any matches.

// * I couldn't figure out how to get the reference numbers directly from the linked list, so I will use the values to store the IDs & Pointers.

public class IntersectionChallenge
{
    public static String Intersection(LinkedList<String> list1, LinkedList<String> list2) {
        
        String result = "";
		String spacer = "";

        //iterate through the first list
		for (int i = 0; i < list1.size(); i++) {
	        //iterate through the second list
			for (int j = 0; j < list2.size(); j++) {
				
				//select pointers from String
				String pointer1 = list1.get(i).substring(list1.get(i).indexOf("|")+1, list1.get(i).length());
				String pointer2 = list2.get(j).substring(list2.get(j).indexOf("|")+1, list2.get(j).length());
				
				//compare each entry value*(should be pointer) in list1 against each entry value* in list2
				if (pointer1.equals(pointer2)) {
					//set variable "result" to the value where the intersection takes place
					result = result.concat(spacer + pointer1);
					spacer = ",";
				}
			}
		}

		//return statement that indicates intersecting nodes, or that there are no intersections.
		if (result.equals("")) {
	        return "No identical pointers";
		} else if (result.contains(spacer)) {
	        return "Values of identical pointers: "+result;
		} else {
	        return "Value of identical pointers: "+result;
		}
    }
    public static void main (String[] args)
    {
        
    	//Add two linked lists and populate them
        LinkedList<String> list1 = new LinkedList<String>();
        LinkedList<String> list2 = new LinkedList<String>();

        // * Organized as such: ID|Pointer
        list1.add("A|B");
        list1.add("B|C");
        list1.add("C|D");
        list1.add("D|E");
        list1.add("E|F");

        list2.add("F|D"); // F|G
        list2.add("G|H");
        list2.add("H|I");
        list2.add("I|E"); // I|J
        list2.add("J|K");

        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
        
        //Update list2 to remove duplicate value* "E"
        list2.set(3, "I|J");

        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
        
        //Update list2 to remove duplicate value* "D"
        list2.set(0, "F|G");
        
        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
    }
}

/*
 * Challenge:
 * 
 * a) Intersection: Given two (singly) linked lists, determine if the two lists
 * intersect. Return the intersecting node. Note that the intersection is
 * defined based on reference, not value. That is, if the kth node of the first
 * linked list is the exact same node (by reference) as the jth node of the
 * second linked list, then they are intersecting.
 */