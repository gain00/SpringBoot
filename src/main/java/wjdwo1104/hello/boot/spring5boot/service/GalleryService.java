package wjdwo1104.hello.boot.spring5boot.service;


import java.util.List;

public interface GalleryService {

        List<Gallery> readGallery(int stnum);
        //List<Gallery>갤러리부분 모델-> 알트엔터로 구현 readGallery(Integer cpg);

        int countGallery();

}
