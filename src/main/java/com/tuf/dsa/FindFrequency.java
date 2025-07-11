package com.tuf.dsa;

import java.util.*;

public class FindFrequency {

    public static void find() {
       List<Integer> list = Arrays.asList(1,3,2,1,3);
       List<Integer> numbersToFind = Arrays.asList(1,4,2,3,12);


       // list.stream()
          //     .map(n-> Collections.frequency(list,n)).collect(Collectors.toMap(HashMap::new));
        // Step 1: Find max number to size the frequency list
        int max = Collections.max(list);

        // Step 2: Create frequency list with size max+1, initialized to 0
        List<Integer> frequency = new ArrayList<>(Collections.nCopies(max + 1, 0));
        // Step 3: Update frequency counts at respective index
        for (int num : list) {
            frequency.set(num, frequency.get(num) + 1);
        }

        // Step 4: Print frequency by index
        for (int i = 0; i < frequency.size(); i++) {
            System.out.println("Number " + i + " occurred " + frequency.get(i) + " time(s).");
        }

        // Example: get count at index 3
        System.out.println("Frequency of 3 is: " + frequency.get(3));

    }

    public static void hashChars() {
      String str= "abcdacfe";

        Map<Character,Integer> map = new HashMap<>();


      for (int i=0;i< str.length();i++){
          map.put(str.charAt(i),map.getOrDefault(str.charAt(i),0)+1);
      }
        System.out.println(map.get('f'));
    }

    public static void findHighestFreqNum() {

        List<Integer> list = Arrays.asList(1, 1, 2, 2, 3, 3, 3);

        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < list.size(); i++) {
            map.put(list.get(i), map.getOrDefault(list.get(i), 0) + 1);
        }
      Optional<Map.Entry<Integer, Integer>> max=   map.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
    if(max.isPresent()){
        System.out.println(max.get().getValue());
    }

    }
}
