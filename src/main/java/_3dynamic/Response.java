package _3dynamic;

import javax.servlet.ServletOutputStream;
import javax.servlet.ServletResponse;
import java.io.*;
import java.util.Locale;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class Response implements ServletResponse {

    private OutputStream outputStream;
    private Request request;
    private static final int BUFFER_SIZE = 1024;

    Response(OutputStream outputStream, Request request) {
        this.outputStream = outputStream;
        this.request = request;
    }


    public void sendStaticResource() throws IOException {
        byte[] bytes = new byte[BUFFER_SIZE];

        File file = new File(Constants.WEB_ROOT, request.getUrl());

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


    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletOutputStream getOutputStream() throws IOException {
        return null;
    }

    @Override
    public PrintWriter getWriter() throws IOException {
        return new PrintWriter(outputStream, true);
    }

    @Override
    public void setCharacterEncoding(String s) {

    }

    @Override
    public void setContentLength(int i) {

    }

    @Override
    public void setContentType(String s) {

    }

    @Override
    public void setBufferSize(int i) {

    }

    @Override
    public int getBufferSize() {
        return 0;
    }

    @Override
    public void flushBuffer() throws IOException {

    }

    @Override
    public void resetBuffer() {

    }

    @Override
    public boolean isCommitted() {
        return false;
    }

    @Override
    public void reset() {

    }

    @Override
    public void setLocale(Locale locale) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }
}
