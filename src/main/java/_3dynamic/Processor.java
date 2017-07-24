package _3dynamic;

import java.io.IOException;

/**
 * Created by xujinxin on 2017/7/24.
 */
public interface Processor {

    void process(Request request, Response response) throws IOException;


}
