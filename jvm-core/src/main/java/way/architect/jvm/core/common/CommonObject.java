package way.architect.jvm.core.common;

import lombok.Data;

@Data
public class CommonObject {

    private String id;

    public static void main(String[] args) {
        System.out.println("new CommonObject().getId() = " + new CommonObject().getId());
    }
}
