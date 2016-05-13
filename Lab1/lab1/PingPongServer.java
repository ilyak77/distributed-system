import rmi.*;
import java.net.*;
import java.io.*;

/**
 * @author: Yilun Zhang, Qiao Zhang
 * @date: 2016/04/26
 */

/** Test cases for the RMI library on the server side
*/

public class PingPongServer{
	public static void main(String[] args) {

		 if (args.length != 2) {
            System.err.println("Usage: java PingPongServer <host name> <port number>");
            System.exit(1);
        }

		String hostname = args[0];
		int port = Integer.parseInt(args[1]);
		try{
			PingPong pq = new PingPongImpl();
			InetSocketAddress address = new InetSocketAddress(hostname, port);
			Skeleton<PingPong> skeleton = new Skeleton(PingPong.class, pq, address);
			skeleton.start();
			System.out.println("Server starts listening...");
			System.out.println("The port number is " + port + ".");
		}catch(Exception e){
			System.err.println("server side Exception:");
	        e.printStackTrace();
		}
	}
}