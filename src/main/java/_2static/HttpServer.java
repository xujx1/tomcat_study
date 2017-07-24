package _2static;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.InetAddress;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xujinxin on 2017/7/24.
 * 服务器
 */
public class HttpServer {


    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutDown = false;


    public void await() throws IOException {
        //建立socket连接
        ServerSocket serverSocket = new ServerSocket(8099, 1, InetAddress.getByName("127.0.0.1"));

        while (!shutDown) {
            //获取客户端的输入
            Socket socket = serverSocket.accept();

            //获取客户端的输入流
            InputStream inputStream = socket.getInputStream();
            //写客户端的输出流
            OutputStream outputStream = socket.getOutputStream();

            //解析请求信息
            Request request = new Request(inputStream);

            request.parse();

            //组织响应信息
            Response response = new Response(outputStream, request);
            response.sendStaticResource();

            socket.close();
            shutDown = request.getUrl().equals(SHUTDOWN_COMMAND);
        }

    }

    public static void main(String[] args) throws IOException {

        HttpServer httpServer = new HttpServer();

        httpServer.await();
    }


}
