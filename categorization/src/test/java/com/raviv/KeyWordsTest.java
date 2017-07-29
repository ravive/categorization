package com.raviv;

import org.junit.Assert;
import org.junit.Test;
import java.util.Arrays;
import java.util.LinkedList;

public class KeyWordsTest {

    @Test
    public void findTheRightKeyWordWhenWithContainWord() {
        KeyWordsImpl keyWords = new KeyWordsImpl(Arrays.asList("Dog","Big dog"));
        System.out.print(keyWords.toString());
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("big dog over there with other dog".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("big dog"));
    }

    @Test
    public void findTheRightKeyWordWhenWordIsLast() {
        KeyWordsImpl keyWords = new KeyWordsImpl(Arrays.asList("dog","big dog"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("dog".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("dog"));
    }

    @Test
    public void findTheRightKeyWordWithThreeContainWord() {
        KeyWordsImpl keyWords = new KeyWordsImpl(Arrays.asList("Big Data","Big Data Analytics"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big Data Analytics with Big Data".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("Big Data Analytics"));
    }

    @Test
    public void findTheSingleKeyWordWithThreeContainWord() {
        KeyWordsImpl keyWords = new KeyWordsImpl(Arrays.asList("Big Data","Big Data Analytics"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big Data".split(" ")));
        Assert.assertTrue( keyWords.getKeyWord(t).equals("Big Data"));
    }

    @Test
    public void notFindInvalidKeyWords() {
        KeyWordsImpl keyWords = new KeyWordsImpl(Arrays.asList("Big Data"));
        LinkedList<String> t = new LinkedList<>();
        t.addAll(Arrays.asList("Big People".split(" ")));
        Assert.assertTrue(keyWords.getKeyWord(t) == null);
    }

}
