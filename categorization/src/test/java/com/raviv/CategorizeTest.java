package com.raviv;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Map;

/**
 * Created by ravive on 28/07/2017.
 */
public class CategorizeTest {

    KeyWords keyWords = new KeyWords(Arrays.asList("President" ,
            "vice President" ,
            "Sales" ,
            "Marketing" ,
            "IT" ,
            "CFO" ,
            "CTO" ,
            "Banking" ,
            "eCommerce"));

    @Test
    public void shouldCategorizeByKeyWords() {
        Categories categorize = new Categories(keyWords);
        Map<String,Integer> result =  categorize.execute("Vice President of Sales and Marketing");
        Assert.assertTrue("expected 3 elements in array",result.size() == 3);
        Assert.assertTrue(result.containsKey("Marketing"));
        Assert.assertTrue(result.containsKey("Vice President"));
        Assert.assertTrue(result.containsKey("Sales"));
        Assert.assertTrue(result.get("Marketing") == 28);
        Assert.assertTrue(result.get("Vice President") == 0);
        Assert.assertTrue(result.get("Sales") == 18);
    }

    @Test
    public void shouldnotFaildonlastwordwithpartialmatch() {
        Categories categorize = new Categories(keyWords);
        Map<String,Integer> result =  categorize.execute("Vice");
        Assert.assertTrue(result.size() == 0);
    }

    @Test
    public void shouldFindKeyWithPartialMatch() {
        Categories categorize = new Categories(keyWords);
        Map<String,Integer> result =  categorize.execute("Vice Marketing");
        Assert.assertTrue(result.size() == 1);
        Assert.assertTrue(result.get("Marketing") == 5);
    }

    @Test
    public void shouldNotFailedOnNullEntry() {
        Categories categorize = new Categories(keyWords);
        Map<String,Integer> result =  categorize.execute(null);
        Assert.assertTrue(result.size() == 0);
    }
}
