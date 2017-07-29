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

    final static Logger logger = Logger.getLogger(FileKeyWordResource.class);
    private String name;

    public FileKeyWordResource(String name) {
      this.name = name;
    }

    @Override
    public KeyWords get() {

        try {
            List<String> words = Files.readAllLines(
                            Paths.get(this.getClass().getResource(name).toURI()), Charset.defaultCharset());
            return new KeyWords(words);
        } catch (Exception e) {
            System.out.print(e.getStackTrace());
            logger.error("failed to load key words with error ",e);
            throw new RuntimeException(e);
        }

    }
}
