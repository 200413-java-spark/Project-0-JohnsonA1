package com.github.johnsonadeshina.blogpost.entries;

public class Blog {

    int id;
    public String title;
    public String author;
    public String entry;
//    protected String blogPost;

    public Blog(String title, String author, String entry) {
        this.title = title;
        this.author = author;
        this.entry = entry;
    }

    public Blog(int id, String title, String author, String entry) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.entry = entry;
//        this.blogPost = blogPost;
    }

    public String[] toSqlStrings() {
        String[] blogEntry = new String[3];
        blogEntry[0] = this.title;
        blogEntry[1] = this.author;
        blogEntry[3] = this.entry;
        return blogEntry;
    }

}
