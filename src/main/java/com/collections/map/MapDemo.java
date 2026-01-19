package com.collections.map;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiFunction;

public class MapDemo {
    /*
            - What is a Map?
                - collection which stores(key, value) pairs
                - two implementations of Maps include
                    - HashMap
                        - order doesn't matter
                        - same amount of time to add and get element
                    - TreeMap
                        - order is preserved
                        - takes more time to add elements as map gets bigger

            - Map methods

                    Method                                                      Description
                    ======================================================================================
                    clear()                                                     clears the map
                    containsKey(Object key)                                     checks if the key is in the map
                    containsValue(Object value)                                 checks if the value is in the map
                    entrySet()                                                  returns Set of k/v pairs
                    forEach()                                                   loops through k/v pairs
                    get(Object key)                                             returns value mapped with key or null if none exists
                    getOrDefault(Object key, V defaultValue)                    same as get, but return defaultValue if jey doesn't exist
                    isEmpty()                                                   checks if map is empty
                    keySet()                                                    returns Set of all keys
                    merge(K key, V value, BiFunction<T,U,V> func)               sets value if key doesn't exist, runs func if key is set to determine new val, removes if val is nill
                    put(K key, V value)                                         adds or replaces k/v pair, returns prev value or null
                    putIfAbsent(K key, V value)                                 if key is not present, adds value and returns null (otherwise, returns the existing value)
                    remove(Object key)                                          removes and returns value mapped to key, or null of none exists
                    replace(K key, V value)                                     replaces value for given key if key is set, returns original value or null if none exists
                    replaceAll(BiFunction<T,U,V> func)                          replaces each value with results of function
                    size()                                                      returns number of k/v pairs in map
                    values                                                      returns Collection of values

     */

    public static void main(String[] args) {
        Map<Integer, String> names = Map.of(1, "John", 2, "George", 3, "Luke");
        System.out.println(names);
        names = new HashMap<>();
        names = Map.ofEntries(
                Map.entry(1, "John"),
                Map.entry(2, "George"),
                Map.entry(3, "Luke")
        );
        System.out.println(names);

        Map<Integer, String> names1 = new HashMap<>();
        names1.put(1, "John");
        names1.put(2, "George");
        names1.put(3, "Luke");
        String myName = names1.get(-2);
        System.out.println(myName);

        // loop over names
        for (Integer k : names1.keySet()) {
            System.out.println("key: " + k + ", " + "value: " + names1.get(k));
        }

        // using forEach
        names1.forEach((k, v) -> System.out.println("key: " + k + ", " + "value: " + v));

        // just values
        names1.values().forEach(System.out::println);

        // using entrySet
        names1.entrySet().forEach(e -> System.out.println("key: " + e.getKey() + ", " + "value: " + e.getValue()));

        // getOrDefault()
        myName = names1.get(-2);
        System.out.println(myName); // null
        myName = names1.getOrDefault(-2, "Default value");
        System.out.println(myName);

        // replace()
        myName = names1.replace(1, "Paul");
        System.out.println(myName);

        // putIfAbsent()
        names1.putIfAbsent(10, "Ringo");
        names1.putIfAbsent(1, "James");
        System.out.println(names1);

        // merge()
        // insert name only of it is longer than the original name
        BiFunction<String, String, String> myBiFunc = (s1, s2) -> s1.length() < s2.length() ? s1 : s2;
        names1.merge(1, "Joe", myBiFunc);
        names1.merge(2, "Lucas", myBiFunc);
        names1.merge(3, "Paul", myBiFunc);
        System.out.println(names1);
    }
}
