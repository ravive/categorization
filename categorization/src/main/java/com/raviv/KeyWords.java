package com.raviv;

import org.apache.log4j.Logger;

import java.util.*;

public class KeyWords {

    Map<String,KeyWords> wordsBreakDown;
    private Set<String> keywords;

    final static Logger logger = Logger.getLogger(KeyWords.class);

    public KeyWords(List<String> keywords)  {
        this();
        this.keywords = new TreeSet<>(String.CASE_INSENSITIVE_ORDER);
        this.keywords.addAll(keywords);

        keywords.forEach(x -> {
            add(Arrays.asList(x.split(" ")));
        });
    }

    private KeyWords() {
        wordsBreakDown = new  TreeMap<>(String.CASE_INSENSITIVE_ORDER);
    }

    private void add(List<String> keyWord) {

        String word = keyWord.get(0);
        if (!wordsBreakDown.containsKey(word)) {
            logger.debug(("add word to key words : "+word));
            wordsBreakDown.put(word,new KeyWords());
        }

        if (keyWord.size() == 1)
            return;

        ArrayList<String> newWord = new ArrayList<>(keyWord.subList(1, keyWord.size()));
        logger.debug("adding next word for "+word);
        wordsBreakDown.get(word).add(newWord);
    }

    private StringBuilder get(List<String> text) {

        if (text.size() == 0)
            return  new StringBuilder();

        KeyWords keyWords = wordsBreakDown.get(text.get(0));
        if (keyWords == null)
            return new StringBuilder();

        StringBuilder sb  = keyWords.get(text.subList(1, text.size()));
        return sb.length() > 0 ?  sb.insert(0," ").insert(0,text.get(0)) :  sb.insert(0,text.get(0));
    }

    /**
     * search for key words in the text and if found
     * return them and remove them from the list
     * @param text
     * @return key word found in the text
     */
    public String getKeyWord(LinkedList<String> text) {
        String keyword = get(text).toString();
        return  this.keywords.contains(keyword) ? keyword : null;
    }





}



