package com.github.johnsonadeshina.blogpost.operations;

import com.github.johnsonadeshina.blogpost.entries.Blog;
import com.github.johnsonadeshina.blogpost.io.IO;
import com.github.johnsonadeshina.blogpost.io.SQLBlogRepo;


import java.util.LinkedList;
import java.util.Scanner;

public class Operation {

    public Operation() {
    }

    public static void menu(LinkedList<Blog> blogPosts) {

        String next = "";
        Scanner input = new Scanner(System.in);

        while(!next.equals("exit")) {
            next = input.nextLine();
            if(next.equals("add")) {
                Blog nextAddition = BlogOps.inquiry(input);
                BlogOps.add(nextAddition, blogPosts);
            }
            else if(next.equals("remove")) {
                BlogOps.remove(blogPosts, input);

            }
            else if(next.equals("show all items")) {
                BlogOps.showAll(blogPosts, true);
            }
            else if(next.equals("help")) {
                help();
            }
            else if(next.equals("write to file")){

                String blogPost = BlogOps.showAll(blogPosts, false);
                System.out.println("Enter file name: (Blank for default=blog.csv)");
                next = input.nextLine();
                IO fileIO = IO.fileSetup(next);
                fileIO.write(blogPost);
            }
            else if(next.equals("read from file")) {
                System.out.println("Enter file name: (Blank for default=blog.csv)");
                next = input.nextLine();
                IO fileIO = IO.fileSetup(next);
                fileIO.read(blogPosts);
            }
            else if(next.equals("write to database")) {
                String blogPost = BlogOps.showAll(blogPosts, false);
                SQLBlogRepo.writeAll(blogPost);
            }
            else if(next.equals("read from database")) {
                SQLBlogRepo.ReadAll();
            }
            else if(next.equals("exit")) {}
            else {
                System.out.println("Command not recognized. Use 'help' for command list.");
            }
        }

        input.close();

    }

    public static void help() {
        System.out.println("'add' : Add a new agenda item by following prompts.");
        System.out.println("'show all items' : Print all items currently saved in blog post");
        System.out.println("'exit' : Quit and exit program.");
        System.out.println("--------IO--------");
        System.out.println("read from file");
        System.out.println("write to file");
        System.out.println("read from database");
        System.out.println("write to database");
    }


}
