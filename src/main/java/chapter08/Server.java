/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

/**
 *
 * @author Ameer
 */
public class Server {
    
    static Scanner scanner = new Scanner(System.in);
    Socket connection;
    ServerSocket server;
    OutputStream out;
    Writer writer;
    public Server() throws IOException
    {
        server = new ServerSocket(13);
        connection = server.accept();
        out = connection.getOutputStream();
        writer = new OutputStreamWriter(out, "ASCII");
        
    }
    
    public void sendMessage(String message)
    {
        try {
        writer.write(message);
        writer.flush();
        System.out.println("Sending message\n");
        }
        catch(IOException ex)
        {
            System.err.println("Could not send message \n "+ex);
        }
    }
    
    public static void main(String[] args)
    {
        try {
            Server server = new Server();
            while(true)
            {
            System.out.println("Waiting for input\n");
            String message = scanner.nextLine();
            server.sendMessage(message);
            }
        }
        catch(IOException ex)
        {
            
        }
        
    }
}
