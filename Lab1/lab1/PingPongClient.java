import rmi.*;
import java.net.*;
import java.io.*;

/**
 * @author: Yilun Zhang, Qiao Zhang
 * @date: 2016/04/26
 */

/** Test cases for the RMI library on the client side
*/

public class PingPongClient{
	public static void main(String[] args) {
		if (args.length != 2) {
            System.err.println("Usage: java PingPongClient <host name> <port number>");
            System.exit(1);
        }

		String hostname = args[0];
		int port = Integer.parseInt(args[1]);

		try{
			
		    InetSocketAddress address = new InetSocketAddress(hostname, port);
            PingPong pq = Stub.create(PingPong.class, address);
            /*test 1*/
            System.out.println("Client pinging server for the first time...");
			System.out.println("The integer number is " + 100 + ".");
        	String s = pq.ping(100);
        	System.out.println("The result returned by server is:");
		    System.out.println(s);
		    /*test 2*/
            System.out.println("Client pinging server for the second time...");
			System.out.println("The integer number is " + 2016 + ".");
        	s = pq.ping(2016);
        	System.out.println("The result returned by server is:");
		    System.out.println(s); 
           
		}catch (Exception e){
            System.err.println("Client side Exception:");
            e.printStackTrace();
        }catch(Throwable t){
        	System.out.println("throwable in client side");
        }
		
	}
}