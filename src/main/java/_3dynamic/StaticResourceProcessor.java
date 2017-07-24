package _3dynamic;

import java.io.IOException;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class StaticResourceProcessor implements Processor {

    @Override
    public void process(Request request, Response response) throws IOException {
        response.sendStaticResource();
    }

}
