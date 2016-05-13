import java.net.*;
import java.io.*;

public class catserver {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println("Usage: java catserver <file Path><port number>");
            System.exit(1);
        }
        
        int portNumber = Integer.parseInt(args[1]);
        String filePath = args[0];
        
        try {
            ServerSocket serverSocket =
                new ServerSocket(portNumber);
            Socket clientSocket = serverSocket.accept();     
            PrintWriter out =
                new PrintWriter(clientSocket.getOutputStream(), true);                   
            BufferedReader in = new BufferedReader(
                new InputStreamReader(clientSocket.getInputStream()));
        
            FileInputStream fstream = new FileInputStream(filePath);
            BufferedReader br = new BufferedReader(new InputStreamReader(fstream));
            String cur = br.readLine();
            while (in.readLine() != null){
                out.println(cur);
                out.println();
                cur = br.readLine();
                if(cur == null){
                   fstream = new FileInputStream(filePath);
                   br = new BufferedReader(new InputStreamReader(fstream));
                   cur = br.readLine();
                }
            }
        } catch (IOException e) {
            System.out.println("Exception caught when trying to listen on port "
                + portNumber + " or listening for a connection");
            System.out.println(e.getMessage());
        }
    }
}