package _3dynamic;

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
public class Request implements ServletRequest{

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

    @Override
    public Object getAttribute(String name) {
        return null;
    }

    @Override
    public Enumeration getAttributeNames() {
        return null;
    }

    @Override
    public String getCharacterEncoding() {
        return null;
    }

    @Override
    public void setCharacterEncoding(String env) throws UnsupportedEncodingException {

    }

    @Override
    public int getContentLength() {
        return 0;
    }

    @Override
    public String getContentType() {
        return null;
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return null;
    }

    @Override
    public String getParameter(String name) {
        return null;
    }

    @Override
    public Enumeration getParameterNames() {
        return null;
    }

    @Override
    public String[] getParameterValues(String name) {
        return new String[0];
    }

    @Override
    public Map getParameterMap() {
        return null;
    }

    @Override
    public String getProtocol() {
        return null;
    }

    @Override
    public String getScheme() {
        return null;
    }

    @Override
    public String getServerName() {
        return null;
    }

    @Override
    public int getServerPort() {
        return 0;
    }

    @Override
    public BufferedReader getReader() throws IOException {
        return null;
    }

    @Override
    public String getRemoteAddr() {
        return null;
    }

    @Override
    public String getRemoteHost() {
        return null;
    }

    @Override
    public void setAttribute(String name, Object o) {

    }

    @Override
    public void removeAttribute(String name) {

    }

    @Override
    public Locale getLocale() {
        return null;
    }

    @Override
    public Enumeration getLocales() {
        return null;
    }

    @Override
    public boolean isSecure() {
        return false;
    }

    @Override
    public RequestDispatcher getRequestDispatcher(String path) {
        return null;
    }

    @Override
    public String getRealPath(String path) {
        return null;
    }

    @Override
    public int getRemotePort() {
        return 0;
    }

    @Override
    public String getLocalName() {
        return null;
    }

    @Override
    public String getLocalAddr() {
        return null;
    }

    @Override
    public int getLocalPort() {
        return 0;
    }
}
