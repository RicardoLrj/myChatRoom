package server;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    public static void main(String[] args) throws IOException {
        ServerSocket server = new ServerSocket(10086);
        System.out.println("聊天服务器建立成功");

        Socket client = server.accept();
        System.out.println("有客户端建立连接");

        BufferedReader readClient = new BufferedReader(new InputStreamReader(client.getInputStream()));
        BufferedWriter sendClient = new BufferedWriter(new OutputStreamWriter(client.getOutputStream()));
        String line;
        while (true) {
            if ((line = readClient.readLine()) != null) {
                System.out.println(line);
            }
            sendClient.write(line);
            sendClient.newLine();
            sendClient.flush();
        }


        //server.close();
    }
}
