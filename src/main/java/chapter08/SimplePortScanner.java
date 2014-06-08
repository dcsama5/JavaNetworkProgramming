/*
* To change this license header, choose License Headers in Project Properties.
* To change this template file, choose Tools | Templates
* and open the template in the editor.
*/

package chapter08;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

/**
 *
 * @author ameer
 */
public class SimplePortScanner {
    String[] ips = {"192.168.1.254", "222"};
    
    public static void main(String[] args)
    {
        String ip = "192.168.1.";
        for(int ipstart =2; ipstart<=10; ipstart++)
        {
            String ipconcat = ip+ipstart;
            System.out.println("checking " + ipconcat);
            for(int i=1; i<1024; i++)
            {
                try  {
                    Socket s = new Socket(ipconcat, i);
                    s.setSoTimeout(300);
                    s.close();
                    System.out.println("there is a server on port "+i+ "of "+ipconcat);
                }
                catch(UnknownHostException ex)
                {
                    ex.printStackTrace();
                }
                catch(IOException ex2)
                {
                    ex2.printStackTrace();
                }
                
            }
        }
    }
}