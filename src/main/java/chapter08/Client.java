/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter08;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.Reader;
import java.io.Writer;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author Ameer
 */
public class Client {
    
    public static void main(String[] args)
    {
        try{
        Socket connection = new Socket("localhost", 13);
        InputStream in = connection.getInputStream();
        OutputStream out = connection.getOutputStream();
//        Writer writer = new OutputStreamWriter(out, "ASCII");
        Reader reader = new InputStreamReader(in);
        int chara = reader.read();
        System.out.println((char)chara);
        while(chara!=-1)
        {   
           System.out.print((char)reader.read());
           
        }
        System.out.println("done");
        }
        catch(UnknownHostException uh)
        {
            
        }
        catch(IOException io)
        {
            
        }
    }
    
}
