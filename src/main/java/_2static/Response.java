package _2static;

import java.io.*;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class Response {

    public static final String WEB_ROOT =
            System.getProperty("user.dir").concat(File.separator).
                    concat("src").concat(File.separator).
                    concat("main").concat(File.separator).
                    concat("webapp").concat(File.separator);
    private static final Integer BUFFER_SIZE = 1024;

    private OutputStream outputStream;

    private Request request;

    Response(OutputStream outputStream, Request request) {
        this.outputStream = outputStream;
        this.request = request;
    }

    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];

        //读取请求的url的静态文件
        File file = new File(WEB_ROOT, request.getUrl());

        //如果文件存在，就返回文件的内容
        if (file.exists()) {
            //读取文件的内容
            FileInputStream fileInputStream = new FileInputStream(file);

            int ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);

            while (ch != -1) {
                outputStream.write(bytes, 0, ch);
                ch = fileInputStream.read(bytes, 0, BUFFER_SIZE);
            }
        } else {
            //文件不存在，返回404
            String errorMessage = "404";

            outputStream.write(errorMessage.getBytes());
        }
    }
}
