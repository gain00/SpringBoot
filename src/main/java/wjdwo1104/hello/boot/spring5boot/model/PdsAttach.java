package wjdwo1104.hello.boot.spring5boot.model;

import lombok.*;

public class PdsAttach {

    @Setter
    @Getter
    @NoArgsConstructor
    @AllArgsConstructor
    @ToString
    public class Pds {
        private String pano;
        private String pno;
        private String fname;
        private String ftype;
        private String fsize;
        private String fdown;

    }


}
