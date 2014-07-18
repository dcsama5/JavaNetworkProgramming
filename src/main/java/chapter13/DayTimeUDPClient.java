/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package chapter13;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.SocketException;

/**
 *
 * @author Ameer
 */
public class DayTimeUDPClient {
    
    private final static int PORT = 13;
    private static final String HOSTNAME = "time.nist.gov";
    
    public static void main(String[] args) throws SocketException
    {
        try (DatagramSocket socket = new DatagramSocket(0))
        {
            socket.setSoTimeout(1000);
            InetAddress host = InetAddress.getByName(HOSTNAME);
            DatagramPacket request = new DatagramPacket(new byte[1], 1, host, PORT);
            DatagramPacket response = new DatagramPacket(new byte[1024], 1024);
            socket.send(request);
            socket.receive(response);
            String result = new String(response.getData(), 0, response.getLength(),"ASCII");
            System.out.println(result);
        }
        catch(IOException ex) {
            ex.printStackTrace();
        }
    }
}
