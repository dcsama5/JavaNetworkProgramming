/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chapter08;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;

/**
 * The code doesn't easily make a request to the website. It complains about issues with the browser but maybe
 * we can return to a problem like this later?
 * @author ameer
 */
public class HTTPSocket {

    public static void main(String[] args)
    {
        try {
        Socket connection = null;
        connection = new Socket("dcsama5.tumblr.com", 80);
        Writer out = new OutputStreamWriter(connection.getOutputStream(), "8859_1");
        out.write("GET / HTTP1.1\r\n\r\n");
        out.flush();
        
        InputStream in = connection.getInputStream();
        BufferedReader reader = new BufferedReader(new InputStreamReader(in, "UTF-8"));
        String str;

        do
        {

            str = reader.readLine();
            System.out.println(str);
        }
        while(str!=null);
        }
        catch(IOException ex)
        {
            
        }
    }
}
