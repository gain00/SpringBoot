package wjdwo1104.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;
import wjdwo1104.hello.boot.spring5boot.model.GalAttach;
import wjdwo1104.hello.boot.spring5boot.model.Gallery;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int insertGallery(Gallery g);

    List<Gallery> selectGallery(int stnum);

    Gallery selectOneGallery(String bno);

    int selectCountGallery();

    GalAttach selectOneGalAttach(String gno);


    int lastGalGno();

    int insertGalAttach(GalAttach ga);
}
