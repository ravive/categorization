package com.raviv;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

public class KeyWordsTest {

    @Test
    public void findTheRightKeyWordWhenWithContainWord() {
        KeyWords keyWords = new KeyWords(Arrays.asList("Dog","Big dog"));
        System.out.print(keyWords.toString());
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("big dog over there with other dog".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("big dog"));
    }

    @Test
    public void findTheRightKeyWordWhenWordIsLast() {
        KeyWords keyWords = new KeyWords(Arrays.asList("dog","big dog"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("dog".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("dog"));
    }

    @Test
    public void findTheRightKeyWordWithThreeContainWord() {
        KeyWords keyWords = new KeyWords(Arrays.asList("Big Data","Big Data Analytics"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big Data Analytics with Big Data".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("Big Data Analytics"));
    }

    @Test
    public void findTheSingleKeyWordWithThreeContainWord() {
        KeyWords keyWords = new KeyWords(Arrays.asList("Big Data","Big Data Analytics"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big Data".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("Big Data"));
    }

    @Test
    public void notFindInvalidKeyWords() {
        KeyWords keyWords = new KeyWords(Arrays.asList("Big Data"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big People".split(" ")));
        Assert.assertTrue(keyWords.getKeyWord(t) == null);
    }

}
