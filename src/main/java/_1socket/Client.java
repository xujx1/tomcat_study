package _1socket;

import java.io.*;
import java.net.Socket;

/**
 * Created by xujinxin on 2017/7/24.
 * 客户端
 */
public class Client {

    public static void main(String[] args) throws IOException, InterruptedException {

        //与服务端建立连接
        Socket socket = new Socket("127.0.0.1", 8099);

        //建立连接后就可以往服务端写数据了
        Writer writer = new OutputStreamWriter(socket.getOutputStream());

        writer.write("Hello");

        //写完后要记得flush
        writer.flush();

        writer.close();
        socket.close();
    }
}
