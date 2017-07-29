package com.raviv;

import org.apache.log4j.Logger;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

/**
 * Created by ravive on 28/07/2017.
 */
public class FileKeyWordResource implements KeyWordResource {

    private final static Logger logger = Logger.getLogger(FileKeyWordResource.class);
    private String name;
    private KeyWordsFactory keyWordsFactory;

    FileKeyWordResource(KeyWordsFactory keyWordsFactory, String name) {
      this.name = name;
      this.keyWordsFactory = keyWordsFactory;
    }

    @Override
    public KeyWords get() {

        try {
            List<String> words = Files.readAllLines(
                            Paths.get(this.getClass().getResource(name).toURI()), Charset.defaultCharset());
            return keyWordsFactory.create(words);
        } catch (Exception e) {
            logger.error("failed to load key words with error ",e);
            throw new RuntimeException(e);
        }

    }
}
