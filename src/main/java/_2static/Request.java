package _2static;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletInputStream;
import javax.servlet.ServletRequest;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.util.Enumeration;
import java.util.Locale;
import java.util.Map;

/**
 * Created by xujinxin on 2017/7/24.
 */
@SuppressWarnings("Duplicates")
public class Request {

    private InputStream inputStream;

    private String url;

    Request(InputStream inputStream) {
        this.inputStream = inputStream;
    }


    public void parse() throws IOException {

        //解析请求信息
        StringBuilder request = new StringBuilder(2048);

        int i;
        byte[] buffer = new byte[2048];

        i = inputStream.read(buffer);

        for (int j = 0; j < i; j++) {
            request.append((char) buffer[j]);
        }
/*        System.out.println(request);*/

        this.url = parseUrl(request.toString());
    }


    public String getUrl() {
        return url;
    }

    private String parseUrl(String request) {

        //硬编码解析出访问的url信息:index.jsp
        String url = "";

        int idx1, idx2;

        idx1 = request.indexOf(" ");

        if (idx1 != -1) {
            idx2 = request.indexOf(" ", idx1 + 1);

            if (idx2 > idx1) {
                url = request.substring(idx1 + 1, idx2);
            }
        }
        return url;
    }
}
