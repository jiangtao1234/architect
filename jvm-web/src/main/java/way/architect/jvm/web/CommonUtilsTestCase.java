package way.architect.jvm.web;

import way.architect.jvm.core.common.CommonUtils;

public class CommonUtilsTestCase {

    public static void main(String[] args) {
        String ping = CommonUtils.ping("HelloWorld");
        System.out.println("ping = " + ping);
    }

}
