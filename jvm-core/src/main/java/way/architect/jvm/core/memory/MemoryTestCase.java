package way.architect.jvm.core.memory;

import lombok.Data;
import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;

public class MemoryTestCase {

    private static int stackLength = 1;

    private static void heapOOM() {
        List<String> list = new ArrayList();
        while (true) {
            list.add("HelloWorld");
        }
    }

    private static void stackLeak() {
        stackLength++;
        // System.out.println("stackLength = " + stackLength);
        stackLeak();
    }

    private static void javaVmStackOOM() {
        int i=0;
        while (true) {
            System.out.println("(i++) = " + (i++));
            Thread thread = new Thread(new Runnable() {
                @Override
                public void run() {
                    stackLeak();
                }
            });
            thread.start();
        }
    }

    private static void directMemoryOOM() throws IllegalAccessException {
        int _1MB = 1024*1024;
        Field unsafeField = Unsafe.class.getDeclaredFields()[0];
        unsafeField.setAccessible(true);
        Unsafe unsafe = (Unsafe) unsafeField.get(null);
        int i=0;
        while (true) {
            System.out.println("(i++) = " + (i++));
            unsafe.allocateMemory(_1MB);
        }
    }

    public static void main(String[] args) throws IllegalAccessException {
        directMemoryOOM();
    }
}
