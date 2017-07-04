package com.example.stuartbryce.whatthedickens;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static com.example.stuartbryce.whatthedickens.StringDoer.orderHashMap;
import static org.junit.Assert.assertEquals;

/**
 * Created by stuartbryce on 2017-07-03.
 */

public class WhatTheTestings {

    String sentence;
    String sentence2;

    @Before
    public void before(){
        sentence = "I am a goat and i live in a house";
        sentence2 = "It was the best of times, it was the worst of times, it was the age of wisdom, it was the age of foolishness, it was the epoch of belief, it was the epoch of incredulity";
    }

    @Test
    public void testWordCount(){
        assertEquals(10, StringDoer.countString(sentence));
    }

    @Test
    public void testHashMapper(){
        HashMap<String,Integer> expectedHashMap = new HashMap<>(); 
        expectedHashMap.put("I", 1); 
        expectedHashMap.put("am", 1); 
        expectedHashMap.put("a", 2); 
        expectedHashMap.put("goat", 1); 
        expectedHashMap.put("and", 1); 
        expectedHashMap.put("i", 1); 
        expectedHashMap.put("live", 1); 
        expectedHashMap.put("in", 1); 
        expectedHashMap.put("house", 1); 
        String[] sentenceArray = StringDoer.stringSplitter(sentence);
        assertEquals(expectedHashMap, StringDoer.wordMap(sentenceArray));
    }

    @Test
    public void testOrderMap(){
        HashMap<String,Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("I", 1);
        expectedHashMap.put("am", 1);
        expectedHashMap.put("a", 2);
        String[] sentenceArray = StringDoer.stringSplitter(sentence2);
        HashMap<String, Integer> wordsmapped = StringDoer.wordMap(sentenceArray);
        assertEquals(expectedHashMap, orderHashMap(wordsmapped));
    }

    @Test
    public void testTreeMap(){
        HashMap<String,Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("I", 1);
        expectedHashMap.put("am", 1);
        expectedHashMap.put("a", 2);
        String[] sentenceArray = StringDoer.stringSplitter(sentence2);
        HashMap<String, Integer> wordsmapped = StringDoer.wordMap(sentenceArray);
        assertEquals(expectedHashMap, StringDoer.orderTreeMap(wordsmapped));
    }

    @Test
    public void testKeyValueString(){
        HashMap<String,Integer> expectedHashMap = new HashMap<>();
        expectedHashMap.put("I", 1);
        expectedHashMap.put("am", 1);
        expectedHashMap.put("a", 2);
        String[] sentenceArray = StringDoer.stringSplitter(sentence2);
        HashMap<String, Integer> wordsmapped = StringDoer.wordMap(sentenceArray);
        HashMap<String, Integer> sortedMap = StringDoer.orderHashMap(wordsmapped);
        assertEquals("whatever", StringDoer.printHashMap(sortedMap));
    }

    @Test
    public void testAllFunctionCall(){
        assertEquals("Wahtever", StringDoer.allFunctionCall(sentence2));
    }

}
