package com.github.johnsonadeshina.blogpost;

import com.github.johnsonadeshina.blogpost.entries.Blog;
import com.github.johnsonadeshina.blogpost.io.BlogDAO;
import com.github.johnsonadeshina.blogpost.io.IO;
import com.github.johnsonadeshina.blogpost.io.SQLBlogRepo;
import com.github.johnsonadeshina.blogpost.io.SQLDataSource;
import com.github.johnsonadeshina.blogpost.operations.Operation;
import com.github.johnsonadeshina.blogpost.server.HttpServer;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

public class MainBlog {

    public static void main(String[] args){
        LinkedList<Blog> blogPosts = new LinkedList<Blog>();
        if(args.length > 0) {

            if(args[0].equals("-r")) {
                IO fileIO;
                if(args.length > 1) {
                    fileIO = new IO(args[1]);
                } else {
                    fileIO = new IO();
                }
                fileIO.read(blogPosts);
            }

            if(args[0].equals("-db")) {
                SQLBlogRepo.ReadAll();
            }
        }

        Operation.menu(blogPosts);
    }
}
