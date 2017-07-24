package _3dynamic;

import java.io.File;

/**
 * Created by xujinxin on 2017/7/24.
 */
public class Constants {

    public static final String WEB_ROOT =
            System.getProperty("user.dir").concat(File.separator).
                    concat("src").concat(File.separator).
                    concat("main").concat(File.separator).
                    concat("webapp").concat(File.separator);


    public static final String CLASS_ROOT =
            System.getProperty("user.dir").concat(File.separator).
                    concat("src").concat(File.separator).
                    concat("main").concat(File.separator).
                    concat("java").concat(File.separator).
                    concat("_3dynamic").concat(File.separator);
}
