package _3dynamic;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.net.URLClassLoader;
import java.net.URLStreamHandler;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class ServletProcessor implements Processor {

    @Override
    public void process(Request request, Response response) {
        String url = request.getUrl();
        String servletName = url.substring(url.lastIndexOf("/") + 1);

        URLClassLoader loader = null;

        URL[] urls = new URL[1];

        File classPath = new File(Constants.CLASS_ROOT, servletName.concat(".java"));

        try {
            String repository = new URL("file", null, classPath.getCanonicalPath().concat(File.separator)).toString();
            urls[0] = new URL(null, repository);

            loader = new URLClassLoader(urls);

        } catch (IOException e) {
            e.printStackTrace();
        }

        try {
            Class clazz = loader != null ? loader.loadClass("_3dynamic.".concat(servletName)) : null;

            Servlet servlet = (Servlet) (clazz != null ? clazz.newInstance() : null);

            try {
                if (servlet != null) {
                    servlet.service(request, response);
                }
            } catch (ServletException | IOException e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            e.printStackTrace();
        }
    }
}
