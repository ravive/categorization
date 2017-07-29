package com.raviv;
import java.util.*;


public class Categories {

    KeyWords keyWords;

    public Categories(KeyWords keyWords) {
        this.keyWords = keyWords;
    }

    /**
     * execute the categories
     * @param text
     * @return map to keyword and the index in the text
     */
    public Map<String,Integer> execute(String text) {

        if (text == null)
            return Collections.emptyMap();

        LinkedList<String> spitedText = new LinkedList<>();
        spitedText.addAll(Arrays.asList(text.split(" ")));
        Map<String,Integer> result = new HashMap<>();
        int currentIndex = 0;

        while (!spitedText.isEmpty()) {

            String keyWord = keyWords.getKeyWord(spitedText);
            if (keyWord != null)
                result.put(keyWord, currentIndex);

            String wordToRemove = keyWord == null ? spitedText.getFirst() : keyWord;
            spitedText.subList(0, wordToRemove.split(" ").length).clear();
            currentIndex = currentIndex + wordToRemove.length() +1;

        }

        return result;
    }


}
