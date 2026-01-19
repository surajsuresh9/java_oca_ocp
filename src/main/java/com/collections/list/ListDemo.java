package com.collections.list;

import com.class_design.inheriting_methods.A;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ListDemo {
    /*
            - What is List?
                - an ordered collection which can contain duplicate entries
                - items can be reached and inserted using index (int)
                - unlike array, list can change in size after being declared
                - there are 2 classes which implement List interface
                    - ArrayList
                    - LinkedList
                - ArrayList is better when you read more than you write
                - LinkedList implements both List and Deque

            - List Methods
                - add(E element)
                - add(int index, E element)
                - get(int index)
                - remove(int index)
                - remove(E element)
                - replaceAll(UnaryOperator<E> op)
                - set(int index, E element)
                - sort(Comparator <? super E> c)

     */

    /*
        - Creating a List using Factory methods
                - Arrays.asList(varargs)
            - fixed size list backed by an array
                - List.of(varargs)
            - returns immutable list
                - List.copyOf(collection)
            - immutable list with copy of original values
                - when List is created using factory methods, the size of the list is fixed (no adding or removing)

    */
    public static void main(String[] args) {
        String[] names = new String[]{"John", "George", "Luke"};
        List<String> namesAsList = Arrays.asList(names);
        List<String> namesOf = List.of(names);
        List<String> namesCopyOf = List.copyOf(namesAsList);

        names[1] = "Ben";
        System.out.println(namesAsList); // [John, Ben, Luke], because list is 'backed' by array
        System.out.println(namesOf); // [John, George, Luke], no change in list
        System.out.println(namesCopyOf); // [John, George, Luke], no change in list

        // backing up works both ways
        System.out.println("========================");
        names = new String[]{"John", "George", "Luke"};
        namesAsList = Arrays.asList(names);
        System.out.println(namesAsList);
        namesAsList.set(2, "Paul");
        System.out.println(namesAsList); // [John, George, Paul]
        System.out.println(Arrays.toString(names)); // [John, George, Paul]

        // when you have a list backed by the array (Arrays.asList)
        // the change in one results with change in another

        // list created by factory method has a fixed size!
        String[] names1 = new String[]{"John", "George", "Luke"};
        List<String> namesAsList1 = Arrays.asList(names1);
        List<String> namesOf1 = List.of(names1);
        List<String> namesCopyOf1 = List.copyOf(namesAsList1);

//        namesOf1.add("Mike"); // Immutable object is modified (UnsupportedOperationException is thrown)
//        namesOf1.remove("John"); // Immutable object is modified (UnsupportedOperationException is thrown)

        /*
                creating a List with a constructor

         */

        List<String> myList1 = new ArrayList<>();// creates new empty List myList1
        List<String> myList2 = new ArrayList<>(myList1);// makes a copy myList1 and stores in myList2

        ArrayList<String> myList3 = new ArrayList<>();// creates new empty ArrayList myList3
        ArrayList<String> myList4 = new ArrayList<>(myList1);// makes a copy myList3 and stores in myList4

        // List Methods
        List<String> myNames = new ArrayList<>();
        myNames.add("John");
        myNames.add("George");
        myNames.add("Paul");
        myNames.add("Ringo");
        System.out.println(myNames);
        myNames.add(1, "Luke");
        System.out.println(myNames);
        System.out.println(myNames.get(0));
        myNames.set(3, "Ben");
        System.out.println(myNames);
        myNames.remove(1);
        System.out.println(myNames);
        myNames.remove("Ben");
        System.out.println(myNames);
        myNames.replaceAll(s -> s + "A.");
        System.out.println(myNames);

        // 2 ways of using remove()
        List<Integer> nums = new ArrayList<>();
        nums.add(2);
        nums.add(-11);
        nums.add(7);
        System.out.println(nums);
        nums.remove(2); // since 2 is primitive, remove(int index) will be used, 7 will be removed
        System.out.println(nums);
        nums.remove(Integer.valueOf(2)); // now arg is an Object, remove(E element) will be used, 2 will be removed
        System.out.println(nums);

        // converting List to Array using toArray()
        nums.clear();
        nums.add(2);
        nums.add(-11);
        nums.add(7);
        Object[] myArr = nums.toArray(); //array of objects in the list
        System.out.println(Arrays.toString(myArr));

        Integer[] myArr1 = nums.toArray(new Integer[0]); // array of integers
        // initial size is 0, but Java will automatically adjust sizes to fit

    }
}
