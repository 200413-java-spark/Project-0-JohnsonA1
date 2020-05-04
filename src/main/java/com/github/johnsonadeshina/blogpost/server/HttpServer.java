package com.github.johnsonadeshina.blogpost.server;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HttpServer {

    public void listen(){
        ServerSocket serverSocket = null;
        try{
            serverSocket = new ServerSocket(8080);
        } catch(IOException e){
            System.err.println(e.getMessage());
            System.exit(1);
        }

        while(true){
            try{
                Socket socket = serverSocket.accept();
                InputStream input = socket.getInputStream();
                OutputStream output = socket.getOutputStream();
                // Read the request
                byte[] buffer = new byte[2048];
                int size = input.read(buffer);
                StringBuffer request = new StringBuffer(2048);
                for(int i = 0; i < size; i++){
                    request.append((char)buffer[i]);
                }
                System.out.println(request.toString());

                // Write the response
                StringBuffer response = new StringBuffer();
                String message = "<h1>Your Blog Post is: Title= Happy Author= James Entry= Walking the dog</h1>";
                response.append("HTTP/1.1 200 Success\r\n"
                        + "Content-Type: text/html\r\n"
                        + "Content-Length: ");
                response.append(message.length());
                response.append("\r\n\r\n");
                response.append(message);
                byte[] bytes = response.toString().getBytes();
                output.write(bytes);
            } catch(IOException e){
                System.err.println(e.getMessage());
                System.exit(1);
            }
        }
    }
}
