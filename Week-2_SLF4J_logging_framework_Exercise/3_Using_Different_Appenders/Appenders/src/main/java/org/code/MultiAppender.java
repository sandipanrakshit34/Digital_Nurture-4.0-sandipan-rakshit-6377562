package org.code;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class MultiAppender {
    private static final Logger logger = LoggerFactory.getLogger(MultiAppender.class);

    public static void main(String[] args){
        logger.info("This is INFO log message");
        logger.debug("This is DEBUG message");
        logger.warn("This is WARNING message");
        logger.error("This is ERROR message");
    }
}
