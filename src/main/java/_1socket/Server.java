package _1socket;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xujinxin on 2017/7/24.
 * 服务器
 */
public class Server {

    public static void main(String[] args) throws IOException, InterruptedException {

        //定义一个ServerSocket监听在端口127.0.0.1:8099
        ServerSocket serverSocket = new ServerSocket(8099);

        //server尝试接收其他Socket的连接请求，server的accept方法是阻塞式的
        Socket socket = serverSocket.accept();

        //跟客户端建立好连接之后，我们就可以获取socket的InputStream，并从中读取客户端发过来的信息了
        Reader reader = new InputStreamReader(socket.getInputStream());

        char[] chars = new char[64];
        int len;
        StringBuilder builder = new StringBuilder();

        while ((len = reader.read(chars)) != -1) {
          /*  System.out.println(builder);*/
            builder.append(new String(chars, 0, len));
        }

        System.out.println("From client: " + builder);

        reader.close();
        socket.close();
        serverSocket.close();
    }
}
