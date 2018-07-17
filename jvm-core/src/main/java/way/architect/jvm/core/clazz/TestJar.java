package way.architect.jvm.core.clazz;


import org.apache.commons.lang3.StringUtils;

public class TestJar {

    public static void main(String[] args) {
        System.out.println("args = " + args[0]);
        System.out.println("StringUtils.equals(\"HelloWorld\", args[0]) = " + StringUtils.equals("HelloWorld", args[0]));
    }
}
