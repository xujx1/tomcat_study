package _3dynamic;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class HttpServer {


    private static final String SHUTDOWN_COMMAND = "/SHUTDOWN";

    private boolean shutDown = false;


    public static void main(String[] args) throws IOException {
        new HttpServer().await();
    }


    private void await() throws IOException {
        ServerSocket serverSocket = new ServerSocket(8099);

        while (!shutDown) {
            Socket socket = serverSocket.accept();

            InputStream inputStream = socket.getInputStream();
            OutputStream outputStream = socket.getOutputStream();


            Request request = new Request(inputStream);
            request.parse();

            Response response = new Response(outputStream, request);

            Processor processor;

            if (request.getUrl().startsWith("/servlet")) {
                processor = new ServletProcessor();
            } else {
                processor = new StaticResourceProcessor();
            }
            processor.process(request, response);
            socket.close();
            shutDown = request.getUrl().equals(SHUTDOWN_COMMAND);
        }
    }
}
