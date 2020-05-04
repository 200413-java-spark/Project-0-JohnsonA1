package com.github.johnsonadeshina.blogpost.io;

import com.github.johnsonadeshina.blogpost.entries.Blog;
import com.github.johnsonadeshina.blogpost.entries.BlogFactory;
import com.github.johnsonadeshina.blogpost.operations.BlogOps;

import java.sql.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;

public class SQLBlogRepo {

    private static SQLDataSource dataSource;

    public SQLBlogRepo(SQLDataSource dataSource) {
        this.dataSource = dataSource;
    }

    public static void writeAll(String blogPosts) {

        String blogEntry[] = blogPosts.split(",");

        dataSource = SQLDataSource.getInstance();
        String sql = "insert into blogs(title, author, entry) values(?, ?, ?)";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement statement = connection.prepareStatement(sql);
             Statement rmStatement = connection.createStatement();) {
            rmStatement.execute("delete from blogs;");
            for  (String s : blogEntry) {
                statement.setString(1, blogEntry[0]);
                statement.setString(2,blogEntry[1]);
                statement.setString(3,blogEntry[2]);
                statement.addBatch();
            }
            statement.executeBatch();
            System.out.println("Successfully wrote to database");
        } catch (SQLException ex) {
            System.out.println(ex.getMessage());
            System.out.println("Failed to write to database");
        }
    }

    public static  void ReadAll() {
        String record = "";

        dataSource = SQLDataSource.getInstance();
        try {
            Class.forName("org.mariaDB.Driver");
        } catch (java.lang.ClassNotFoundException e) {
            System.out.println(e.getMessage());
        }
        try(Connection conn = dataSource.getConnection();) {
            Statement statement = conn.createStatement();
            ResultSet rs = statement.executeQuery("select * from blogs;");
            while(rs.next()) {
                String[] args = new String[3];

                args[0] = rs.getString("title");
                args[1] = rs.getString("author");
                args[2] = rs.getString("entry");
               record += args[0] + ", " + args[1] + ", " + args[2];

            }
            System.out.println("Successfully read from database");
            System.out.println(record);
        } catch (SQLException e) {
            System.out.println("Failed to read from database");
        }

        return;
    }


}
