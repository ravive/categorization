package com.raviv;

import java.util.List;

/**
 * Created by ravive on 29/07/2017.
 */
public class KeyWordFactoryImpl implements KeyWordsFactory {
    @Override
    public KeyWords create(List<String> keywords) {
        return new KeyWordsImpl(keywords);
    }
}
