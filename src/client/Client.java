package client;

import java.io.*;
import java.net.Socket;

public class Client {
    public static void main(String[] args) throws IOException {
        Socket client = new Socket("127.0.0.1", 10086);
        BufferedReader readServer = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter sendServer = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String line;
        while (true) {

            System.out.println("自己：");
            line = br.readLine();
            sendServer.write(line);
            sendServer.newLine();
            sendServer.flush();
        }


        //client.close();
    }
}
