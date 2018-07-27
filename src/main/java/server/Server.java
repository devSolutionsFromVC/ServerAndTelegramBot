package server;

import bot.TelegramBot;
import org.telegram.telegrambots.ApiContextInitializer;
import org.telegram.telegrambots.TelegramBotsApi;
import org.telegram.telegrambots.exceptions.TelegramApiRequestException;

import java.io.*;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;

public class Server {

    public static void main(String[] args) {
        ApiContextInitializer.init();
        TelegramBotsApi telegramBot = new TelegramBotsApi();
        TelegramBot bot = new TelegramBot();

        String ip = "10.1.16.203";
        try {
            telegramBot.registerBot(bot);
            InetAddress inetAddress = InetAddress.getByName(ip);
            ServerSocket serverSocket = new ServerSocket(3030, 50, inetAddress);
            while (true){
                Socket accept = serverSocket.accept();
                System.out.println("Client Accepted");
                new Thread(new SocketProcessor(accept)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (TelegramApiRequestException e) {
            e.printStackTrace();
        }
    }

    static class SocketProcessor implements Runnable {

        private Socket s;
        private InputStream is;
//        private OutputStream os;


        public SocketProcessor(Socket accept) throws IOException {
            this.s = accept;
            this.is  = accept.getInputStream();
//            this.os = accept.getOutputStream();
        }

        @Override
        public void run() {
            try {
                readData();
            } catch (IOException e) {
                e.printStackTrace();
            } finally {
                try {
                    s.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }


        public void readData() throws IOException {
            BufferedReader br = new BufferedReader(new InputStreamReader(is));
            while (true){
                String s = br.readLine();

                if(s == null || s.trim().length() == 0){
                    break;
                }
                System.out.println(s);
                System.out.println(s.split("(is|,)").length);
                String[] splitStr = s.split("(,|is)");
                HashMap<String,String> values = new HashMap<String, String>();
                for (int i = 0;i < splitStr.length - 1;i+=2) {
                    values.put(splitStr[i],splitStr[i+1]);
                }
                System.out.println(values);
                TelegramBot.getData(values);
            }
        }
    }
}
