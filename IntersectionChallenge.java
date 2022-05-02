package po.week.one;
import java.util.*;

// + In order to determine if two singly lists intersect, we need to know if any of the pointers are identical.
// + This code compares each pointer from list1 against each pointer from list2 in order to identify any matches.

// * I couldn't figure out how to get the reference numbers directly from the linked list, so I will use the values as if they are the pointers.

public class IntersectionChallenge
{
    public static String Intersection(LinkedList<String> list1, LinkedList<String> list2) {
        
        String result = "";
		String spacer = "";

        //iterate through the first list
		for (int i = 0; i < list1.size(); i++) {
	        //iterate through the second list
			for (int j = 0; j < list2.size(); j++) {
				
				//compare each entry value*(should be pointer) in list1 against each entry value* in list2
				if (list1.get(i).equals(list2.get(j))) {
					//set variable "result" to the value where the intersection takes place
					result = result.concat(spacer + list1.get(i));
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
        
        list1.add("A");
        list1.add("B");
        list1.add("C");
        list1.add("D");
        list1.add("E");

        list2.add("D");
        list2.add("G");
        list2.add("H");
        list2.add("E");
        list2.add("J");

        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
        
        //Update list2 to remove duplicate value* "E"
        list2.set(3, "I");

        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
        
        //Update list2 to remove duplicate value* "D"
        list2.set(0, "F");
        
        //run the Intersection method to check for intersection between the lists
        System.out.println(Intersection(list1, list2));
    }
}