package com.github.johnsonadeshina.blogpost.entries;

public class BlogFactory {

    private static BlogFactory instance;

    private BlogFactory() {
    }

    public static BlogFactory getInstance() {
        if (instance == null) {
            instance = new BlogFactory();
        }
        return instance;
    }
    // Method to categorise the blog outputs


}
