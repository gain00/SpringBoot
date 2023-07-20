package wjdwo1104.hello.boot.spring5boot.mybatis;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface GalleryMapper {
    int insertGallery(Gallery g);

    int insertGalleryAttach(GalAttach ga);

    List<Gallery> selectGallery(int stnum);

    Gallery selectOneGallery(String bno);

    int selectCountGallery();

    GalAttach selectOneGalAttach(String gno);


}
