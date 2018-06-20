package way.architect.jvm.core.gc;

public class ReferenceCountingGC {

    private Object instance;

    private final static int _1MB = 1024*1024;

    private byte[] bigSize = new byte[2 * _1MB];

    public static void main(String[] args) {

        // objA拥有objB引用 objB拥有objA引用 objA回收前objB需先被回收 objB回收前objA需先被回收
        ReferenceCountingGC objA = new ReferenceCountingGC();
        ReferenceCountingGC objB = new ReferenceCountingGC();
        objA.instance = objB;
        objB.instance = objA;
        objA = null;
        objB = null;
        System.gc();
    }
}
