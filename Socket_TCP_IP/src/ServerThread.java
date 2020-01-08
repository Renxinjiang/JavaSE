import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.EOFException;
import java.io.IOException;
import java.net.Socket;
import java.util.Scanner;

public class ServerThread implements Runnable {
    private int index;
    private Socket socket;
    public ServerThread(Socket socket, int i) {
        this.socket = socket;
        this.index = i;
    }
    // 任务是为一个用户提供服务
    @Override
    public void run() {
        try {
            try {
                // 读取客户端传过来信息的DataInputStream
                DataInputStream in = new DataInputStream(socket.getInputStream());
                // 向客户端发送信息的DataOutputStream
                DataOutputStream out = new DataOutputStream(socket.getOutputStream());
                while (true) {
                    // 读取来自客户端的信息
                    String accpet = in.readUTF();
                    System.out.println("第" + index + "个客户端发出消息：" + accpet);
                    System.out.print("回复第" + index + "个客户端发出消息:");
                    Scanner scanner = new Scanner(System.in);
                    String send = scanner.nextLine();
                    out.writeUTF("服务器端回复您:" + send);
                }
            } catch (EOFException e) {//写触发异常 对方关闭连接 我却还在写
                System.out.println("对方关闭连接了");
            } finally {// 建立连接失败的话不会执行socket.close();
                socket.close();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}