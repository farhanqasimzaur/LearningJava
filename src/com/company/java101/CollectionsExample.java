package com.company.java101;

import java.util.*;

public class CollectionsExample {

    LinkedHashMap<Character, Integer> objectData = new LinkedHashMap<>();
    Iterator iterate;

    public CollectionsExample() {
        HashMap result = alphabetCount("Zaira");
        System.out.println("Alphabet count: " +  result);
        System.out.println("Is Hell substring of Hello: " + isSubString("Hello", "hell"));
        System.out.println("Reverse of Hello is: " + reverseString("Hello"));
        cacheDataOnFIFO(result);

        HashMap map = new HashMap();
        map.put(1,'z');
        map.put(2, 'p');

        cacheDataOnFIFO(map);
        iterate = objectData.entrySet().iterator();

        System.out.println(firstCache());
        System.out.println(firstCache());
        System.out.println(firstCache());

    }

    HashMap<Character, Integer> alphabetCount(String word) {
        HashMap<Character, Integer> alphabetHash = new HashMap<Character, Integer>();
        for (int i = 0; i <word.length(); i++) {
           char c = word.charAt(i);
           if(alphabetHash.containsKey(c)){
              int value = alphabetHash.get(c);
              alphabetHash.replace(c, value);
           } else {
               alphabetHash.put(c, 1);
           }
        }
        return alphabetHash;
    }

    Boolean isSubString(String word, String subword) {
        word = word.toLowerCase();
        subword = subword.toLowerCase();
        HashSet<String> newWord = new HashSet<>(Arrays.asList(word));
        HashSet<String> newsubword = new HashSet<>(Arrays.asList(subword));

        return newWord.containsAll(newsubword);
    }

    String reverseString(String word) {
        ArrayList<String> reversedWord = new ArrayList<>(Arrays.asList(word));
        Collections.reverse(reversedWord);
        word = "";
        for (String character: reversedWord) {
            word += character;
        }
        return word;
    }

    void cacheDataOnFIFO(HashMap object) {
        objectData.putAll(object);
    }

    HashMap<Integer, String> firstCache(){
        Map.Entry<Integer, String> entry = null;
        if (iterate.hasNext()) {
            entry = (Map.Entry<Integer, String>) iterate.next();
        }
        HashMap<Integer, String> map = new HashMap<>();
        map.put(entry.getKey(), entry.getValue());
        return map;
    }
}
