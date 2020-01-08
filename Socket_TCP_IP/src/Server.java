import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

public class Server {
    // 提供服务
    public void service() {
        int i = 1;
        try {
            // 建立服务器连接
            ServerSocket tcpServerSocket = new ServerSocket(8080);
            while (true) {
                // 等待客户连接
                Socket clientSocket = tcpServerSocket.accept();
                System.out.println("第" + i + "个客户连接成功！");
                new Thread(new ServerThread(clientSocket, i)).start();
                i++;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void main(String[] args) {
        new Server().service();
    }
}