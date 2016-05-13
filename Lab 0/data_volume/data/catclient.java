import java.io.*;
import java.net.*;

public class catclient {
    public static void main(String[] args) throws IOException {
        
        if (args.length != 2) {
            System.err.println(
                "Usage: java catclient <file path> <port number>");
            System.exit(1);
        }

        String hostName = "127.0.0.1";
        String filePath = args[0];
        int portNumber = Integer.parseInt(args[1]);

        try (
            Socket echoSocket = new Socket(hostName, portNumber);
            PrintWriter out =
                new PrintWriter(echoSocket.getOutputStream(), true);
            BufferedReader in =
                new BufferedReader(
                    new InputStreamReader(echoSocket.getInputStream()));
          
        ) {
           
            for(int i = 0; i<10; i++) {
                out.println("LINE\n");
                String echo = in.readLine().toLowerCase();
              //  System.out.println("echo: " + echo);

                boolean status = inText(echo,filePath);
                if(status){
                    System.out.println("OK");
                }else{
                    System.out.println("MISSING");
                }

                echo = in.readLine();
                Thread.sleep(3000);
            }
        } catch (UnknownHostException e) {
            System.err.println("Don't know about host " + hostName);
            System.exit(1);
        } catch (IOException e) {
            System.err.println("Couldn't get I/O for the connection to " +
                hostName);
            System.exit(1);
        } catch (InterruptedException e) {
            System.err.println("Thread be iterrupted");
        }
    }

    private static boolean inText(String line, String filePath){
        try{
           FileInputStream fstream = new FileInputStream(filePath);
           BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

           String cur = br.readLine();

           while(cur !=null){
             if(cur.equals(line)) return true;
             cur = br.readLine();
           }

        }catch(IOException e){
            System.err.println("Couldn't get I/O for the connection to " +
                "echoElient");
            System.exit(1);
        }

        
        return false; 
        
    }
}