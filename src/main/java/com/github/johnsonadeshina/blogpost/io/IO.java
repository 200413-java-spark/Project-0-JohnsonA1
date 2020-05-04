package com.github.johnsonadeshina.blogpost.io;

import com.github.johnsonadeshina.blogpost.entries.Blog;
import com.github.johnsonadeshina.blogpost.entries.BlogFactory;
import com.github.johnsonadeshina.blogpost.operations.BlogOps;

import java.io.*;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class IO {

    File file;

    public IO() {
        file = new File("blog.csv");
    }

    public IO(String s) {
        file = new File(s);
    }

    public static IO fileSetup(String s) {
        IO fileIO;
        if(s.length() == 0) {
            fileIO = new IO();
        } else {
            fileIO = new IO(s);
        }
        return fileIO;
    }

    public void write(String blogPosts) {

        try(PrintWriter writer = new PrintWriter(this.file);) {
            writer.print(blogPosts);
            writer.close();
            System.out.println("File write successful");
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
        }

    }

    public void read(LinkedList<Blog> blogPosts) {

        try(FileReader in = new FileReader(file);
            BufferedReader reader = new BufferedReader(in);) {
            String line = "";
            String[] outputs = new String[3];
            while((line = reader.readLine()) != null) {

//                String[] s = new String[3];
//                s = line.split(",");
                outputs[0] = reader.readLine();
                outputs[1] = reader.readLine();
                outputs[2] = reader.readLine();

                Blog blog = BlogOps.presetParse(outputs[0], outputs[1], outputs[2]);
                BlogOps.add(blog, blogPosts);
            }

            System.out.println("Successfully read file into blog");

        } catch (FileNotFoundException e) {
            System.out.println("File not found");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
