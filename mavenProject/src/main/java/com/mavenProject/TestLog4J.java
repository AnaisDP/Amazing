package com.mavenProject;

import org.apache.log4j.Logger;

public class TestLog4J {
    private static final Logger LOGGER = Logger.getLogger(TestLog4J.class);

    public static void main(String[] args) {
        LOGGER.error("Hello World !");
    }
}
