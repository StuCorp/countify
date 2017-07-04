package com.example.stuartbryce.whatthedickens;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.TreeMap;

import static android.R.attr.key;
import static junit.framework.Assert.assertEquals;

/**
 * Created by stuartbryce on 2017-07-03.
 */

public class StringDoer {

    public static int countString(String sentence) {
        String[] words = sentence.split("\\s");
        return words.length;
    }

    public static String[] stringSplitter(String sentence) {
        String[] words = sentence.split("\\s");
        return words;
    }

    public static HashMap<String, Integer> wordMap(String[] words) {
        HashMap<String, Integer> wordsmapped = new HashMap<>();
        for (String word : words) {
            if (wordsmapped.containsKey(word)) {
                wordsmapped.put(word, wordsmapped.get(word) + 1);
            } else {
                wordsmapped.put(word, 1);
            }
        }
        return wordsmapped;
    }


    public static HashMap<String, Integer> orderHashMap(HashMap<String, Integer> wordsMapped) {
        HashMap<String, Integer> sortedMap = new HashMap<>();
        String highestKey = (String) wordsMapped.keySet().toArray()[0];
        while (sortedMap.size() < wordsMapped.size()) {
            for (String key : wordsMapped.keySet()) {
                if (wordsMapped.get(key) > wordsMapped.get(highestKey)) {
                    highestKey = key;
                }
            }
            sortedMap.put(highestKey, wordsMapped.get(highestKey));
            wordsMapped.put(highestKey, 0);
        }
        return sortedMap;
    }

    public static TreeMap<String, Integer> orderTreeMap(HashMap<String, Integer> wordsMapped) {
        TreeMap<String, Integer> sortedMap = new TreeMap<>();
        String highestKey = (String) wordsMapped.keySet().toArray()[0];
        while (sortedMap.size() < wordsMapped.size()) {
            for (String key : wordsMapped.keySet()) {
                if (wordsMapped.get(key) > wordsMapped.get(highestKey)) {
                    highestKey = key;
                }
            }
            sortedMap.put(highestKey, wordsMapped.get(highestKey));
            wordsMapped.put(highestKey, 0);
        }
        return sortedMap;
    }

    public static String printHashMap(HashMap<String, Integer> sortedMap) {
        String listOfKeys = new String();
        for (String key : sortedMap.keySet()) {
            Integer value = sortedMap.get(key);
            listOfKeys += String.format("%s : %d ", key, value);
        }
        return listOfKeys;
    }

    public static String allFunctionCall(String sentence) {
        String[] sentenceArray = StringDoer.stringSplitter(sentence);
        HashMap<String, Integer> wordsmapped = StringDoer.wordMap(sentenceArray);
        HashMap<String, Integer> sortedMap = StringDoer.orderHashMap(wordsmapped);
        String keyValueSentence = StringDoer.printHashMap(sortedMap);
        return keyValueSentence;
    }
}
