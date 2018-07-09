package way.architect.jvm.core.memory;

public class TestAllocationMemoryCase {

    private static final int _1MB = 1024 * 1024;

    public static void testAllocation() throws InterruptedException {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[2 * _1MB];
        allocation2 = new byte[2 * _1MB];
        allocation3 = new byte[2 * _1MB];
        allocation4 = new byte[4 * _1MB];
    }

    public static void testPretenureSizeThreshold() {
        byte[] allocation = new byte[4 * _1MB];
    }

    public static void testTenuringThreshold() {
        byte[] allocation1, allocation2, allocation3, allocation4;
        allocation1 = new byte[1/4 * _1MB];
        allocation2 = new byte[1/4 * _1MB];
        allocation3 = new byte[4 * _1MB];
        allocation4 = new byte[4 * _1MB];
        allocation4 = null;
        allocation4 = new byte[4 * _1MB];
    }

    public static void main(String[] args) throws InterruptedException {
        testTenuringThreshold();
    }
}
