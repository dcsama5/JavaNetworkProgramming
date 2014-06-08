/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chapter08;

import java.io.IOException;
import java.io.InputStream;
import java.net.Socket;

/**
 *
 * @author ameer
 */
public class SimpleSocket {
 public static void main(String[] args) throws IOException
 {
     Socket socket = null;
     try {
     socket = new Socket("time.nist.gov", 13);
     InputStream io = socket.getInputStream();
     String string = null;
     int c = io.read();
     int inc = 0;
     while(c != -1)
     {
         string = string + (char) c;
         c = io.read();
         inc++;
     }     
     System.out.println(string + "\n" + inc + " lines");
     }
     catch(IOException ex) {
             System.err.println(ex);
             }
     finally {
         System.out.println("closing connection");
         socket.close();
     }
 }
}
