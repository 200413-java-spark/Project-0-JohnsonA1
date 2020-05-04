package com.github.johnsonadeshina.blogpost.operations;

import com.github.johnsonadeshina.blogpost.entries.Blog;

import java.util.Iterator;
import java.util.LinkedList;
import java.util.Scanner;

public class BlogOps {

    // Asks user for input in order to build a Blog to be added to the blog post structure
    public static Blog inquiry(Scanner input) {
        try {
            System.out.println("Input title of the new blog: ");
            String title = input.nextLine();

            System.out.println("Input author of the new blog: ");
            String author = input.nextLine();

            System.out.println("Input entry for the blog: ");
            String entry = input.nextLine();
            Blog blogPost = new Blog(title, author, entry);
            return blogPost;
        }
        catch(NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Please follow specified format.");
            return null;
        }
    }

    // Used for building Blog posts via file and for testing purposes
    // Expected input title, author, entry
    public static Blog presetParse(String title, String author, String entry) {

        Blog blogPost = new Blog(title, author, entry);
        return blogPost;
    }

    // Adds the supplied blog entry to the supplied blog posts
    public static void add(Blog blog, LinkedList<Blog> blogPosts) {
        Iterator<Blog> iter = blogPosts.iterator();
        int i = 0;
        while(blog != null) {
            if(!iter.hasNext()) {
                blogPosts.addLast(blog);
                blog = null;
            }
            else {
                Blog tmp = iter.next();
                if(tmp.title == blog.title) {
                    if(tmp.title == blog.title && tmp.author == blog.author || tmp.title != blog.title) {
                        blogPosts.add(i, blog);
                        blog = null;
                    }

                }
            }
            i++;
        }
        return;
    }

    public static void remove(LinkedList<Blog> blogPosts, Scanner input) {
        String[] list = showAll(blogPosts, false).split(",");

        for (int i = 0; i < (list.length / 2); i++) {
            System.out.println(i + " - " + list[i]);

        }
        System.out.println("Enter index to be removed:");
        try{
            blogPosts.remove(Integer.parseInt(input.nextLine()));
        } catch(NumberFormatException | StringIndexOutOfBoundsException e) {
            System.out.println("Input index of item to be removed");
        }

    }

    // Prints to console and returns an Strings of all items in the blog post
    public static String  showAll(LinkedList<Blog> blogPosts, boolean consoleOutput) {
        String text = new String();
        int blogLength = blogPosts.size();
        int currentPosition = 0;
        Iterator<Blog> iter = blogPosts.iterator();
        while(iter.hasNext()) {
            currentPosition += 1;
            Blog blog = iter.next();
            if(currentPosition == blogLength){
                text += blog.title + ", " + blog.author +", " + blog.entry ;
            }
            else {
                text += blog.title + ", " + blog.author + ", " + blog.entry + ",";
            }

        }
        if(consoleOutput == true){
//            printStrings(list);
            printStrings(text);
        }
        return text;
    }

    // Prints the ArrayLists provided by show methods
    private static void printStrings(String list) {
        System.out.println(list);
        return;
    }

}
