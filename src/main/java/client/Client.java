package client;

import java.io.*;
import java.net.InetAddress;
import java.net.Socket;

public class Client {

    public static void main(String[] args) {
        int serverPort = 8080;
        String ip = "127.0.0.1";

        try {
            InetAddress inetAddress = InetAddress.getByName(ip);
            System.out.println("Any of you heard of a socket with IP address " + ip + " and port " + serverPort + "?");
            Socket socket = new Socket(inetAddress, serverPort);
            System.out.println("Yes! I just got hold of the program.");

            InputStream is = socket.getInputStream();
            OutputStream os = socket.getOutputStream();

            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(os));

            BufferedReader bufR = new BufferedReader(new InputStreamReader(System.in));
            String line = null;
            System.out.println("Type in something and press enter. Will send it to the server and tell ya what it thinks.");

            while (true){
                line = bufR.readLine();
                System.out.println("Sending this line to the server...");
                bw.write(line);
                bw.flush();
                line = br.readLine();
                System.out.println("The server was very polite. It sent me this : " + line);
                System.out.println("Looks like the server is pleased with us. Go ahead and enter more lines.");
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
